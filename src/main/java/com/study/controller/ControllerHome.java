package com.study.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class ControllerHome extends ControllerBase {

    @RequestMapping(value = "/home")
    public String home(Model model){
        return "layout";
    }

}
