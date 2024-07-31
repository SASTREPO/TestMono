package com.example.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.WriterInterceptor;
import jakarta.ws.rs.ext.WriterInterceptorContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

@Provider
public class CustomWriterInterceptor implements WriterInterceptor {

    private static final Logger logger = LogManager.getLogger(CustomWriterInterceptor.class);

    @Context
    private HttpServletRequest httpRequest;

    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
        if (httpRequest.getMethod().equals("GET") &&
                httpRequest.getRequestURI().startsWith("/api/interceptor/xss")) {

            logger.debug("body: " + context.getEntity());
            String sanitizedBody = context.getEntity().toString().replaceAll("[^A-Za-z0-9]", "");
            logger.debug("sanitized body: " + sanitizedBody);

            context.setEntity(sanitizedBody);
        }

        context.proceed();
    }
}
