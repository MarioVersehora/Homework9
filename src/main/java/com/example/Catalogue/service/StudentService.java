package com.example.Catalogue.service;

import com.example.Catalogue.exception.NoGradeException;
import com.example.Catalogue.exception.StudentNotFoundException;
import com.example.Catalogue.model.Grade;
import com.example.Catalogue.model.Student;
import com.example.Catalogue.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Grade> getAllGradesByStudentId(Integer id) throws StudentNotFoundException {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new StudentNotFoundException("No student found!");
        } else {
            return student.get().getGrades();
        }
    }

    public List<Student> getAllStudentsWithAnnualAverageGreaterThanEight() {
        return studentRepository.findAll().stream()
                .filter(s -> {
                    try {
                        return s.getAnnualAverageGrade() >= 8;
                    } catch (NoGradeException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
    }

    public void addGradeByStudentId(Grade grade, Integer id) throws StudentNotFoundException {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new StudentNotFoundException("No student found!");
        } else {
            student.get().addGrade(grade);
            studentRepository.save(student.get());
        }
    }
}
