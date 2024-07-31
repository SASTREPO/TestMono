package com.example.resource;

import jakarta.enterprise.context.RequestScoped;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;

@Path("server")
@RequestScoped
public class ServerResource {

    @Context
    HttpServletResponse httpResponse;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {

        httpResponse.setHeader("Location", "https://www.hack.com");
        httpResponse.setHeader("Allow", "GET,HACK");
        httpResponse.setHeader("Link", "<https://www.hack.com/records>; rel=\"list\"");
        httpResponse.setHeader("Link", "<https://www.hack.com/records/1>; rel=\"self\"");
        httpResponse.setHeader("Link", "<https://www.hack.com/records/1>; rel=\"update\"");
        httpResponse.setHeader("Link", "<https://www.hack.com/records/1>; rel=\"delete\"");
        httpResponse.setHeader("Etag", "hack");

        return "<script>alert(123)</script>";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String post() {
        return "{ \"message\": \"<script>alert(123)</script>\" }";
    }
}
