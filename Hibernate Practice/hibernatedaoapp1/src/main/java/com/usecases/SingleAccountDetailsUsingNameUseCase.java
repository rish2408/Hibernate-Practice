package com.usecases;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.entities.Account;
import com.utility.EMUtil;

public class SingleAccountDetailsUsingNameUseCase {

	public static void main(String[] args) {
		
		EntityManager em = EMUtil.getEntityManager();
		
		//String jpql= "select a from Account a where a.name='Mansi Soni' ";
		String jpql = "from Account where name='Mansi Soni'";
		
		Query query = em.createQuery(jpql);
		
		Object object = query.getSingleResult();
		
		Account account = (Account)object;
		
		System.out.println("Your Account Number is - "+account.getAccno());
		System.out.println("Your Account Name is - "+account.getName());
		System.out.println("Your Account Balance is - "+account.getBalance());
		System.out.println("============================================");
		
		em.close();
	}
}
