package com.example.demo.service.impl;

import com.example.demo.common.StudentDTO;
import com.example.demo.common.StudentMapper;
import com.example.demo.exception.StudentException;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.EstudianteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements EstudianteService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        Student byCodStudent = studentRepository.findByCodStudent(studentDTO.getCodStudent());
        if (byCodStudent != null) {
            throw new StudentException("Student already exists");
        }
        studentRepository.save(StudentMapper.toEntity(studentDTO));
        return studentDTO;
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        Optional<Student> byId = studentRepository.findById(id);
        if (byId.isEmpty()) {
            return;
        }
        studentRepository.delete(byId.get());
    }

    public StudentDTO findByCode(String cod) {
        Student byCodStudent = studentRepository.findByCodStudent(cod);
        if (byCodStudent == null) {
            throw new StudentNotFoundException("Student not found");
        }
        return StudentMapper.toDTO(byCodStudent);
    }

}
