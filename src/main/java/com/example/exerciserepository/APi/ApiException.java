package com.example.exerciserepository.APi;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
