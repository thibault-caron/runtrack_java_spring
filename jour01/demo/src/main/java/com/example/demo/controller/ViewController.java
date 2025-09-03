package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

@Controller
public class ViewController {

    @GetMapping("/view")
    public String showView(Model model) {
        model.addAttribute("message", "Bienvenue sur la vue d'accueil !");
        List<String> items = Arrays.asList("Élément 1", "Élément 2", "Élément 3");
        model.addAttribute("items", items);
        return "view";
    }
}
