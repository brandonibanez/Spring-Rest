package com.springrest.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Student {

    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
