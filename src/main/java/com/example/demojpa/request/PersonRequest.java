package com.example.demojpa.request;

import com.example.demojpa.model.Person;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PersonRequest {
    @NotBlank(message = "First Name should not be empty")
    private String firstName;
    private String lastName;
    @NotBlank(message = "Date of Birth should not be empty")
    private String dob;

    public Person to(){
        return Person.builder()
                .firstName(firstName)
                .lastName(lastName)
                .dob(dob).build();
    }
}