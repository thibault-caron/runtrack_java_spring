package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class ViewController {

    @GetMapping("/view")
    public String showView(Model model) {
        model.addAttribute("message", "Bienvenue sur la vue d'accueil !");
        return "view";
    }
}
