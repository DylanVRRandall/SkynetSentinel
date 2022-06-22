package com.google.randalldylan101.sentinel.rest;

import com.google.randalldylan101.sentinel.beans.RobotCPU;
import com.google.randalldylan101.sentinel.service.RobotCPUService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Path("/robots")
public class RobotCPUController
{

   /**
    * Returns Skynets killer robots sorted by its respective model.
    * @return Response
    * @throws IOException The Robot Service may not be available.
    */
   @GET 
   @Path("/get") 
   @Produces(MediaType.TEXT_HTML)
   public Response get() throws IOException
   {
      RobotCPU[] robotCPUS = new RobotCPUService().get();

      if (robotCPUS != null && robotCPUS.length > 0)
         return Response.ok(Arrays.stream(robotCPUS).sorted(Comparator.comparing(RobotCPU::getModel)).collect(Collectors.toList())).build();

      return Response.serverError().build();
   }  
}
