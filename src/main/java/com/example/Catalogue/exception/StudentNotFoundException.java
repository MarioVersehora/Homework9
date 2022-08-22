package com.example.Catalogue.exception;

public class StudentNotFoundException extends Exception {

    private String message;

    public StudentNotFoundException(String message) {
        this.message = message;
    }

    public String toString() {
        return ("StudentNotFoundException Occured: " + message);
    }
}
