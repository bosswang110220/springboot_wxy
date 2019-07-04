package com.wxy.bigdata.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wxy.bigdata.entity.Shop;
import com.wxy.bigdata.enums.RetrunCode;
import com.wxy.bigdata.service.ShopService;
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

/**
 * @program: bigdata
 * @description:商家控制类
 * @author: Mr.Wang
 * @create: 2019-07-03 17:14
 **/

@RestController
@RequestMapping(value = "shop")
public class ShopController {

    // 创建线程安全的Map
    static Map<Long, Shop> shopMap = Collections.synchronizedMap(new HashMap<Long, Shop>());


    @Autowired
    private ShopService shopService;


    @ApiOperation(value = "获取用户列表", notes = "获取系统所有用户")
    @GetMapping(value = "list")
    public JsonResult users() {
        JsonResult jsonResult = new JsonResult();
        PageHelper.startPage(1, 2);
        List<Shop> s = shopService.selectAll();
        PageInfo<Shop> pageInfo = new PageInfo<Shop>(s);
        jsonResult.setResult(pageInfo);
        jsonResult.setMsg(RetrunCode.OK.getValue());
        jsonResult.setStatus(RetrunCode.OK.getKey());
        return jsonResult;
    }


    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public JsonResult edit(@PathVariable(value = "id") Long id) {
        JsonResult jsonResult = new JsonResult();
        Shop s = shopService.selectByPrimaryKey(id);
        jsonResult.setResult(s);
        jsonResult.setMsg(RetrunCode.OK.getValue());
        jsonResult.setStatus(RetrunCode.OK.getKey());
        return jsonResult;
    }


    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public JsonResult delete(@PathVariable(value = "id") Long id) {
        JsonResult r = new JsonResult();
        try {
            int shop = shopService.deleteByPrimaryKey(id);
            r.setResult(shop);
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
     *
     * @param shop
     * @return
     */
    @ApiOperation(value = "创建菜品", notes = "根据Food对象创建菜品")
    @ApiImplicitParam(name = "food", value = "用户详细实体shop", required = true, dataType = "User")
    @RequestMapping(value = "shop", method = RequestMethod.POST)
    public JsonResult add(@RequestBody Shop shop) {
        JsonResult r = new JsonResult();
        try {
            Shop s = shopMap.put(shop.getId(), shop);
            r.setResult(s);
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
     *
     * @param shop
     * @return
     */
    @ApiOperation(value = "更新信息", notes = "根据url的id来指定更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "菜品id", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "shop", value = "菜品实体shop", required = true, dataType = "User")
    })
    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public JsonResult update(@PathVariable("id") Long id, @RequestBody Shop shop) {
        JsonResult r = new JsonResult();
        try {
            Shop s = shopService.selectByPrimaryKey(id);
            s.setName(shop.getName());
            Shop shops= shopMap.put(id, s);
            shopService.updateByPrimaryKey(shops);
            r.setResult(s);
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
