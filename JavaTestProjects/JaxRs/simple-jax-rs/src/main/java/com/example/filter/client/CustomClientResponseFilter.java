package com.example.filter.client;


import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientResponseContext;
import jakarta.ws.rs.client.ClientResponseFilter;
import jakarta.ws.rs.ext.Provider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.stream.Collectors;

@Provider
public class CustomClientResponseFilter implements ClientResponseFilter {

    private static final Logger logger = LogManager.getLogger(CustomClientResponseFilter.class);

    @Override
    public void filter(ClientRequestContext requestContext,
                       ClientResponseContext responseContext) throws IOException {

        if (requestContext.getMethod().equals("POST") &&
                requestContext.getUri().getPath().startsWith("/api/server")) {

            InputStream is = responseContext.getEntityStream();
            String body = new BufferedReader(new InputStreamReader(is)).lines()
                    .collect(Collectors.joining("\n"));

            logger.debug("body: " + body);
            String sanitizedBody = body.replaceAll("[^A-Za-z0-9:{}\"]", "");
            logger.debug("sanitized json body: " + sanitizedBody);

            responseContext.setEntityStream(new ByteArrayInputStream((sanitizedBody).getBytes()));
        }
    }
}
