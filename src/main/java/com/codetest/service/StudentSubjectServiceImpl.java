package com.codetest.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codetest.model.Student;
import com.codetest.model.Subject;
import com.codetest.entity.EnrolmentEnt;
import com.codetest.entity.StudentEnt;
import com.codetest.entity.SubjectEnt;

@Component
public class StudentSubjectServiceImpl implements StudentSubjectService {

	@Autowired
	private EntityManager em;

	@Override
	public List<Subject> getAllSubjects() {
		return em.createNamedQuery(SubjectEnt.FIND_ALL_SUBJECTS, SubjectEnt.class)
				.getResultList().stream().map(Subject::fromSubjectEnt)
				.collect(Collectors.toList());
	}

	/**
	 * Goes to enrolment able to find subject ids, gets associated student records
	 */
	@Override
	public List<Student> getAllStudentsForSubject(String subjectId) {
		return em.createNamedQuery(EnrolmentEnt.GET_ENROLMENTS_FOR_SUBJECT, EnrolmentEnt.class)
				.setParameter("subjectId", subjectId)
				.getResultList().stream().map(e->Student.fromStudentEnt(e.getStudentEnt()))
				.collect(Collectors.toList());
	}

	/**
	 * Input data contains information for enrolments, students and subjects
	 * 
	 * If the Id is already known, update the entity where appropriate
	 * 
	 */
	@Override
	@Transactional
	public void ingest(Student student) {
		StudentEnt studentEnt = student.toStudentEnt();
		if(em.find(StudentEnt.class, studentEnt.getId())==null)
			em.persist(studentEnt);
		
		for(Subject subject : student.getClassDetails()) {
			
			SubjectEnt subjectEnt = em.find(SubjectEnt.class, subject.getSubjectCode().trim());
			if(subjectEnt==null) {
				em.persist(subject.toSubjectEnt());
			}
			else {
				subject.mapFields(subjectEnt);
			}
			
			EnrolmentEnt enrolmentEnt = new EnrolmentEnt(student.getId(), subject.getSubjectCode());
			if(em.find(EnrolmentEnt.class, enrolmentEnt.getId())==null)
				em.persist(enrolmentEnt);
		}
	}
	
	
	
}
