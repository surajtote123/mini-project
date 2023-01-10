package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserHistory {
	
	public void getUserHistory() throws ClassNotFoundException, SQLException
	{
		
		MenuPage mp=new MenuPage();
		
		String gtm="1";
		String e="2";
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the customer name");
		String cname=sc.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_history","root","root");
		
		PreparedStatement ps=con.prepareStatement("select * from history where Customer_Name=?");
		
		ps.setString(1, cname);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			System.out.println("-------------------------------------------------------------------------");
			
			System.out.println("Product Id = " + rs.getInt(2));
			
			System.out.println("Product Name = " + rs.getString(3));
			
			System.out.println("Product Price = " + rs.getLong(4));
			
			System.out.println("Total Product quantity = " + rs.getLong(5));
			
			System.out.println("Total Price = " + rs.getLong(6));
			
			System.out.println("------------------------------------------------------------------");
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
