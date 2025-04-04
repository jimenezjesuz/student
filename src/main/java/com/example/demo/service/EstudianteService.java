package com.example.demo.service;

import com.example.demo.common.StudentDTO;

import java.util.List;

public interface EstudianteService {

    StudentDTO save(StudentDTO studentDTO);

    List<StudentDTO> findAll();

    void delete(String codStudent);

    StudentDTO findByCode(String name);

}
