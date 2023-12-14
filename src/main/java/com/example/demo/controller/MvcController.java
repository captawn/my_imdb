package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {

    @GetMapping("/hello")
    public String getHello(Model myModel){
        myModel.addAttribute("homewelcome", "FSD 09");
        myModel.addAttribute("currentDate", new java.util.Date());
        return "helloworld";
    }

}
