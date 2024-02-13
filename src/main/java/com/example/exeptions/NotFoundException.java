package com.example.exeptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String error) {
        super(error);
    }
}
