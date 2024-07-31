package com.example.resource;

import com.example.service.GreetingService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("greeting")
@RequestScoped
public class GreetingResource {

    @Inject
    private GreetingService greetingService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String greeting(@QueryParam("name") String name) { // SOURCE: name

        // SINK: XSS
        return greetingService.buildGreetingMessage(name).getMessage();
    }
}
