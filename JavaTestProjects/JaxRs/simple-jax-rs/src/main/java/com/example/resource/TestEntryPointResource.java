package com.example.resource;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("testentrypoint")
@RequestScoped
public class TestEntryPointResource {

    @GET
    @Path("filter")
    @Consumes(MediaType.TEXT_PLAIN)
    public void filter(@QueryParam("name") String name) {
        // 'name' is used in the filter
    }

    @POST
    @Path("interceptor")
    @Consumes(MediaType.TEXT_PLAIN)
    public void interceptor(String name) {
        // 'name' is used in the interceptor
    }
}
