package com.registration;

import java.sql.SQLException;
import java.util.Scanner;

public class SelectRegistrationType {
	
	String nu="1";
	String ar="2";
	
	public void selectOption() throws ClassNotFoundException, SQLException, InterruptedException
	{
		DoRegistrationFirst df=new DoRegistrationFirst();
		
		LoginPage lp=new LoginPage();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Select the following option- 1.New user 2.Already registered");
		String customersOption=sc.nextLine();
		
		if(customersOption.equals(nu))
		{
			System.out.println("----------------------------------------------------------------------");
			//System.out.println("\n");
			df.doRegistration();
		}
		
		else
		{
			System.out.println("------------------------------------------------------------------------");
			//System.out.println("\n");
			lp.doLogin();
		}
	}

	
}
