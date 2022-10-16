package com.rishabh.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo2 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentUnit");
		
		EntityManager em = emf.createEntityManager();
		
//		Student st = new Student(20, "Shyam", 810);
		
		Student st = new Student();
		st.setName("Sita");
		st.setMarks(900);
		
		Product pd = new Product();
		pd.setPname("Pencil");
		pd.setPrice(20);
		
		em.getTransaction().begin();
		
		em.persist(st);
		em.persist(pd);
		
		em.getTransaction().commit();
		
		em.close();
		
		System.out.println("Student Inserted Successfully");
		System.out.println("Product Inserted Successfully");
	}
}
