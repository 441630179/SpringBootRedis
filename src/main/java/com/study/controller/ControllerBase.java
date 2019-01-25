package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerBase {

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("name","谭朋伟");
        return "index";
    }


}
