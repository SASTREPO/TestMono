package com.example.resource;

import jakarta.enterprise.context.RequestScoped;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Providers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@Path("context")
@RequestScoped
public class ContextInjectionResource {

    private static final Logger logger = LogManager.getLogger(ContextInjectionResource.class);

    @Context
    private SecurityContext securityContext;    // POSSIBLE SOURCE OF SENSITIVE DATA: securityContext
    @Context
    private Request request;                    // POSSIBLE SOURCE OF SENSITIVE DATA: request
    @Context
    private Application application;            // POSSIBLE SOURCE OF SENSITIVE DATA: application
    @Context
    private Configuration configuration;        // POSSIBLE SOURCE OF SENSITIVE DATA: configuration
    @Context
    private Providers providers;                // POSSIBLE SOURCE OF SENSITIVE DATA: providers
    @Context
    private ServletConfig servletConfig;        // POSSIBLE SOURCE OF SENSITIVE DATA: servletConfig
    @Context
    private ServletContext servletContext;      // POSSIBLE SOURCE OF SENSITIVE DATA: servletContext
    @Context
    private HttpServletRequest httpRequest;     // POSSIBLE SOURCE OF SENSITIVE DATA: httpRequest
    @Context
    private HttpServletResponse httpResponse;   // POSSIBLE SOURCE OF SENSITIVE DATA: httpResponse
    @Context
    private HttpHeaders header;                 // POSSIBLE SOURCE OF SENSITIVE DATA: header
    @Context
    private UriInfo uri;                        // POSSIBLE SOURCE OF SENSITIVE DATA: uri

    @GET
    @Path("injected/class")
    @Produces(MediaType.TEXT_HTML)
    public String contextInjectedAsClassProperty() throws ServletException, IOException {

        logger.info("Context injected as class property");

        String output = httpRequest.getHeader("header_param_name");    // SOURCE
        output = output + " " + httpRequest.getHeaders("header_param_name");    // SOURCE
        output = output + " " + httpRequest.getHeaderNames();                      // SOURCE
        output = output + " " + httpRequest.getParameter("param_name");         // SOURCE
        output = output + " " + httpRequest.getParameterNames();                   // SOURCE
        output = output + " " + httpRequest.getParameterValues("param_name");   // SOURCE
        output = output + " " + httpRequest.getParameterMap();                     // SOURCE
        output = output + " " + httpRequest.getInputStream();                      // SOURCE
        output = output + " " + httpRequest.getQueryString();                      // SOURCE
        // output = output + " " + httpRequest.getParts();                         // SOURCE
        // output = output + " " + httpRequest.getPart("file_name");               // SOURCE
        output = output + " " + httpRequest.getRequestURI();                       // SOURCE
        output = output + " " + httpRequest.getRequestURL();                       // SOURCE

        output = output + " " + header.getHeaderString("param_name");           // SOURCE
        output = output + " " + header.getRequestHeader("param_name");          // SOURCE
        output = output + " " + header.getRequestHeaders();                        // SOURCE

        output = output + " " + uri.getPath();                                     // SOURCE
        output = output + " " + uri.getPath(true);                              // SOURCE
        output = output + " " + uri.getPathParameters();                           // SOURCE
        output = output + " " + uri.getPathParameters(true);                    // SOURCE
        output = output + " " + uri.getQueryParameters();                          // SOURCE
        output = output + " " + uri.getQueryParameters(true);                   // SOURCE
        output = output + " " + uri.getRequestUri();                               // SOURCE
        output = output + " " + uri.getRequestUriBuilder().build();                // SOURCE
        output = output + " " + uri.getAbsolutePath();                             // SOURCE
        output = output + " " + uri.getAbsolutePathBuilder().build();              // SOURCE
        output = output + " " + uri.getPathSegments();                             // SOURCE
        output = output + " " + uri.getPathSegments(true);                      // SOURCE

        jakarta.servlet.http.Cookie[] cookies = httpRequest.getCookies();
        for(Cookie cookie : cookies) {
            output = output + " " + cookie.getName();                              // SOURCE
            output = output + " " + cookie.getValue();                             // SOURCE
        }

        return output;
    }

    @GET
    @Path("context/argument")
    public void contextInjectedAsArgument(@Context SecurityContext securityContext,     // POSSIBLE SOURCE OF SENSITIVE DATA: securityContext
                                          @Context Request request,                     // POSSIBLE SOURCE OF SENSITIVE DATA: request
                                          @Context Application application,             // POSSIBLE SOURCE OF SENSITIVE DATA: application
                                          @Context Configuration configuration,         // POSSIBLE SOURCE OF SENSITIVE DATA: configuration
                                          @Context Providers providers,                 // POSSIBLE SOURCE OF SENSITIVE DATA: providers
                                          @Context ServletConfig servletConfig,         // POSSIBLE SOURCE OF SENSITIVE DATA: servletConfig
                                          @Context ServletContext servletContext,       // POSSIBLE SOURCE OF SENSITIVE DATA: servletContext
                                          @Context HttpServletRequest httpRequest,      // POSSIBLE SOURCE OF SENSITIVE DATA: httpRequest
                                          @Context HttpServletResponse httpResponse,    // POSSIBLE SOURCE OF SENSITIVE DATA: httpResponse
                                          @Context HttpHeaders header,                  // POSSIBLE SOURCE OF SENSITIVE DATA: header
                                          @Context UriInfo uri) {                       // POSSIBLE SOURCE OF SENSITIVE DATA: uri

        logger.info("Context injected as method argument");
    }
}
