package com.codetest.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="STUDENTS")
public class StudentEnt {

	@Id
	@Column(name="ID")
	private Long id;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="STUDENT_ID")
	private List<EnrolmentEnt> enrolments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public List<EnrolmentEnt> getEnrolments(){
		return this.enrolments;
	}
	
}
