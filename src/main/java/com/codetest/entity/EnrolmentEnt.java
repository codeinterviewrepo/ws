package com.codetest.entity;

import static com.codetest.entity.EnrolmentEnt.GET_ENROLMENTS_FOR_SUBJECT;
import static com.codetest.entity.EnrolmentEnt.TABLE_NAME;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name=TABLE_NAME)
@NamedQuery(name = GET_ENROLMENTS_FOR_SUBJECT, query = "select e from EnrolmentEnt e where id.subjectId = :subjectId")
public class EnrolmentEnt {
	
	public static final String TABLE_NAME = "ENROLMENTS";
	public static final String GET_ENROLMENTS_FOR_SUBJECT = "ENROLMENTS.forSubject";
	
	@EmbeddedId
	private EnrolmentEntId id;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="STUDENT_ID", referencedColumnName = "ID", insertable=false, updatable=false)
	private StudentEnt studentEnt;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="SUBJECT_ID", referencedColumnName = "SUBJECT_CODE", insertable=false, updatable=false)
	private SubjectEnt subjectEnt;
	
	public EnrolmentEnt() {
		//default constructor
	}
	
	public EnrolmentEnt(EnrolmentEntId id) {
		this.id = id;
	}
	
	public EnrolmentEnt(Long studentId, String subjectId) {
		this.id = new EnrolmentEntId();
		this.id.setStudentId(studentId);
		this.id.setSubjectId(subjectId);
	}
	
	public EnrolmentEntId getId() {
		return this.id;
	}
	
	public StudentEnt getStudentEnt() {
		return this.studentEnt;
	}
	
	public SubjectEnt getSubjectEnt() {
		return this.subjectEnt;
	}
	

}
