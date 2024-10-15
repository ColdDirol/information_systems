package com.backend.backend.controller;

import com.backend.backend.model.entities.Person;
import com.backend.backend.service.impl.PersonServiceImpl;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/v1/person")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonControllerV1 {

    @Inject
    private PersonServiceImpl service;

    @POST
    public Response createPerson(Person person) {
        service.save(person);
        return Response.status(Response.Status.CREATED).entity(person).build();
    }

    @GET
    @Path("/{id}")
    public Response getPerson(@PathParam("id") Long id) {
        Person person = service.findById(id);
        if (person != null) {
            return Response.ok(person).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    public List<Person> getAllPersons() {
        return service.findAll();
    }

    @PUT
    public Response updatePerson(Person person) {
        Person updatedPerson = service.update(person);
        if (updatedPerson != null) {
            return Response.ok(updatedPerson).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePerson(@PathParam("id") Long id) {
        service.deleteById(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
