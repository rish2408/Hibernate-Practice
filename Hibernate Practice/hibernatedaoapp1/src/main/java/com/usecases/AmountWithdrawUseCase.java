package com.usecases;

import java.util.Scanner;

import com.dao.AccountDao;
import com.dao.AccountDaoImpl;
import com.entities.Account;

public class AmountWithdrawUseCase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		AccountDao dao = new AccountDaoImpl();
		
		System.out.println("Enter Your Account Number");
		
		int accno = sc.nextInt();
		
		Account account = dao.findAccount(accno);
		
		if(account!=null)
		{
			System.out.println("Enter the amount you want to withdraw");
			int withdraw_ammount = sc.nextInt();
			
			if(withdraw_ammount < account.getBalance())
			{
				account.setBalance(account.getBalance()-withdraw_ammount);
				boolean flag = dao.updateAccount(account);
				if(flag)
				{
					System.out.println("Please Collect Your Cash");
					System.out.println("Your Balance is "+account.getBalance());
				}
				else
					System.out.println("Technical Error..!!");
			}
			else
				System.out.println("Insufficient Balance");
		}else {
			System.out.println("Account Does Not Exist");
		}
	}
}
