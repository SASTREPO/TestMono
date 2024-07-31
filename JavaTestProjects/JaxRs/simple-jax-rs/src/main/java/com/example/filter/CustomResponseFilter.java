package com.example.filter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.ext.Provider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Provider
public class CustomResponseFilter implements ContainerResponseFilter {

    private static final Logger logger = LogManager.getLogger(CustomResponseFilter.class);

    @Context
    private HttpServletRequest httpRequest;

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext ctx) throws IOException {
        if (containerRequestContext.getMethod().equals("GET") &&
                containerRequestContext.getUriInfo().getPath().startsWith("/filter/response")) {

            String[] names = httpRequest.getParameterValues("name");
            if(names != null) {
                Optional<String> username = Arrays.stream(names).findFirst();
                if(username.isPresent()) {
                    logger.debug("name: " + username.get());
                    String sanitizedBody = username.get().replaceAll("[^A-Za-z0-9]", "");
                    logger.debug("sanitized name: " + sanitizedBody);

                    ctx.setEntity(sanitizedBody + " updated in CustomResponseFilter");
                }
            }
        }
    }
}
