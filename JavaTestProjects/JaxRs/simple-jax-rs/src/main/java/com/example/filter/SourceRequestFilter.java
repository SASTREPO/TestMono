package com.example.filter;

import com.example.model.User;
import com.example.service.SearchUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.ext.Provider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Optional;

@Provider
public class SourceRequestFilter implements ContainerRequestFilter {

    private static final Logger logger = LogManager.getLogger(SourceRequestFilter.class);

    @Context
    private HttpServletRequest httpRequest;

    @Override
    public void filter(ContainerRequestContext ctx) {

        if (ctx.getMethod().equals("GET") &&
                ctx.getUriInfo().getPath().startsWith("/testentrypoint/filter")) {

            String[] names = httpRequest.getParameterValues("name"); // SOURCE
            if(names != null) {
                Optional<String> username = Arrays.stream(names).findFirst();
                if(username.isPresent()) {
                    logger.debug("name: " + username.get());

                    User dbUser = SearchUserService.getUserByNameUnsafe(username.get());

                    if (dbUser != null) {
                        logger.debug(dbUser.toString());
                    } else {
                        logger.debug("User not found");
                    }
                }
            }
        }

        // SOURCE: ctx.getEntityStream()
        // SOURCE: ctx.getCookies()
        // SOURCE: ctx.getHeaderString()
        // SOURCE: ctx.getHeaders()
        // SOURCE: ctx.getUriInfo()
    }
}
