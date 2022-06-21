package com.google.randalldylan101.sentinel.rest;

import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.randalldylan101.sentinel.entities.Survivor;

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

	private EntityManager entityManager = Persistence.createEntityManagerFactory("my-app").createEntityManager();

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
		entityManager.merge(survivor);
		return Response.ok("Location updated for survivor!").build();

	}

	@PUT
	@Path("/flag")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response flagAsInfected(Survivor survivor) {
		entityManager.merge(survivor);
		return Response.ok("Survivor flagged as infected!").build();
	}
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get() 
	{
		entityManager.getTransaction().begin();
		List<Survivor> ls = entityManager.createNamedQuery("survivorGetAll").getResultList();
		entityManager.getTransaction().commit();
		return Response.ok(ls).build();
	}
}
