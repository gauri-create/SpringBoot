package com.example.JSPDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class HomeController {
    
    @GetMapping ("/")
    public String showHomePage(Model model){
        model.addAttribute("message", "Enter your name");
        return "home";
    }

    @PostMapping ("/greet")
    public String greetuser(@RequestParam String name, Model model ){
        model.addAttribute("message", "Hello"+name);
        return "home";
        
    }
}
