package com.example.mgnt_sys.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message) {
        super(message);
    }
}
