package com.example.Catalogue.controller;

import com.example.Catalogue.exception.ProfessorNotFoundException;
import com.example.Catalogue.model.Course;
import com.example.Catalogue.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("professor")
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping("courses/{id}")
    public List<Course> getCoursesByProfessorId(@PathVariable Integer id) throws ProfessorNotFoundException {
        return professorService.getCoursesByProfessorId(id);
    }
}
