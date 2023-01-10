package com.product_selection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.registration.DoRegistrationFirst;

public class ProductList {

	public void getProductList() throws ClassNotFoundException, SQLException {

		ProductSelection pn=new ProductSelection();

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_list", "root", "root");

		PreparedStatement ps = con.prepareStatement("select * from product order by Product_Name");

		ResultSet rs = ps.executeQuery();
		
		System.out.println("---------------------------------------------------------------------------------");

		System.out.println("Product details are:");
		
		System.out.println("--------------------------------------------------------------------------------");
		
		/*System.out.print( "Product Id \t\t\t\t");
		
		System.out.print("Product Name \t\t\t\t" );
		
		System.out.print("Product Description\t\t\t\t " );
		
		System.out.print("Product Price\t\t\t\t " );
		
		System.out.print("Product Quantity " );
		*/
		
		
		while (rs.next()) {

			/*System.out.println("\n");
			System.out.print("Product Id\t\t\t\t " );
			
			System.out.print("Product Name\t\t\t\t " );
			
			System.out.print("Product Description\t\t\t\t " );
			
			System.out.print("Product Price\t\t\t\t " );
			
			System.out.print("Product Quantity " );
			
			*/
			System.out.println("---------------------------------------------------------------------------------------------------");
			
			System.out.println("Product Id " + rs.getLong(1));
			
			System.out.println("Product Name " + rs.getString(2));
			
			System.out.println("Product Description " + rs.getString(3));
			
			System.out.println("Product Price " + rs.getLong(4));
			
			System.out.println("Product Quantity " + rs.getLong(5));
			
			System.out.println("\n");
			

		}
		System.out.println("--------------------------------------------------------------------------------");
		pn.selectProduct();
	}

	
	
	}
	
	


