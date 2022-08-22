package com.example.Catalogue.exception;

public class ProfessorNotFoundException extends Exception {

    String message;

    public ProfessorNotFoundException(String message) {
        this.message = message;
    }

    public String toString() {
        return ("ProfessorNotFoundException Occured : " + message);
    }
}
