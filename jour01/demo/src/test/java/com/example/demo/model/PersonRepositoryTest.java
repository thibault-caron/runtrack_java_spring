package com.example.demo.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testSaveAndFindByName() {
        // Arrange
        Person person = new Person();
        person.setName("John");
        person.setAge(30);
        personRepository.save(person);

        // Act
        List<Person> result = personRepository.findByName("John");

        // Assert
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("John");
        assertThat(result.get(0).getAge()).isEqualTo(30);
    }

    @Test
    public void testFindByAgeGreaterThan() {
        // Arrange
        Person person1 = new Person();
        person1.setName("Alice");
        person1.setAge(25);
        personRepository.save(person1);

        Person person2 = new Person();
        person2.setName("Bob");
        person2.setAge(35);
        personRepository.save(person2);

        // Act
        List<Person> result = personRepository.findByAgeGreaterThan(30);

        // Assert
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("Bob");
    }

    @Test
    public void testFindByAgeBetween() {
        // Arrange
        Person person1 = new Person();
        person1.setName("Charlie");
        person1.setAge(20);
        personRepository.save(person1);

        Person person2 = new Person();
        person2.setName("Diana");
        person2.setAge(40);
        personRepository.save(person2);

        // Act
        List<Person> result = personRepository.findByAgeBetween(15, 30);

        // Assert
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("Charlie");
    }
}
