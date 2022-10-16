package com.usecases;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.dao.AccountDao;
import com.dao.AccountDaoImpl;
import com.entities.Account;
import com.utility.EMUtil;

public class DepositBalanceUseCase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		AccountDao dao = new AccountDaoImpl();
		
		System.out.println("Enter Your Account Number");
		
		int accno = sc.nextInt();
		
		Account account = dao.findAccount(accno);
		
		if(account!=null)
		{
			System.out.println("Enter Your Amount to Deposit");
			int amount = sc.nextInt();
			
			account.setBalance(account.getBalance()+amount);
			
			boolean flag = dao.updateAccount(account);
			
			if(flag)
			{
				System.out.println("Amount Deposited Successfully to your account");
				System.out.println("Your Current Balance is "+account.getBalance());
			}
			else
				System.out.println("Technical Error");
		}else
			System.out.println("You Entered a wrong Account Number");
	}
}
