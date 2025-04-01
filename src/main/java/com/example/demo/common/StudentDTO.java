package com.example.demo.common;

import lombok.Data;

@Data
public class StudentDTO {

    private String name;
    private String lastname;
    private String age;
    private String codStudent;

    public StudentDTO(String name, String lastname, String age, String codStudent) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.codStudent = codStudent;
    }
}
