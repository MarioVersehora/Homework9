package com.example.Catalogue.controller;

import com.example.Catalogue.exception.SpecialtyNotFoundException;
import com.example.Catalogue.model.Student;
import com.example.Catalogue.service.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("specialty")
public class SpecialtyController {

    private final SpecialtyService specialtyService;

    @GetMapping("all/{id}")
    public List<Student> getAllStudentsBySpecialty(@PathVariable Integer id) throws SpecialtyNotFoundException {
        return specialtyService.getAllStudentsBySpecialty(id);
    }
}
