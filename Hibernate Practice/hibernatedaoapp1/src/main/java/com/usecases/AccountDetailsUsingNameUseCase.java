package com.usecases;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.entities.Account;
import com.utility.EMUtil;

public class AccountDetailsUsingNameUseCase {

	public static void main(String[] args) {

		EntityManager em = EMUtil.getEntityManager();

		//String jpql= "select a from Account a where a.name='Rishabh Srivastava' ";
		String jpql = "from Account where name='Rishabh Srivastava'";
		Query q = em.createQuery(jpql);

		List<Account> list = q.getResultList();

		list.forEach(a -> {
			System.out.println("Your Account Number is - "+a.getAccno());
			System.out.println("Your Account Name is - "+a.getName());
			System.out.println("Your Account Balance is - "+a.getBalance());
			System.out.println("============================================");
		});

		em.close();
	}
}
