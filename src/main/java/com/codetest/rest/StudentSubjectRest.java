package com.codetest.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("studentsubject")
@Produces(MediaType.APPLICATION_JSON)
public interface StudentSubjectRest {
	
	@GET
	@Path("/getAllSubjects")
    Response getAllSubjects();
     
    @Path("/getStudentsforSubject{id}")
    @GET
    Response getStudentsforSubject(@PathParam("id") String id);
    
    @Path("/ingest")
    @GET
    Response runIngestJob();

}
