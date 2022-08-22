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

    private String name;

    @OneToMany
    private List<Student> students = new ArrayList<>();

    @OneToMany
    private List<Course> courses = new ArrayList<>();

}
