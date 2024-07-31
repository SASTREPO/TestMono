package com.example.resource;

import jakarta.enterprise.context.RequestScoped;
import jakarta.validation.constraints.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Path("validation")
@RequestScoped
public class ValidationResource {

    private static final Logger logger = LogManager.getLogger(ValidationResource.class);

    @GET
    @Path("null")
    @Produces(MediaType.TEXT_HTML)
    public String nullValue(@Null @QueryParam("input") String input) {

        // Sanitized XSS Sink. input is validated in method argument declaration.
        return input;
    }

    @GET
    @Path("number")
    @Produces(MediaType.TEXT_HTML)
    public String number(@Min(1) @QueryParam("input1") String input1,
                        @Max(10) @QueryParam("input2") String input2,
                        @DecimalMin(value = "0.1", inclusive = false) @QueryParam("input3") String input3,
                        @DecimalMax(value = "1000000", inclusive = false) @QueryParam("input4") String input4,
                        @Negative @QueryParam("input5") String input5,
                        @NegativeOrZero @QueryParam("input6") String input6,
                        @Positive @QueryParam("input7") String input7,
                        @PositiveOrZero @QueryParam("input8") String input8,
                        @Size(min = 2, max = 10) @QueryParam("input9") String input9,
                        @Digits(integer=9, fraction=2) @QueryParam("input10") String input10) {

        // Sanitized XSS Sink. inputs are validated in method argument declaration.
        return input1 + " " +
                input2 + " " +
                input3 + " " +
                input4 + " " +
                input5 + " " +
                input6 + " " +
                input7 + " " +
                input8 + " " +
                input9 + " " +
                input10;
    }

    @GET
    @Path("pattern")
    @Produces(MediaType.TEXT_HTML)
    public String pattern(@Pattern(regexp = "[0-9]*") @QueryParam("input") String input) {

        // Sanitized XSS Sink. input is validated in method argument declaration.
        return input;
    }

    @GET
    @Path("email")
    @Produces(MediaType.TEXT_HTML)
    public String email(@Email @QueryParam("input") String input) {

        // Sanitized XSS Sink. input is validated in method argument declaration.
        return input;
    }
}
