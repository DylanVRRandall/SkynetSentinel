package com.google.randalldylan101.sentinel.rest;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.randalldylan101.sentinel.service.RobotCPUService;

@Path("/robots")
public class RobotCPUController
{
   
   @GET 
   @Path("/get") 
   @Produces(MediaType.APPLICATION_JSON)
   public Response get() throws IOException
   {
      return new RobotCPUService().get();
   }  
}
