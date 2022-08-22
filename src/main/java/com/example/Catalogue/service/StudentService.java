package com.example.Catalogue.service;

import com.example.Catalogue.exception.NoGradeException;
import com.example.Catalogue.exception.SpecialtyNotFoundException;
import com.example.Catalogue.exception.StudentNotFoundException;
import com.example.Catalogue.model.Grade;
import com.example.Catalogue.model.Specialty;
import com.example.Catalogue.model.Student;
import com.example.Catalogue.repository.SpecialtyRepository;
import com.example.Catalogue.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final SpecialtyRepository specialtyRepository;

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

    public Student getStudentWithMostAnnualAverage() throws StudentNotFoundException {
        Optional<Student> student = studentRepository.findAll().stream()
                .max(Comparator.comparing(s -> {
                    try {
                        return s.getAnnualAverageGrade();
                    } catch (NoGradeException e) {
                        throw new RuntimeException(e);
                    }
                }));
        if (student.isEmpty()) {
            throw new StudentNotFoundException("No student found!");
        } else {
            return student.get();
        }
    }

    public Student getStudentWithMostAnnualAverageAtASpecialty(Integer specialtyId) throws SpecialtyNotFoundException, StudentNotFoundException {
        Optional<Specialty> specialty = specialtyRepository.findById(specialtyId);

        if (specialty.isEmpty()) {
            throw new SpecialtyNotFoundException("No specialty found!");
        } else {
            List<Student> studentsSpecialty = studentRepository.findAll().stream()
                    .filter(student -> student.getSpecialty().getName().equals(specialty))
                    .collect(Collectors.toList());

            Optional<Student> student = studentsSpecialty.stream()
                    .max(Comparator.comparing(s -> {
                        try {
                            return s.getAnnualAverageGrade();
                        } catch (NoGradeException e) {
                            throw new RuntimeException(e);
                        }
                    }));

            if (student.isEmpty()) {
                throw new StudentNotFoundException("No student found!");
            } else {
                return student.get();
            }
        }
    }


}
