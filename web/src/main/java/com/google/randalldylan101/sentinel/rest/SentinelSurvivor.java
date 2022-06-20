package com.google.randalldylan101.sentinel.rest;

import javax.ws.rs.POST; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;

@Path("/survivor")
public class SentinelSurvivor
{
   
   @POST 
   @Path("/add") 
   @Produces(MediaType.APPLICATION_JSON)
   public void add(){ 
      
   }  
}
