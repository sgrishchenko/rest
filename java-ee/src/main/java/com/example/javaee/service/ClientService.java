package com.example.javaee.service;

import com.example.javaee.entity.Client;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/client")
@Stateless
public class ClientService {
    @PersistenceContext
    private EntityManager entityManager;

    @POST
    @Produces(MediaType.APPLICATION_XML)
    public Client read(Client client) {
        entityManager.persist(client);
        return client;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Client read(@PathParam("id") long id) {
        return entityManager.find(Client.class, id);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") long id, Client client) {
        client.setId(id);
        entityManager.merge(client);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") long id) {
        entityManager.remove(entityManager.getReference(Client.class, id));
    }
}
