package com.example.filter;

import com.example.util.Utils;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static org.apache.commons.lang3.StringUtils.substringAfter;

@Provider
@PreMatching
public class CustomPrematchingRequestFilter implements ContainerRequestFilter {

    private static final Logger logger = LogManager.getLogger(CustomPrematchingRequestFilter.class);

    @Override
    public void filter(ContainerRequestContext ctx) throws IOException {
        if (ctx.getMethod().equals("GET") &&
                ctx.getUriInfo().getPath().startsWith("/filter/input/")) {

            String input = substringAfter(ctx.getUriInfo().getPath(), "/filter/input/");

            if(input != null) {
                logger.debug("Check input: " + input);

                if(!Utils.allowedUser(input)) {
                    logger.debug("User input does not exist in the allowed list. input: " + input);

                    ctx.abortWith(Response.status(Response.Status.FORBIDDEN)
                            .entity("Cannot access")
                            .build());
                } else {
                    logger.debug("User input exists in allowed list. input: " + input);
                }
            }
        }
    }
}
