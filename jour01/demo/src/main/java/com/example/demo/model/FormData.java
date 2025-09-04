package com.example.demo.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FormData {

    @NotBlank(message = "Votre nom est obligatoire")
    private String nameString;

    @NotNull(message = "L'âge est obligatoire")
    @Min(value = 0, message = "L'âge doit être positif")
    @Max(value = 120, message = "Aie, t'es trop vieux !")
    private Integer age;

    public FormData() {
    }

    public FormData(String nameString, Integer age) {
        this.nameString = nameString;
        this.age = age;
    }

    // getters and setters

    public String getNameString() { return nameString; }
    public void setNameString(String nameString) { this.nameString = nameString; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
}