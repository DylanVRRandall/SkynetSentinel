package com.google.randalldylan101.sentinel.rest;

import javax.ws.rs.POST; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.Consumes; 
import javax.ws.rs.core.MediaType;

import com.google.randalldylan101.sentinel.beans.Survivor;

@Path("/survivors")
public class SkynetSentinelController
{
   
   @POST 
   @Path("/add") 
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public void add(Survivor survivor)
   {
      
   }  

   @POST 
   @Path("/update") 
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public void updateLocation(Survivor survivor)
   {
      
   }  

   @POST 
   @Path("/flag") 
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public void flagAsInfected(Survivor survivor)
   {
      
   }  
}
