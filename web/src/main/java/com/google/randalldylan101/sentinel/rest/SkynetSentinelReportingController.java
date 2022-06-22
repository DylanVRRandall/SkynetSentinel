package com.google.randalldylan101.sentinel.rest;

import com.google.randalldylan101.sentinel.entities.Survivor;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/reporting")
public class SkynetSentinelReportingController
{
    private final EntityManager entityManager = Persistence.createEntityManagerFactory("my-app").createEntityManager();

    @GET
    @Path("/count/infected")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCountInfected()
    {
        entityManager.getTransaction().begin();
        Long infectedCount = (Long)entityManager.createNamedQuery("survivorGetInfectedCount").setParameter(1,Boolean.TRUE).getSingleResult();
        Long all = (Long)entityManager.createNamedQuery("survivorGetAllCount").getSingleResult();
        entityManager.getTransaction().commit();
        return Response.ok(String.format("%d Percent Infected (%d of %d people)",(infectedCount*100)/all,infectedCount,all)).build();
    }

    @GET
    @Path("/count/noninfected")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCountNonInfected()
    {
        entityManager.getTransaction().begin();
        Long nonInfectedcount = (Long)entityManager.createNamedQuery("survivorGetInfectedCount").setParameter(1,Boolean.FALSE).getSingleResult();
        Long all = (Long)entityManager.createNamedQuery("survivorGetAllCount").getSingleResult();
        entityManager.getTransaction().commit();
        return Response.ok(String.format("%d Percent Non-Infected (%d of %d people)",(nonInfectedcount*100)/all,nonInfectedcount,all)).build();
    }

    @GET
    @Path("/get/infected")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInfected()
    {
        entityManager.getTransaction().begin();
        List<Survivor> infectedHumans = entityManager.createNamedQuery("survivorGetInfected").setParameter(1,Boolean.TRUE).getResultList();
        entityManager.getTransaction().commit();
        return Response.ok(infectedHumans).build();
    }

    @GET
    @Path("/get/noninfected")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNonInfected()
    {
        entityManager.getTransaction().begin();
        List<Survivor> nonInfectedHumans = entityManager.createNamedQuery("survivorGetInfected").setParameter(1,Boolean.FALSE).getResultList();
        entityManager.getTransaction().commit();
        return Response.ok(nonInfectedHumans).build();
    }
}
