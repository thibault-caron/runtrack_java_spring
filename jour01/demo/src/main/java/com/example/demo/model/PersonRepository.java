package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByName(String name);
    List<Person> findByAgeGreaterThan(int age);
    List<Person> findByAgeBetween(int startAge, int endAge);
}
