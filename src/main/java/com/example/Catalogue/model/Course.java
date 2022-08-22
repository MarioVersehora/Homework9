package com.example.Catalogue.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String subject;
    private Integer creditPoints;

    @ManyToOne
    Specialty specialty;

    @ManyToOne
    Professor professor;
}
