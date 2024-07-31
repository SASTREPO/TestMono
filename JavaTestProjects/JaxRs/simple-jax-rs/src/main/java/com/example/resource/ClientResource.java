package com.example.resource;

import com.example.filter.client.CustomClientResponseFilter;
import com.example.interceptor.client.CustomClientReaderInterceptor;
import com.example.model.GreetingMessage;
import com.google.gson.Gson;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("client")
@RequestScoped
public class ClientResource {

    @GET
    @Path("get")
    @Produces(MediaType.TEXT_HTML)
    public String get() {

        Client client = ClientBuilder.newClient();
        Response response = client.target("http://localhost:8080/api/server").request("text/plain").get();

//        All methods below are SOURCES
//        response.readEntity(String.class);
//        response.getEntity();
//        response.getEntityTag();
//
//        response.getHeaders();
//        response.getHeaderString("header-name");
//
//        response.getCookies();
//
//        response.getAllowedMethods();
//        response.getLocation();
//        response.getMetadata();
//        response.getLinks();
//        response.getLink("link-name");

        // SOURCE
        String body = response.readEntity(String.class);

        // Unsafe XSS SINK
        return body;
    }

    @GET
    @Path("post/filter")
    @Produces(MediaType.TEXT_HTML)
    public String postFilter() {

        Client client = ClientBuilder.newClient();
        Response response = client.register(CustomClientResponseFilter.class) // Registers a filter that will sanitize the request body.
                                    .target("http://localhost:8080/api/server")
                                    .request(MediaType.APPLICATION_JSON)
                                    .post(null);

        // SANITIZED SOURCE: sanitized in CustomClientResponseFilter
        String body = response.readEntity(String.class);

        GreetingMessage s = new Gson().fromJson(body, GreetingMessage.class);

        // Sanitized XSS SINK
        return s.getMessage();
    }

    @GET
    @Path("post/interceptor")
    @Produces(MediaType.TEXT_HTML)
    public String post() {

        Client client = ClientBuilder.newClient();
        Response response = client.register(CustomClientReaderInterceptor.class) // Registers an interceptor that will sanitize the request body.
                                    .target("http://localhost:8080/api/server")
                                    .request(MediaType.APPLICATION_JSON)
                                    .post(null);

        // SANITIZED SOURCE: sanitized in CustomClientResponseFilter
        String body = response.readEntity(String.class);

        GreetingMessage s = new Gson().fromJson(body, GreetingMessage.class);

        // Sanitized XSS SINK
        return s.getMessage();
    }
}
