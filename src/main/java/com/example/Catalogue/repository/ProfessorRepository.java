package com.example.Catalogue.repository;

import com.example.Catalogue.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
