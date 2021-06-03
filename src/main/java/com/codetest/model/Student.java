package com.codetest.model;

import java.util.List;

import com.codetest.entity.EnrolmentEnt;

public class Student {
	
	private Long id;
	private List<Subject> classDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public List getClassDetails() {
		return this.classDetails;
	}
	
	public void setClassDetails(List<Subject> classDetails) {
		this.classDetails = classDetails;
	}
	
	public static Student fromEnrolmentEnt(EnrolmentEnt enrolment) {
		Student s = new Student();
		s.setId(enrolment.getId().getStudentId());
		return s;
	}


}
