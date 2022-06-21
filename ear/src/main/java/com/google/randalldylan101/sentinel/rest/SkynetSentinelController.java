package com.google.randalldylan101.sentinel.rest;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.randalldylan101.sentinel.entities.Survivor;

@Path("/survivors")
public class SkynetSentinelController
{
	//private EntityManager entityManager = 
	//@PersistenceContext(unitName = "my-app")
	private EntityManager entityManager;
	
	public void createEM()
	{
		Properties props = new Properties();
		
		props.put("javax.persistence.jdbc.driver","com.mysql.jdbc.Driver");
		props.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/db?autoReconnect=true&useSSL=false");
	    props.put("javax.persistence.jdbc.user","user");
		props.put("javax.persistence.jdbc.password","password");
		props.put("eclipselink.ddl-generation","create-tables");
		props.put("eclipselink.target-database","MySQL");
		props.put("eclipselink.logging.level.sql","fine");
		props.put("eclipselink.logging.parameters","true");
		

		
		
		entityManager = Persistence.createEntityManagerFactory("my-app",props).createEntityManager();
		
		/*
		 * String sqlSelectAllPersons = "SELECT * FROM person";
		String connectionUrl = "jdbc:mysql://localhost:3306/db?autoReconnect=true&useSSL=false";

		try (Connection conn = DriverManager.getConnection(connectionUrl, "user", "password"); 
		        PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons); 
		        ResultSet rs = ps.executeQuery()) {

		        while (rs.next()) {
		            long id = rs.getLong("ID");
		            String name = rs.getString("FIRST_NAME");
		            String lastName = rs.getString("LAST_NAME");

		            // do something with the extracted data...
		        }
		} catch (SQLException e) {
		    // handle the exception
			e.printStackTrace();
		}
		 */
	}

	
   
   @POST 
   @Path("/add") 
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public Response add(Survivor survivor)
   {
	   if (entityManager == null)
		   this.createEM();
	   entityManager.persist(survivor);
	   return Response.ok("Welcome survivor!").build();
   }  

   @PUT 
   @Path("/update") 
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public Response updateLocation(Survivor survivor)
   {
//	   while ( survivors.listIterator().hasNext())
//	   {
//		   Survivor survivor1 = survivors.listIterator().next();
//		   if (survivor.getName().equals(survivor1.getName()))
//		   {
//			   
//		   }
//	   }
	   
	   
	   return Response.ok("Location updated for survivor!").build();
	  
	   
   }  

   @PUT 
   @Path("/flag") 
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public Response flagAsInfected(Survivor survivor)
   {
	  // entityManager.merge(survivor);
	   
	   return Response.ok("Survivor flagged as infected!").build();
   }  
}
