package com.example.Catalogue.controller;

import com.example.Catalogue.model.Grade;
import com.example.Catalogue.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("{id}")
    public List<Grade> getAllGradesByStudentId(@PathVariable Integer id) {
        return studentService.getGradesByStudentId(id);
    }
//
//    @PostMapping("grades/add/{studentId}/{grade}")
//    public void addGrade
}
