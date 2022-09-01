package com.example.demojpa.controller;

import com.example.demojpa.model.Author;
import com.example.demojpa.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/author")
    public void createAuthor(@RequestBody @Valid Author author){
        authorService.createAuthor(author);
    }
}
