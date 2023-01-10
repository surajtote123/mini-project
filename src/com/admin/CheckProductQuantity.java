package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CheckProductQuantity {
	
	public void checkQuantity() throws ClassNotFoundException, SQLException
	{
		
		Scanner sc=new Scanner(System.in);
		
		String ap="1";
		String gtm="2";
		
		MenuPage mp=new MenuPage();
		
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Enter the product Id to check the product quantity");
		long id=sc.nextLong();
		System.out.println("---------------------------------------------------------------------------------");
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product_list","root","root");
		
		PreparedStatement ps=con.prepareStatement("select * from product where Product_Id=?");
		
		ps.setLong(1, id);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			System.out.println("Product Name = " + rs.getString(2));
			
			System.out.println("Total Product Quantity = " + rs.getLong(5));
		}
		
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Select the option: 1.Add product quantity 2.Go to menu 3.Exit");
		String option=sc.next();
		
		if(option.equals(ap))
		{
			System.out.println("---------------------------------------------------------------------------------");
			System.out.println("Enter the product id");
			int pid=sc.nextInt();
			
			System.out.println("Enter the quantity");
			int quantity=sc.nextInt();
			
			System.out.println("-----------------------------------------------------------------------------------");
		
		PreparedStatement ps1=con.prepareStatement("update product set Product_Quantity=? where Product_Id=?");
		
		ps1.setLong(1, quantity);
		ps1.setLong(2, pid);
		
		ps1.execute();
		
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("You have sucessfully add the quantity ");
		System.out.println("-------------------------------------------------------------------------------------------");
		mp.showMenu();
		
		}
		
		else if(option.equals(gtm))
		{
			System.out.println("----------------------------------------------------------------------------------");
			mp.showMenu();
		}
		
		else
		{
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.println("You have sucessfully logout");
		}
	}

}
