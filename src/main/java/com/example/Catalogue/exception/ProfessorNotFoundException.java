package com.example.Catalogue.exception;

public class ProfessorNotFoundException extends Exception {

    private String message;

    public ProfessorNotFoundException(String message) {
        this.message = message;
    }

    public String toString() {
        return ("ProfessorNotFoundException Occured : " + message);
    }
}
