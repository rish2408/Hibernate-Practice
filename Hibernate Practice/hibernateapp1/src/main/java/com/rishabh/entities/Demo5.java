package com.rishabh.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo5 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentUnit");
		
		EntityManager em = emf.createEntityManager();
		
		Student student = em.find(Student.class, 20);
		
		em.clear();	// Detached State
		
		em.getTransaction().begin();
		
		student.setMarks(500);
		
//		em.persist(student); // It will throw duplicate ID exception
		
		em.merge(student);	// Persistence State
		
		em.getTransaction().commit();
		
		em.close();

	}
}
