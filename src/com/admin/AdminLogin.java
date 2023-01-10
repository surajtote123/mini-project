package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminLogin {
	
	public void login() throws ClassNotFoundException, SQLException
	{
		
		MenuPage mp=new MenuPage();
		AdminLogin al=new AdminLogin();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Login Page for Admin");
		
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		
		System.out.println("Enter the user name");
		String auname=sc.nextLine();
		
		System.out.println("Enter the password");
		String apass=sc.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin_registration","root","root");
		
		PreparedStatement ps=con.prepareStatement("select * from admin_Info");
		
		ResultSet rs=ps.executeQuery();
		
		if(rs.next())
		{
			
			String un=rs.getString(3);
			String p=rs.getString(4);
			
			if(auname.equals(un) && apass.equals(p))
			{
				
				System.out.println("You have sucessfully login");
				
				System.out.println("----------------------------------------------------------------------------------------------------");
			     
				mp.showMenu();
			
			}
			
			else
			{
				System.out.println("----------------------------------------------------------------------------------------------------------");
				
				System.err.println("Invalid user name or password");
				
				al.login();
				
			}
			
			
			
		}
		
		
		
	}
	
	
	
}
