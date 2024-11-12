package com.store.UserService.exception;

public class UserAlreadyExistsException extends Exception {


    public UserAlreadyExistsException(String message){
        super(message);
    }
}
