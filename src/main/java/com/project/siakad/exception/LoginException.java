package com.project.siakad.exception;

public class LoginException extends RuntimeException {
    public LoginException () {
        super();
    }
    public LoginException (String message) {
        super(message);
    }
}
