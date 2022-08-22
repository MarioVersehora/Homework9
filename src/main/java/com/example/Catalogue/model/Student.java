package com.example.Catalogue.model;

import com.example.Catalogue.exception.NoGradeException;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    private List<Grade> grades = new ArrayList<>();

    @ManyToOne
    private Specialty specialty;

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public Integer getAnnualAverageGrade() throws NoGradeException {
        if (grades.isEmpty()) {
            throw new NoGradeException("You do not have any grade!");
        } else {
            Integer averageGrade = 0;
            for (Grade grade : grades) {
                averageGrade += grade.getGrade();
            }

            return averageGrade / grades.size();

        }
    }


}
