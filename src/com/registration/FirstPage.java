package com.registration;

import java.sql.SQLException;
import java.util.Scanner;

import com.admin.AdminLogin;

public class FirstPage {

	public void selectType() throws ClassNotFoundException, SQLException, InterruptedException
	{
		Scanner sc=new Scanner(System.in);
		
		SelectRegistrationType srt=new SelectRegistrationType();
		
		AdminLogin al=new AdminLogin();
		
		String c="1";
		
		String a="2";
		
		System.out.println("Select the following option: 1.Customer 2.Admin");
		String option=sc.nextLine();
		
		if(option.equals(c))
		{
			System.out.println("------------------------------------------------------------------------");
			srt.selectOption();
		}
		
		else
		{
			System.out.println("----------------------------------------------------------------------------");
			al.login();
			System.out.println("-------------------------------------------------------------------------------");
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		
		FirstPage fp=new FirstPage();
		
		fp.selectType();
	}
}
