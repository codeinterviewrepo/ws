package com.codetest.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EnrolmentEntId {

	@Column(name="STUDENT_ID")
	private Long studentId;
	
	@Column(name="SUBJECT_ID")
	private String subjectId;
	
	public Long getStudentId() {
		return studentId;
	}
	
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	
}
