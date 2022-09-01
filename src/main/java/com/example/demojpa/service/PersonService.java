package com.example.demojpa.service;

import com.example.demojpa.exceptions.PersonNotFoundException;
import com.example.demojpa.model.Person;
import com.example.demojpa.repository.PersonRepository;
import com.example.demojpa.request.PersonRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private static Logger logger = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    PersonRepository personRepository;

    public void createPerson(PersonRequest personRequest){
        Person person = personRequest.to();
        personRepository.save(person);
    }

    public Person getPersonById(int id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Person not found"));
    }

    public List<Person> getPeople() {
        return personRepository.findAll();
    }

    public Person deletePerson(int id) {
        return null;
    }
}

