package com.example.Catalogue.service;

import com.example.Catalogue.model.Grade;
import com.example.Catalogue.model.Student;
import com.example.Catalogue.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Grade> getGradesByStudentId(Integer id) {
        Student student = studentRepository.findById(id).get();
        return student.getGrades();
    }

    public List<Student> getAllStudentsGradeGraterThanEight() {
        return studentRepository.findAll().stream()
                .filter(s -> s.getAnnualAverageGrade() >= 8)
                .collect(Collectors.toList());
    }

    public void addGradeByStudentId(Grade grade, Integer id) {
        Student student = studentRepository.findById(id).get();
        student.addGrade(grade);
        studentRepository.save(student);
    }
}
