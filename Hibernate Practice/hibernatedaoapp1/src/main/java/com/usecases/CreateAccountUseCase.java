package com.usecases;

import java.util.Scanner;

import com.dao.AccountDao;
import com.dao.AccountDaoImpl;
import com.entities.Account;

public class CreateAccountUseCase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		AccountDao dao = new AccountDaoImpl();
		
		System.out.println("Enter Your Name");
		String name = sc.nextLine();
		
		Account acc = new Account();
		acc.setName(name);
		acc.setBalance(0);
		
		boolean flag = dao.createAccount(acc);
		
		if(flag)
			System.out.println("Your Account is Created With Zero Balance");
		else
			System.out.println("Account Not Created");
	}
}
