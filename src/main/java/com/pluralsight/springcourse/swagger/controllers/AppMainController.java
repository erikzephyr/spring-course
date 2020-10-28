package com.pluralsight.springcourse.swagger.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppMainController {

    @GetMapping("home")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("swagger/index");
        mv.addObject("title", "Custom pcs online shop");
        return mv;
    }

}
