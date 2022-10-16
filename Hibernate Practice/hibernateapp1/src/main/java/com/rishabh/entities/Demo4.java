package com.rishabh.entities;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo4 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentUnit");
		
		EntityManager em = emf.createEntityManager();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Student Roll Number To Whom you give Grace marks");
		
		int roll = sc.nextInt();
		
		Student student = em.find(Student.class, roll);
		
		if(student!=null)
		{
			System.out.println("Enter the grace marks");
			int grace = sc.nextInt();
			
			em.getTransaction().begin();
			
			student.setMarks(student.getMarks()+grace);
			
			em.getTransaction().commit();
			
			System.out.println("Student Marks Graced Successfully");
		}
		else
			System.out.println("Student Not Found..!!");
		
		em.close();
	}
}
