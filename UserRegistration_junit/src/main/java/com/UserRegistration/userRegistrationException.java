package com.UserRegistration;

public class userRegistrationException extends RuntimeException {
    public enum ExceptionType
    {
        ENTERED_NULL,ENTERED_EMPTY
    }

    public ExceptionType type;

    public userRegistrationException(ExceptionType type,String message) {
        super(message);
        this.type = type;
    }
}
