package com.example.Catalogue.repository;

import com.example.Catalogue.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
