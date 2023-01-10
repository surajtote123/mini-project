package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserList {
	
	public void getUserList() throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		
		MenuPage mp=new MenuPage();
		
		String gtm="1";
		String e="2";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registrations_form","root","root");
		
		PreparedStatement ps=con.prepareStatement("select * from forms");
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			
			System.out.println("--------------------------------------------------------------------------------------------------------");
			
			System.out.println("Customer Id = " + rs.getInt(1));
			
			System.out.println("Customer Name = " + rs.getString(2));
			
			System.out.println("Customer Address = " + rs.getString(3));
			
			System.out.println("Customer Email = " + rs.getString(4));
			
			System.out.println("Customer mobile number = " + rs.getString(5));
			
			System.out.println("---------------------------------------------------------------------------------------------------------");
		}
		
		System.out.println("Select the option: 1.Go to menu 2.Exit");
		String option=sc.next();
		
		if(option.equals(gtm))
		{
			mp.showMenu();
		}
		
		else
		{
			System.out.println("You have sucessfully logout");
		}
	}

	
	}


