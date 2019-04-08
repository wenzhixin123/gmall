package com.xinxin.gmall.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManageController {

    @RequestMapping("/index")
    public String gotoIndex(){
        return "index";
    }

}
