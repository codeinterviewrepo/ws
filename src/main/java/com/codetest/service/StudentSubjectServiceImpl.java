package com.codetest.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.codetest.model.Student;
import com.codetest.model.Subject;
import com.codetest.entity.EnrolmentEnt;
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

	@Override
	public List<Student> getAllStudentsForSubject(String subjectId) {
		return em.createNamedQuery(EnrolmentEnt.GET_ENROLMENTS_FOR_SUBJECT, EnrolmentEnt.class)
				.setParameter("subjectId", subjectId)
				.getResultList().stream().map(Student::fromEnrolmentEnt)
				.collect(Collectors.toList());
	}
	
	
	
}
