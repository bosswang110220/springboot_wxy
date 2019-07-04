package com.wxy.bigdata.controller;

import com.wxy.bigdata.entity.User;
import com.wxy.bigdata.service.UserService;
import com.wxy.bigdata.utils.JsonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @program: bigdata
 * @description: 登录控制器
 * @author: Mr.Wang
 * @create: 2019-07-04 14:56
 **/

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    @PostMapping("/login")
    @ResponseBody
    public JsonResult login(String username, String password, Model model, ServletRequest request, ServletResponse response) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        JsonResult r = new JsonResult();
        try {
            subject.login(token);
//            String successUrl = "/index";
//            WebUtils.issueRedirect(request,response,successUrl);

            User user=userService.query(username,password);
            r.setResult(user);
            //直接跳转至首页
            return r;
        } catch (UnknownAccountException uae) {
            model.addAttribute("error", "账户不存在！");
        } catch (IncorrectCredentialsException ice) {
            model.addAttribute("error", "密码和账户不匹配！");
        } catch (Exception e) {
            model.addAttribute("error", "未知错误，登录失败！");
        }
        return null;
    }


}
