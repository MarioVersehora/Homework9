package com.example.Catalogue.controller;

import com.example.Catalogue.exception.NoGradeException;
import com.example.Catalogue.exception.SpecialtyNotFoundException;
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

    @PostMapping("grades/add/{gradeId}/{studentId}")
    public void addGradeByStudentId(@PathVariable Integer gradeId, @PathVariable Integer studentId) throws StudentNotFoundException, NoGradeException {
        studentService.addGradeByStudentId(gradeId, studentId);
    }

    @GetMapping("most/average")
    public Student getStudentWithMostAnnualAverage() throws StudentNotFoundException {
        return studentService.getStudentWithMostAnnualAverage();
    }

    @GetMapping("most/average/specialty/{specialtyId}")
    public Student getStudentWithMostAnnualAverageAtASpecialty(@PathVariable Integer specialtyId) throws StudentNotFoundException, SpecialtyNotFoundException {
        return studentService.getStudentWithMostAnnualAverageAtASpecialty(specialtyId);
    }


}
