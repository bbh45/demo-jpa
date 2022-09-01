package com.example.demojpa.controller;

import com.example.demojpa.exceptions.PersonNotFoundException;
import com.example.demojpa.model.Author;
import com.example.demojpa.model.Person;
import com.example.demojpa.request.PersonRequest;
import com.example.demojpa.service.AuthorService;
import com.example.demojpa.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonControl {

    private static Logger logger = LoggerFactory.getLogger(PersonControl.class);

    @Autowired
    PersonService personService;

    @PostMapping("/person")
    public void createPerson(@RequestBody @Valid PersonRequest personRequest){
        personService.createPerson(personRequest);
    }

    @GetMapping("/person")
    public Person getPersonById(@RequestParam("id") int id) throws PersonNotFoundException {
        return personService.getPersonById(id);
    }

    @GetMapping("/person/all")
    public List<Person> getPeople(){
        return personService.getPeople();
    }

    @DeleteMapping("/person/delete/{id}")
    public Person deletePerson(@PathVariable("id") int id) {
        return personService.deletePerson(id);
    }


}
