package com.lanou.controller;

import com.lanou.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */

@Controller
public class LoginController {

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping("/login")
    public String login(
            @Validated
                    User user,
            BindingResult result,
            HttpSession session,
            Model model) {
        /*判断user对象输入验证的结果是否为空*/
        if (result.hasErrors()){
            List<ObjectError> errors = result.getAllErrors();

            //获取某个属性的错误信息
            FieldError unameError = result.getFieldError("uname");
            FieldError pwdError = result.getFieldError("pwd");
            //回显
            model.addAttribute("uerror",unameError);
            model.addAttribute("perror",pwdError);

            //将输入验证错误信息回显到登录页面
            model.addAttribute("errors",errors);

            return "login";
        }

        if (user != null && user.getUname().equals("jaso") && user.getPwd().equals("123")) {
            //保存用户名和密码
            session.setAttribute("uname", user.getUname());
            return "forward:home";//转发进入home主页
        }
        model.addAttribute("msg", "用户名或密码错误!");
        return "login";//登录失败不跳转, 保留当前页面
    }

    /**
     * 退出登录
     *
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        /*清除session*/
        session.invalidate();
        return "login";
    }

}
