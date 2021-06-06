package com.codetest.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codetest.model.Student;
import com.codetest.model.Subject;
import com.codetest.service.StudentSubjectService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("studentsubjectrest")
public class StudentSubjectRest{
	
	private static final String APOST_REG = "(”|“)";

	@Autowired
	private StudentSubjectService studentSubjectService;
	
	@GetMapping(path="/getAllSubjects", produces = "application/json")
	public List<Subject> getAllSubjects() {
		return studentSubjectService.getAllSubjects();
	}

	@GetMapping(path="//getStudentsforSubject/{id}", produces = "application/json")
	public List<Student> getStudentsforSubject(@PathVariable("id") String id) {
		if(id==null||id.trim().isEmpty())
			return null;
		return studentSubjectService.getAllStudentsForSubject(id);
	}

	@PostMapping(path="/ingest", produces = MediaType.APPLICATION_JSON_VALUE)
	public void ingest(@RequestBody String jsonInput) {
		if(jsonInput==null||jsonInput.trim().isEmpty())
			return;
		
		String sanitized = jsonInput.replaceAll(APOST_REG, "\"");
		
		Student student = null;
		try {
			student = new ObjectMapper().readValue(sanitized, Student.class);
			studentSubjectService.ingest(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
		
	
}