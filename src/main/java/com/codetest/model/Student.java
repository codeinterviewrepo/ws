package com.codetest.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.codetest.entity.StudentEnt;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
	
	@JsonProperty("student_id")
	private Long id;
	
	@JsonProperty("class_details")
	private List<Subject> classDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Subject> getClassDetails() {
		return this.classDetails;
	}
	
	public void setClassDetails(List<Subject> classDetails) {
		this.classDetails = classDetails;
	}
	
	public StudentEnt toStudentEnt() {
		StudentEnt sEnt = new StudentEnt();
		sEnt.setId(this.id);
		return sEnt;
	}
	
	public static Student fromStudentEnt(StudentEnt ent) {
		Student s = new Student();
		s.setId(ent.getId());
		s.setClassDetails(new ArrayList<>());
		if(ent.getEnrolments()!=null&&!ent.getEnrolments().isEmpty())
			s.getClassDetails().addAll(ent.getEnrolments()
				.stream().map(e->Subject.fromSubjectEnt(e.getSubjectEnt())).collect(Collectors.toList()));
		return s;
	}

}
