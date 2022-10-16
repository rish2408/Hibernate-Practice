package com.rishabh.entities;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo3 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentUnit");
		
		EntityManager em = emf.createEntityManager();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Student Roll Number whom you want to delete");
		
		int roll = sc.nextInt();
		
		Student student = em.find(Student.class, roll);
		
		if(student!=null)
		{
			em.getTransaction().begin();
			
			em.remove(student);
			
			em.getTransaction().commit();
			
			System.out.println("Student Removed Successfully");
		}
		else
			System.out.println("Student Not Found..!!");
		
		em.close();
	}
}
