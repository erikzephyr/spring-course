package com.pluralsight.springcourse.swagger.controllers;

import com.pluralsight.springcourse.swagger.services.PcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("pcs")
public class PcController {

    @Autowired
    private PcService pcService;

    @GetMapping("show")
    public ModelAndView show() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("swagger/pcs");
        mv.addObject("title", "Custom pcs online shop");
        mv.addObject("pcs", pcService.all());
        return mv;
    }
}
