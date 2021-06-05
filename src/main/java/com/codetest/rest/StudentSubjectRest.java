package com.codetest.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.codetest.model.Student;
import com.codetest.model.Subject;
import com.codetest.service.StudentSubjectService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Path("studentsubjectrest")
public class StudentSubjectRest{
	
	private static final String APOST_REG = "(”|“)";

	@Autowired
	private StudentSubjectService studentSubjectService;
	
	@GET
	@Path("/getAllSubjects")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Subject> getAllSubjects() {
		return studentSubjectService.getAllSubjects();
	}

	@GET
	@Path("/getStudentsforSubject/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudentsforSubject(@PathParam("id") String id) {
		if(id==null||id.trim().isEmpty())
			return null;
		return studentSubjectService.getAllStudentsForSubject(id);
	}

	@POST
	@Path("/ingest")
	public Response ingest(String jsonInput) {
		if(jsonInput==null||jsonInput.trim().isEmpty())
			return Response.status(Status.BAD_REQUEST).build();
		
		String sanitized = jsonInput.replaceAll(APOST_REG, "\"");
		
		Student student = null;
		try {
			student = new ObjectMapper().readValue(sanitized, Student.class);
			studentSubjectService.ingest(student);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		return Response.ok().build();
	}
	
		
	
}