package com.example.kidzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("")
    public String redirectToStaticIndex() {
        return "redirect:/index.html";
    }

}
