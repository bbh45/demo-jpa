package com.example.demojpa.service;

import com.example.demojpa.model.Author;
import com.example.demojpa.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;


    public void createAuthor(Author author) {
        authorRepository.save(author);
    }
}
