package com.example.resource;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;

@Path("interceptor")
@RequestScoped
public class InterceptorResource {

    @GET
    @Path("xss")
    @Produces(MediaType.TEXT_HTML)
    public String safe1(@QueryParam("input") String input) { // SANITIZED SOURCE: sanitized in CustomWriterInterceptor

        // Sanitized XSS Sink
        return input;
    }

    @POST
    @Path("body")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_HTML)
    public String safe2(String input) throws IOException { // SANITIZED SOURCE: sanitized in CustomReaderInterceptor

        // Sanitized XSS Sink
        return input;
    }
}
