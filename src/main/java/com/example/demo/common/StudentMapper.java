package com.example.demo.common;

import com.example.demo.model.Student;

public class StudentMapper {
    public static StudentDTO toDTO(Student user) {
        return new StudentDTO(user.getName(), user.getLastname(), user.getAge(), user.getCodStudent());
    }

    public static Student toEntity(StudentDTO studentDTO) {
        return new Student(studentDTO.getName(), studentDTO.getLastname(), studentDTO.getAge(), studentDTO.getCodStudent());
    }
}
