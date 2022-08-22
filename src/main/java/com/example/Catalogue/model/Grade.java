package com.example.Catalogue.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer grade;

    @ManyToOne
    private Student student;
}
