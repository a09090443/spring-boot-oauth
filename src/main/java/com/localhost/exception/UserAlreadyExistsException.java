package com.localhost.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Represents the case when user tries to user credentials of the existing {@link UserInfo}
 * during registration.
 *
 * @author dtreb
 */
@ResponseStatus(value= HttpStatus.CONFLICT)
public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException(String msg, Throwable t) {
        super(msg, t);
    }

    public UserAlreadyExistsException(String msg) {
        super(msg);
    }
}
