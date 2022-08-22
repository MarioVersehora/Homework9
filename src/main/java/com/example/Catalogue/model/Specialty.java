package com.example.Catalogue.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    List<Student> students = new ArrayList<>();

    @OneToMany
    List<Course> courses = new ArrayList<>();

}
