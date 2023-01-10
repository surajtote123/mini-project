package com.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DoRegistrationFirst {

	String nu = "New user";
	String ar = "Already registered";
	String custName;
	String custAddress;
	String custEmail;
	String custMobileNumber;
	String custUserName;
	transient String custpassword;

	public void doRegistration() throws ClassNotFoundException, SQLException, InterruptedException
	{
		  
		LoginPage lp=new LoginPage();
		
		    Scanner sc=new Scanner(System.in);
		    
		    System.out.println("------------Registration Page------------------------");
		
		    System.out.println("Enter the your full name");
			String custName=sc.nextLine();
			
			System.out.println("Enter your address");
			String custAddress=sc.nextLine();
			
			System.out.println("Enter your Email");
			String custEmail=sc.nextLine();
			
			System.out.println("Enter your mobile number");
			String custMobileNumber=sc.next();
			
			System.out.println("Set the username");
			String custUserName=sc.next();
			
			System.out.println("Set the password");
		    String custPassword=sc.next();
			
			System.out.println("-------------------------------------------------------------------------");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registrations_form","root","root");
			
			PreparedStatement ps=con.prepareStatement("insert into forms(Customer_Name,Customer_Address,Customer_Email,Customer_MObileNumber,Customer_UserName,Customer_Password) values (?,?,?,?,?,?)");
			
			ps.setString(1, custName);
			ps.setString(2, custAddress);
			ps.setString(3, custEmail);
			ps.setString(4, custMobileNumber);
			ps.setString(5, custUserName);
		    ps.setString(6, custPassword);
			
			ps.execute();
			
			System.out.println("You have sucessfully registered");
			
			System.out.println("-----------------------------------------------------------------------");
		
		lp.doLogin();
		
		
		 
	}
	
	

}
