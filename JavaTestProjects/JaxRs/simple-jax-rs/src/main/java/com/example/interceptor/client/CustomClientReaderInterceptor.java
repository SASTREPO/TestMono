package com.example.interceptor.client;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.ReaderInterceptor;
import jakarta.ws.rs.ext.ReaderInterceptorContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.stream.Collectors;

@Provider
public class CustomClientReaderInterceptor implements ReaderInterceptor {

    private static final Logger logger = LogManager.getLogger(CustomClientReaderInterceptor.class);

    @Context
    private HttpServletRequest httpRequest;

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context)
            throws IOException, WebApplicationException {

        if (httpRequest.getMethod().equals("GET") &&
                httpRequest.getRequestURI().startsWith("/api/client/post/interceptor")) {

            InputStream is = context.getInputStream();
            String body = new BufferedReader(new InputStreamReader(is)).lines()
                    .collect(Collectors.joining("\n"));

            logger.debug("body: " + body);
            String sanitizedBody = body.replaceAll("[^A-Za-z0-9:{}\"]", "");
            logger.debug("sanitized json body: " + sanitizedBody);

            context.setInputStream(new ByteArrayInputStream((body).getBytes()));
        }

        return context.proceed();
    }
}
