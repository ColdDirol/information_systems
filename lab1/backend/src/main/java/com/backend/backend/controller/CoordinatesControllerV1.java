package com.backend.backend.controller;

import com.backend.backend.model.entities.Coordinates;
import com.backend.backend.service.impl.CoordinatesServiceImpl;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/v1/coordinates")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoordinatesControllerV1 {

    @Inject
    private CoordinatesServiceImpl service;

    @POST
    public Response create(Coordinates coordinates) {
        System.out.println("coordinates: " + coordinates.getX());
        System.out.println("coordinates: " + coordinates.getY());
        service.save(coordinates);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Coordinates coordinates = service.findById(id);
        if (coordinates == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(coordinates).build();
    }

    @GET
    public List<Coordinates> findAll() {
        return service.findAll();
    }

    @PUT
    public Response update(Coordinates coordinates) {
        Coordinates updatedCoordinates = service.update(coordinates);
        return Response.ok(updatedCoordinates).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") Long id) {
        service.deleteById(id);
        return Response.noContent().build();
    }
}
