package com.example.exception;

import jakarta.ws.rs.WebApplicationException;

public class MappedException extends WebApplicationException {

    public MappedException(String message) {
        super(message);
    }
}
