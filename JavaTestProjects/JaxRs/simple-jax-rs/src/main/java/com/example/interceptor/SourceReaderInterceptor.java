package com.example.interceptor;

import com.example.model.User;
import com.example.service.SearchUserService;
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
public class SourceReaderInterceptor implements ReaderInterceptor {

    private static final Logger logger = LogManager.getLogger(SourceReaderInterceptor.class);

    @Context
    private HttpServletRequest httpRequest;

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {

        if (httpRequest.getMethod().equals("POST") &&
                httpRequest.getRequestURI().startsWith("/api/testentrypoint/interceptor")) {

            InputStream is = context.getInputStream(); // SOURCE
            String body = new BufferedReader(new InputStreamReader(is)).lines()
                    .collect(Collectors.joining("\n"));

            logger.debug("body: " + body);

            User dbUser = SearchUserService.getUserByNameUnsafe(body);

            if (dbUser != null) {
                logger.debug(dbUser.toString());
            } else {
                logger.debug("User not found");
            }

            context.setInputStream(new ByteArrayInputStream((body).getBytes()));
        }

        // SOURCE: context.getInputStream()
        // SOURCE: context.getHeaders()

        return context.proceed();
    }
}
