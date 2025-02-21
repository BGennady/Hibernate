package ru.netology.Hibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.Hibernate.repository.PersonRepository;
import ru.netology.Hibernate.model.Person;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // обрабатывает GET-запросы по адресу /persons/by-city
    @GetMapping("/by-city")
    // метод принимает параметр city из URL и возвращает список Person
    public List<Person> findPersonsByCity(@RequestParam String city) {

        // сохраняем результат запроса в переменную
        List<Person> persons = personRepository.getPersonsByCity(city);
        System.out.println("Found persons for city " + city + ": " + persons);

        // выводим результат в лог для отладки
        System.out.println("Found persons for city " + city + ": " + persons);

        // возвращаем результат
        return persons;
    }
}