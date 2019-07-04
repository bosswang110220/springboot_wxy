package com.wxy.bigdata.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wxy.bigdata.entity.Order;
import com.wxy.bigdata.enums.RetrunCode;
import com.wxy.bigdata.service.OrderService;
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
 * @description:菜品控制类
 * @author: Mr.Wang
 * @create: 2019-07-03 17:14
 **/

@RestController
@RequestMapping(value = "order")
public class OrderController {

    // 创建线程安全的Map
    static Map<Long, Order> orderMap = Collections.synchronizedMap(new HashMap<Long, Order>());


    @Autowired
    private OrderService orderService;


    @ApiOperation(value = "获取用户列表", notes = "获取系统所有用户")
    @GetMapping(value = "list")
    public JsonResult users() {
        JsonResult jsonResult = new JsonResult();
        PageHelper.startPage(1, 2);
        List<Order> o = orderService.selectAll();
        PageInfo<Order> pageInfo = new PageInfo<Order>(o);
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
        Order o = orderService.selectByPrimaryKey(id);
        jsonResult.setResult(o);
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
            int o = orderService.deleteByPrimaryKey(id);
            r.setResult(o);
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
     * @param order
     * @return
     */
    @ApiOperation(value = "创建菜品", notes = "根据Food对象创建菜品")
    @ApiImplicitParam(name = "order", value = "用户详细实体order", required = true, dataType = "User")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public JsonResult add(@RequestBody Order order) {
        JsonResult r = new JsonResult();
        try {
            Order o = orderMap.put(order.getId(), order);
            r.setResult(o);
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
     * @param order
     * @return
     */
    @ApiOperation(value = "更新信息", notes = "根据url的id来指定更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "菜品id", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "order", value = "菜品实体order", required = true, dataType = "User")
    })
    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public JsonResult update(@PathVariable("id") Long id, @RequestBody Order order) {
        JsonResult r = new JsonResult();
        try {
            Order odr = orderService.selectByPrimaryKey(id);
            odr.setOrderstatus(order.getOrderstatus());
            Order o = orderMap.put(id, odr);
            orderService.updateByPrimaryKey(o);
            r.setResult(odr);
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
