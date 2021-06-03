package com.codetest.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import static com.codetest.entity.EnrolmentEnt.GET_ENROLMENTS_FOR_SUBJECT;
import static com.codetest.entity.EnrolmentEnt.TABLE_NAME;

@Entity
@Table(name=TABLE_NAME)
@NamedQuery(name = GET_ENROLMENTS_FOR_SUBJECT, query = "select e from enrolmentEnt where id.subjectId = :subjectId")
public class EnrolmentEnt {
	
	public static final String TABLE_NAME = "ENROLMENTS";
	public static final String GET_ENROLMENTS_FOR_SUBJECT = "ENROLMENTS.forSubject";
	
	@EmbeddedId
	private EnrolmentEntId id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id.STUDENT_ID")
	private StudentEnt studentEnt;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id.SUBJECT_ID")
	private SubjectEnt subjectEnt;
	
	public EnrolmentEnt(EnrolmentEntId id) {
		this.id = id;
	}
	
	public EnrolmentEntId getId() {
		return this.id;
	}
	

}
