package com.admin;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuPage {
	
	public void showMenu() throws ClassNotFoundException, SQLException
	
	{
		
		CheckProductQuantity cp=new CheckProductQuantity();
		
		UserList ulist=new UserList();
		
		UserHistory uhistory=new UserHistory();
		
		String cpq="1";
		String ul="2";
		String uh="3";
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Select the option: 1.Check product quantity 2.User list 3.User History 4.Logout");
		String option=sc.nextLine();
		
		if(option.equals(cpq))
		{
			cp.checkQuantity();
		}
		
		else if(option.equals(ul))
		{
			ulist.getUserList();
		}
		
		else if(option.equals(uh))
		{
			uhistory.getUserHistory();
		}
		
		else
		{
			System.out.println("You have sucessfully logout");
		}
	}
	
	

}
