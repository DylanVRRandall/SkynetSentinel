package com.google.randalldylan101.sentinel.rest;

import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.Consumes; 
import javax.ws.rs.core.MediaType;
import com.google.randalldylan101.sentinel.beans.RobotCPU;
import com.google.randalldylan101.sentinel.entities.Survivor;

@Path("/robots")
public class RobotCPUController
{
   
   @GET 
   @Path("/get") 
   @Produces(MediaType.APPLICATION_JSON)
   public void get()
   {

   }  
}
