package com.example.filter;

import com.example.util.Utils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Optional;

@Provider
public class CustomRequestFilter implements ContainerRequestFilter {

    private static final Logger logger = LogManager.getLogger(CustomRequestFilter.class);

    @Context
    private HttpServletRequest httpRequest;

    @Override
    public void filter(ContainerRequestContext ctx) {

        if (ctx.getMethod().equals("GET") &&
                ctx.getUriInfo().getPath().startsWith("/filter/input/")) {

            String[] names = httpRequest.getParameterValues("name");
            if(names != null) {
                Optional<String> username = Arrays.stream(names).findFirst();
                if(username.isPresent()) {
                    logger.debug("Check name: " + username.get());

                    if(!Utils.allowedUser(username.get())) {
                        logger.debug("User input does not exist in the allowed list. name: " + username.get());

                        ctx.abortWith(Response.status(Response.Status.FORBIDDEN)
                                .entity("Cannot access")
                                .build());
                    } else {
                        logger.debug("User input exists in allowed list. name: " + username.get());
                    }
                }
            }
        }
    }
}
