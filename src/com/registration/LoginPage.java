package com.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.admin.InvalidUserNameOrPassword;
import com.product_selection.ProductList;

public class LoginPage {
	
	
	
	public void doLogin() throws ClassNotFoundException, SQLException, InterruptedException
	{
		String l="1";
		String fp="2";
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Select the option: 1.Login 2.Forget password");
		String option=sc.nextLine();
		
		System.out.println("--------------------------------------------------------------------------------");
		
		LoginPage lp=new LoginPage();
		
		ProductList pl=new ProductList();
		
		
		if(option.equals(l))
		{
			System.out.println("Login page for customer");
			
			System.out.println("------------------------------------------------------------------------------");
		
			System.out.println("Enter the Username");
		String custUserName=sc.nextLine();
		
		System.out.println("Enter the Password");
		String custPassword=sc.nextLine();
		
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registrations_form","root","root");
		
		PreparedStatement ps1=con.prepareStatement("select * from forms where Customer_UserName=? and Customer_Password=?");
		ps1.setString(1, custUserName);
		ps1.setString(2, custPassword);
		
		ResultSet rs=ps1.executeQuery();
	
	
		
		if(rs.next())
		{
			
			
		
		     String uname=rs.getString(6);
		     String pass=rs.getString(7);
		    
		     
		    
		      if(custUserName.equals(uname) && custPassword.equals(pass))
					
		     {
		           System.out.println("Welcome in Application");
		           
		           
		           pl.getProductList();
		     }
		      
		  
		 }
	
		else
		{
			
			System.out.println("-------------------------------------------------------------------");
			System.out.println("\n");
			System.err.println("Invalid Username or Password");
			System.out.println("\n");
			System.out.println("---------------------------------------------------------------------");
			
	    	 lp.doLogin();
		}
	}
		
		else if(option.equals(fp))
		{
			System.out.println("----------------------------------------------------------------------------------------");
			
			System.out.println("Enter the user name");
			String uname=sc.nextLine();
			
			System.out.println("Enter the mobile number");
			String number=sc.nextLine();
			
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			 
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registrations_form","root","root");
			 
			PreparedStatement ps1=con.prepareStatement("select * from forms where Customer_UserName=? and Customer_MObileNumber=?");
			 
			 ps1.setString(1, uname);
			 ps1.setString(2, number);
			 
			 ResultSet rs=ps1.executeQuery();
			 
			 if(rs.next())
			 {
			 
			String un=rs.getString(6);
			String cmn=rs.getString(5);
			
			if(number.equals(cmn) && uname.equals(un))
			{
			System.out.println("Enter new password");
			String newpass=sc.nextLine();
			
			 PreparedStatement ps=con.prepareStatement("update forms set Customer_Password=? where Customer_MObileNumber=? ");
			 
			 ps.setString(1, newpass);
			 ps.setString(2, number);
			 
			 ps.execute();
			 
			 System.out.println("You have sucessfully change the password");
			 
			 lp.doLogin();
		}
	}
			 
			 else
			 {
				 System.out.println("----------------------------------------------------------------------------------");
				 System.err.println("Invalid user name or mobile number");
				 System.out.println("--------------------------------------------------------------------------------------------");
				 lp.doLogin();
			 }
	}
	}

}
