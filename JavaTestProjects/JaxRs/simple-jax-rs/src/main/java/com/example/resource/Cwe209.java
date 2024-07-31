package com.example.resource;

import com.example.exception.CustomException;
import com.example.exception.MappedException;
import com.example.model.User;
import com.example.service.SearchUserService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/cwe209")
public class Cwe209 {

    @GET
    @Path("/{name}/{type}")
    @Produces("application/json")
    public Response getName(@PathParam("name") String name, @PathParam("type") int type) throws SQLException {

        User user = null;

        try {
            user = SearchUserService.getUserByNameUnsafeThrowsEx(name);
        } catch (SQLException e) {
            if(type == 0 ) {
                throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("WebApplicationException: " + e.getMessage()).build());

//                JAX-RS exceptions that extends WebApplicationException
//                throw new ClientErrorException("ClientErrorException: " + e.getMessage(), Response.Status.BAD_REQUEST);
//                throw new BadRequestException("BadRequestException: " + e.getMessage());
//                throw new NotAuthorizedException("NotAuthorizedException: " + e.getMessage());
//                throw new ForbiddenException("ForbiddenException: " + e.getMessage());
//                throw new NotFoundException("NotFoundException: " + e.getMessage());
//                throw new NotAllowedException("NotAllowedException: " + e.getMessage());
//                throw new NotAcceptableException("NotAcceptableException: " + e.getMessage());
//                throw new NotSupportedException("NotSupportedException: " + e.getMessage());

//                throw new ServerErrorException("ServerErrorException: " + e.getMessage(), Response.Status.INTERNAL_SERVER_ERROR);
//                throw new InternalServerErrorException("InternalServerErrorException: " + e.getMessage());
//                throw new ServiceUnavailableException("ServiceUnavailableException: " + e.getMessage());

            } else if (type == 1) {
                throw new CustomException("CustomException: " + e.getMessage(), Response.Status.BAD_REQUEST);
            } else if (type == 2) {
                throw new MappedException("MappedException: " + e.getMessage());
            } else if (type == 3) {
                throw new SQLException("SQLException: " + e.getMessage());
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Response: " + e.getMessage()).build();
            }
        }

        return Response.status(Response.Status.OK).entity(user).build();
    }
}
