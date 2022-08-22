package com.example.Catalogue.controller;

import com.example.Catalogue.exception.StudentNotFoundException;
import com.example.Catalogue.model.Grade;
import com.example.Catalogue.model.Student;
import com.example.Catalogue.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("grades/{id}")
    public List<Grade> getAllGradesByStudentId(@PathVariable Integer id) throws StudentNotFoundException {
        return studentService.getAllGradesByStudentId(id);
    }

    @GetMapping("average")
    public List<Student> getAllStudentsWithAnnualAverageGreaterThanEight() {
        return studentService.getAllStudentsWithAnnualAverageGreaterThanEight();

    }

    @PostMapping("grades/add/{grade}/{studentId}")
    public void addGradeByStudentId(@PathVariable Grade grade, @PathVariable Integer id) throws StudentNotFoundException {
        studentService.addGradeByStudentId(grade, id);
    }


}
