package com.lanou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dllo on 17/11/10.
 */

@Controller
public class MainController {


    /**
     * 起始页
     * @return
     */
    @RequestMapping("/")
    public String index(){
        return "login";
    }

    /**
     * 成功页
     * @return
     */
    @RequestMapping("/home")
    public String home(){
        return "home";
    }



}
