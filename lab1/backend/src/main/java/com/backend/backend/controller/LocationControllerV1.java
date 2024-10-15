package com.backend.backend.controller;

import com.backend.backend.model.entities.Location;
import com.backend.backend.service.impl.LocationServiceImpl;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/v1/location")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LocationControllerV1 {

    @Inject
    private LocationServiceImpl service;

    @POST
    public Response createLocation(Location location) {
        service.save(location);
        return Response.status(Response.Status.CREATED).entity(location).build();
    }

    @GET
    @Path("/{id}")
    public Response getLocation(@PathParam("id") Long id) {
        Location location = service.findById(id);
        if (location != null) {
            return Response.ok(location).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    public List<Location> getAllLocations() {
        return service.findAll();
    }

    @PUT
    public Response updateLocation(Location location) {
        Location updatedLocation = service.update(location);
        if (updatedLocation != null) {
            return Response.ok(updatedLocation).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteLocation(@PathParam("id") Long id) {
        service.deleteById(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
