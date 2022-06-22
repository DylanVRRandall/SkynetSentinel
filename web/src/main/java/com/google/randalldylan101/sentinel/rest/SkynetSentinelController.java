package com.google.randalldylan101.sentinel.rest;

import com.google.randalldylan101.sentinel.entities.Survivor;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/survivors")
public class SkynetSentinelController {

	public SkynetSentinelController()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	private final EntityManager entityManager = Persistence.createEntityManagerFactory("my-app").createEntityManager();

	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Survivor survivor) {
		entityManager.getTransaction().begin();
		entityManager.persist(survivor);
		entityManager.getTransaction().commit();
		return Response.ok("Welcome survivor!").build();
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateLocation(Survivor survivor) {
		entityManager.getTransaction().begin();
		entityManager.merge(survivor);
		entityManager.getTransaction().commit();
		return Response.ok("Location updated for survivor!").build();

	}

	@PUT
	@Path("/flag")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response flagAsInfected(Survivor survivor) {
		survivor.setInfected(Boolean.TRUE);
		entityManager.getTransaction().begin();
		entityManager.merge(survivor);
		entityManager.getTransaction().commit();
		return Response.ok("Survivor flagged as infected!").build();
	}
}
