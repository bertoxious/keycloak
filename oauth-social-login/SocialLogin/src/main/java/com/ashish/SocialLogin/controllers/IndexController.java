package com.ashish.SocialLogin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String displayIndexPage(Model model){

        return "indexpage";
    }
}
