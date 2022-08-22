package com.example.Catalogue.exception;

public class NoGradeException extends Exception {

    private String message;

    public NoGradeException(String message) {
        this.message = message;
    }

    public String toString() {
        return ("NoGradeException Occur: " + message);
    }
}
