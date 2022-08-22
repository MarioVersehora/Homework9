package com.example.Catalogue.service;

import com.example.Catalogue.exception.NoGradeException;
import com.example.Catalogue.exception.SpecialtyNotFoundException;
import com.example.Catalogue.model.Specialty;
import com.example.Catalogue.model.Student;
import com.example.Catalogue.repository.SpecialtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public List<Student> getAllStudentsBySpecialty(Integer id) throws SpecialtyNotFoundException {
        Optional<Specialty> specialty = specialtyRepository.findById(id);
        if (specialty.isEmpty()) {
            throw new SpecialtyNotFoundException("No specialty found!");
        } else {
            return specialty.get().getStudents();
        }
    }

    public Specialty getSpecialtyWithMostStudents() throws SpecialtyNotFoundException {
        Optional<Specialty> specialty = specialtyRepository.findAll().stream()
                .max(Comparator.comparing(s -> s.getStudents().size()));
        if (specialty.isEmpty()) {
            throw new SpecialtyNotFoundException("No specialty found!");
        } else {
            return specialty.get();
        }
    }

    public Integer getAverageAtASpecialty(Integer id) throws SpecialtyNotFoundException, NoGradeException {
        Optional<Specialty> specialty = specialtyRepository.findById(id);
        if (specialty.isEmpty()) {
            throw new SpecialtyNotFoundException("No specialty found!");
        } else {
            Integer averageGrade = 0;
            List<Student> studentsSpecialty = specialty.get().getStudents();
            for (Student student : studentsSpecialty) {
                averageGrade += student.getAnnualAverageGrade();
            }
            return averageGrade / studentsSpecialty.size();
        }
    }


}
