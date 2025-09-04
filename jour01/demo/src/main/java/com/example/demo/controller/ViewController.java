package com.example.demo.controller;
import com.example.demo.model.FormData;
import com.example.demo.model.Person;
import com.example.demo.model.PersonRepository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ViewController {
    
    private final PersonRepository personRepository;

    public ViewController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/view")
    public String showView(Model model) {
        model.addAttribute("title", "Le Runtrack Printanier !");
        List<String> itemList = Arrays.asList("Élément 1", "Élément 2", "Élément 3");
        model.addAttribute("itemList", itemList);
        model.addAttribute("formData", new FormData());
        List<Person> persons = personRepository.findAll();
        model.addAttribute("persons", persons);
        return "view";
    }

    @PostMapping("/view")
    public String handleFormSubmit(@Valid @ModelAttribute("formData") FormData formData, BindingResult bindingResult, Model model) {
            model.addAttribute("title", "Le Runtrack Printanier !");
            List<String> itemList = Arrays.asList("Élément 1", "Élément 2", "Élément 3");
            model.addAttribute("itemList", itemList);
            model.addAttribute("message", "Veuillez corriger les erreurs dans le formulaire.");
        if (bindingResult.hasErrors()) {
            return "view";
        }
        Person person = new Person(formData.getNameString(), formData.getAge());
        personRepository.save(person);

        List<Person> persons = personRepository.findAll();
        model.addAttribute("persons", persons);
        
        // Traitement des données du formulaire
        model.addAttribute("formMessage","Bienvenue, " + formData.getNameString() + " ! Tu as " + formData.getAge() + " ans.");
        
        return "view";
    }

    @GetMapping("/edit/{id}")
    public String editPerson(@PathVariable Long id, Model model) {
        Person person = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Person not found: " + id));
        model.addAttribute("formData", new FormData(person.getName(), person.getAge()));
        model.addAttribute("personId", id);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String updatePerson(@PathVariable Long id, @Valid @ModelAttribute("formData") FormData formData, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("personId", id);
            return "edit";
        }
        Person person = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Person not found: " + id));
        person.setName(formData.getNameString());
        person.setAge(formData.getAge());
        personRepository.save(person);
        return "redirect:/view";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        return "redirect:/view";
    }
}
