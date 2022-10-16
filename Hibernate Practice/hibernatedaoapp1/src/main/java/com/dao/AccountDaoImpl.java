package com.dao;

import javax.persistence.EntityManager;

import com.entities.Account;
import com.utility.EMUtil;

public class AccountDaoImpl implements AccountDao {

	public boolean createAccount(Account account) {
		boolean flag = false;

		EntityManager em = EMUtil.getEntityManager();

		em.getTransaction().begin();

		em.persist(account);
		flag = true;

		em.getTransaction().commit();

		em.close();
		return flag;
	}

	public boolean deleteAccount(int accno) {
		boolean flag = false;

		EntityManager em = EMUtil.getEntityManager();

		Account account = em.find(Account.class, accno);

		if (account != null) {
			em.getTransaction().begin();

			em.remove(account);
			flag = true;
			
			em.getTransaction().commit();
		}

		em.close();
		return flag;
	}

	public boolean updateAccount(Account account) {
		
		boolean flag = false;
		
		EntityManager em = EMUtil.getEntityManager();
		
		Account account2 = em.find(Account.class, account.getAccno());
		
		if(account2!=null)
		{
			em.getTransaction().begin();
			
			em.merge(account);
			flag = true;
			
			em.getTransaction().commit();
		}else
		{
			throw new IllegalArgumentException("Invalid Account");
		}
		
		em.close();
		return flag;
	}

	public Account findAccount(int accno) {
		
		Account account3 = null;
		
		EntityManager em = EMUtil.getEntityManager();
		
		account3 = em.find(Account.class, accno);
		
		return account3;
		
	}

}
