package com.example.Catalogue.repository;

import com.example.Catalogue.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
