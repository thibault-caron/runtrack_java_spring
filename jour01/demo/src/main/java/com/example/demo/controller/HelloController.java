package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Value("${greeting.message}")
    private String greetingMessage;

    @Value("${greeting.tools}")
    private String toolsMessage;

    @GetMapping("/")
    @ResponseBody
    public String rootMessageString() {
        return "Welcome to the root";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return greetingMessage + " | " + toolsMessage;
    }
}
