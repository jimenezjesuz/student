package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT en la BD
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "age")
    private String age;
    @Column(name = "cod_student")
    private String codStudent;

    public Student() {
    }

    public Student(String name, String lastname, String age, String codStudent) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.codStudent = codStudent;
    }
}
