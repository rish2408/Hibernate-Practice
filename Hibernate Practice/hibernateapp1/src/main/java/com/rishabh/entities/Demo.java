package com.rishabh.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentUnit");
		
		EntityManager em = emf.createEntityManager();
		
		Student student = em.find(Student.class, 40);
		
		if(student!=null)
			System.out.println(student);
		else
			System.out.println("Student Not Found !!..");
		
		em.close();
	}
}
