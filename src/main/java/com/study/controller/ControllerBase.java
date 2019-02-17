package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author pengwei.tan
 * @date 2019-01-27
 */
@Controller
public class ControllerBase {

    @RequestMapping("/index")
    public String index(Model model) {

        return "index";
    }

}
