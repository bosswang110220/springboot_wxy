package com.wxy.bigdata.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wxy.bigdata.entity.User;
import com.wxy.bigdata.enums.RetrunCode;
import com.wxy.bigdata.service.UserService;
import com.wxy.bigdata.utils.JsonResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "user")
public class UserController {

    // 创建线程安全的Map
    static Map<Integer, User> users = Collections.synchronizedMap(new HashMap<Integer, User>());


    @Autowired
    private UserService userService;

    @ApiOperation(value="获取用户列表", notes="获取系统所有用户")
    @GetMapping(value = "list")
    public JsonResult users() {
        JsonResult jsonResult=new JsonResult();
        PageHelper.startPage(1, 2);
        List<User> bookList = userService.selectAll();
        PageInfo<User> pageInfo = new PageInfo<User>(bookList);
        jsonResult.setResult(pageInfo);
        jsonResult.setMsg(RetrunCode.OK.getValue());
        jsonResult.setStatus(RetrunCode.OK.getKey());
        return  jsonResult;
    }




    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "getUser/{id}", method = RequestMethod.GET)
    public JsonResult getUserById (@PathVariable(value = "id") Integer id) {
        JsonResult jsonResult=new JsonResult();
        User user=userService.selectByPrimaryKey(id);
        jsonResult.setResult(user);
        jsonResult.setMsg(RetrunCode.OK.getValue());
        jsonResult.setStatus(RetrunCode.OK.getKey());
       return jsonResult;
    }


    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @ApiOperation(value="删除用户", notes="根据url的id来指定删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public JsonResult delete (@PathVariable(value = "id") Integer id){
        JsonResult r = new JsonResult();
        try {
            int i = userService.deleteByPrimaryKey(id);
            r.setResult(i);
            r.setMsg(RetrunCode.OK.getValue());
            r.setStatus(RetrunCode.OK.getKey());
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus(RetrunCode.BAD_REQUEST.getKey());
            e.printStackTrace();
        }
        return r;
    }


    /**
     * 添加用户
     * @param user
     * @return
     */
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public JsonResult add (@RequestBody User user){
        JsonResult r = new JsonResult();
        try {
            User u = users.put(user.getId(), user);
            r.setResult(u);
            r.setMsg(RetrunCode.OK.getValue());
            r.setStatus(RetrunCode.OK.getKey());
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus(RetrunCode.BAD_REQUEST.getKey());

            e.printStackTrace();
        }
        return r;
    }


    /**
     * 根据id修改用户信息
     * @param user
     * @return
     */
    @ApiOperation(value="更新信息", notes="根据url的id来指定更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public JsonResult update (@PathVariable("id") Integer id, @RequestBody User user){
        JsonResult r = new JsonResult();
        try {
            User u = userService.selectByPrimaryKey(id);
            u.setUsername(user.getUsername());
            User record = users.put(id, u);
            userService.updateByPrimaryKey(record);
            r.setResult(u);
            r.setMsg(RetrunCode.OK.getValue());
            r.setStatus(RetrunCode.OK.getKey());
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus(RetrunCode.BAD_REQUEST.getKey());

            e.printStackTrace();
        }
        return r;
    }




    }
