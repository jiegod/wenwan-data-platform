package com.wenwan.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomepageUi {

    @GetMapping("/")
    private String redirect(){
        return "redirect:/swagger-ui.html";
    }
}
