package com.example.resource;

import com.example.config.CustomMendBinding;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("filter")
@RequestScoped
public class FilterResource {

    @GET
    @Path("input/{input}")
    @Produces(MediaType.TEXT_HTML)
    public String safeUserInput(@PathParam("input") String input, @QueryParam("name") String name) {
        // SANITIZED SOURCE:
        // "input" sanitized in CustomPrematchingRequestFilter
        // "name" sanitized in CustomRequestFilter

        // Sanitized XSS Sink
        return "input: " + input + " name: " + name;
    }

    @GET
    @Path("name/binding")
    @CustomMendBinding
    @Produces(MediaType.TEXT_HTML)
    public String safeNameBindingFilter(@QueryParam("name") String name) { // SANITIZED SOURCE: sanitized in CustomNameBindingRequestFilter

        // Sanitized XSS Sink
        return name;
    }

    @GET
    @Path("response")
    @Produces(MediaType.TEXT_HTML)
    public String safeResponse(@QueryParam("name") String name) { // SANITIZED SOURCE: sanitized in CustomResponseFilter

        // Sanitized XSS Sink
        return name;
    }
}
