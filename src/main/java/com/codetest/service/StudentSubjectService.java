package com.codetest.service;

import java.util.List;

import com.codetest.model.Student;
import com.codetest.model.Subject;

public interface StudentSubjectService {
	
	public List<Subject> getAllSubjects();
	
	public List<Student> getAllStudentsForSubject(String subjectId);
	
	public void ingest(Student student);

}
