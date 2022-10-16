package com.usecases;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.entities.Account;
import com.utility.EMUtil;

public class JPQLQueryUseCase {

	public static void main(String[] args) {
		
		EntityManager em = EMUtil.getEntityManager();
		
		String jpql = "select a from Account a";
		
		Query query = em.createQuery(jpql);
		
		List<Account> list = query.getResultList();
		
		System.out.println("All Account Holder Details :");
		System.out.println("------------------------------");
		
		list.forEach(a -> {
			System.out.println("Your Account Number is - "+a.getAccno());
			System.out.println("Your Account Name is - "+a.getName());
			System.out.println("Your Account Balance is - "+a.getBalance());
			System.out.println("============================================");
		});
		
		em.close(); 
	}
}
