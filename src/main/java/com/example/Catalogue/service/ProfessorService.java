package com.example.Catalogue.service;

import com.example.Catalogue.exception.NoGradeException;
import com.example.Catalogue.exception.ProfessorNotFoundException;
import com.example.Catalogue.model.Course;
import com.example.Catalogue.model.Professor;
import com.example.Catalogue.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public List<Course> getCoursesByProfessorId(Integer id) throws ProfessorNotFoundException {
        Optional<Professor> professor = professorRepository.findById(id);
        if(professor.isEmpty()) {
            throw new ProfessorNotFoundException("No professor");
        } else {
            return professor.get().getCourses();
        }
    }

}
