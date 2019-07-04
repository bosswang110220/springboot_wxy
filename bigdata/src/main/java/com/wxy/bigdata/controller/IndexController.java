package com.wxy.bigdata.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @program: bigdata
 * @description: 首页跳转控制类
 * @author: Mr.Wang
 * @create: 2019-07-04 16:57
 **/
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        Object user = SecurityUtils.getSubject().getSession().getAttribute("user");
        System.out.print(user);
        return "index";
    }
}
