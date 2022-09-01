package com.example.demojpa.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.Constraint;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Author {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    @Column(unique = true)
    private String name;
    private int age;
    /*
    * Hibernate does not allow applying constraints on already existing table
    * scenario: ddl-auto: update and unique = true
    * alter table Author add unique(name)
    * implies, existing table is not dropped. therefore can not apply constraint as it causes
    */
    //flyway, liquibase - dependencies to add constraints to tables
}
