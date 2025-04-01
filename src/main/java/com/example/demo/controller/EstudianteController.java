package com.example.demo.controller;

import com.example.demo.common.StudentDTO;
import com.example.demo.service.EstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping("/all")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(estudianteService.findAll());
    }

    @GetMapping("/find/{code}")
    public ResponseEntity getByCode(@PathVariable("code") String name) {
        return ResponseEntity.ok(estudianteService.findByCode(name));
    }

    @DeleteMapping("/delete/{codStudent}")
    public ResponseEntity deleteTipoRespuesta(@PathVariable("codStudent") String codStudent) {
        estudianteService.delete(codStudent);
        return ResponseEntity.noContent()
                .build();
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok(estudianteService.save(studentDTO));
    }
}
