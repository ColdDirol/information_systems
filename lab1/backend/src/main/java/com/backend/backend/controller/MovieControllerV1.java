package com.backend.backend.controller;

import com.backend.backend.model.entities.Movie;
import com.backend.backend.service.impl.MovieServiceImpl;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/v1/movie")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieControllerV1 {

    @Inject
    private MovieServiceImpl service;

    @POST
    public Response createMovie(Movie movie) {
        service.save(movie);
        return Response.status(Response.Status.CREATED).entity(movie).build();
    }

    @GET
    @Path("/{id}")
    public Response getMovie(@PathParam("id") Long id) {
        Movie movie = service.findById(id);
        if (movie != null) {
            return Response.ok(movie).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    public List<Movie> getAllMovies() {
        return service.findAll();
    }

    @PUT
    public Response updateMovie(Movie movie) {
        Movie updatedMovie = service.update(movie);
        if (updatedMovie != null) {
            return Response.ok(updatedMovie).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMovie(@PathParam("id") Long id) {
        service.deleteById(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
