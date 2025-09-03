package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {

    @GetMapping("/view")
    public String showView(Model model) {
        model.addAttribute("title", "Le Runtrack Printanier !");
        List<String> itemList = Arrays.asList("Élément 1", "Élément 2", "Élément 3");
        model.addAttribute("itemList", itemList);
        model.addAttribute("formData", new FormData());
        return "view";
    }

    @PostMapping("/view")
    public String handleFormSubmit(@Valid @ModelAttribute("formData") FormData formData,
                                    BindingResult bindingResult, Model model) {
            model.addAttribute("title", "Le Runtrack Printanier !");
            List<String> itemList = Arrays.asList("Élément 1", "Élément 2", "Élément 3");
            model.addAttribute("itemList", itemList);
            model.addAttribute("message", "Veuillez corriger les erreurs dans le formulaire.");
        if (bindingResult.hasErrors()) {
            return "view";
        }
        // Traitement des données du formulaire
        model.addAttribute("formMessage","Bienvenue, " + formData.getWelcome() + " ! Tu as " + formData.getAge() + " ans.");
        return "view";
    }
}
