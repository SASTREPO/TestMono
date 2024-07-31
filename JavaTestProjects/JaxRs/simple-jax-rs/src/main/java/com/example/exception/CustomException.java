package com.example.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class CustomException extends WebApplicationException {

    public CustomException(String message, Response.Status status) {
        super(Response.status(status).entity(message).type(MediaType.TEXT_PLAIN).build());
    }
}
