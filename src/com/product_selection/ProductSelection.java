package com.product_selection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductSelection {
	
	public void selectProduct() throws ClassNotFoundException, SQLException
	{
		ProductSelection p=new ProductSelection();
		
		ModificationInCart mc=new ModificationInCart();
		
		NextProcess np=new NextProcess();
		
		//static long quantity;
		Scanner sc=new Scanner(System.in);
		
		
		
	    
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product_list","root","root");
		System.out.println("Select the product with product Id");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("Enter the product Id");
		long products=sc.nextLong();
		
		System.out.println("Enter the quantity");
	    long quantity=sc.nextLong();
		
		System.out.println("-------------------------------------------------------------");
		
		PreparedStatement ps=con.prepareStatement("select * from product where Product_Id=?");
		
		ps.setLong(1, products);
		
		//ps.setInt(2, quantity);
		
		ResultSet rs=ps.executeQuery();
		
		if(rs.next())
		{
			
			int pquantity=rs.getInt(1);
			
			long productId=rs.getLong(1);
			
			if( pquantity>=quantity && pquantity!=0)
			{
			
			String productName=rs.getString(2);
			
			long productPrice=rs.getInt(4);
			
			System.out.println("Product Id = " + productId);
			
			System.out.println("Product Name = " + productName);
			
			System.out.println("Product Price = " + productPrice);
			
			System.out.println("-----------------------------------------------------------------------------");
			
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/cart","root","root");
			
			PreparedStatement ps1=con1.prepareStatement("insert into carts(Product_Id,Product_Name,Product_Price,TotalProduct_Quantity,Total_Price) value (?,?,?,?,?)");
			
			ps1.setLong(1, productId);
			
			ps1.setString(2, productName);
			
			ps1.setLong(3, productPrice);
			
			ps1.setLong(4, quantity);
			
			ps1.setLong(5, (productPrice*quantity));
			
			ps1.execute();
			
			System.out.println("-----------------------------------------------------");
			
			PreparedStatement ps2=con1.prepareStatement("select sum(TotalProduct_Quantity) from carts");
			
			ResultSet rs2=ps2.executeQuery();
			
			while(rs2.next())
			{
				System.out.println("Total product quantity = " + rs2.getString(1));
			}
			
			System.out.println("-----------------------------------------------------");
			
			PreparedStatement ps3=con1.prepareStatement("select sum(Total_Price) from carts");
			
			ResultSet rs3=ps3.executeQuery();
			
			while(rs3.next())
			{
				System.out.println("Total price = " + rs3.getString(1));
			}
			
			np.nextProcess();
			
		}
			
			else if(productId!=products || pquantity<quantity || quantity==0)
			{
				
				

					System.err.println("Out of stock or Insufficient quantity available");
					
					p.selectProduct();
				
			}
		
		}
		
		
		/*System.out.println("\n");
		System.out.println("-----------------------------------------------------");
		
		System.out.println("Select the option 1.Add product 2.Done");
		int select = sc.nextInt();

		if (select==snp) 
		{
			
			p.selectProduct();

		}
		
         else {
			
        	 System.out.println("-----------------------------------------------------");
        	 
			System.out.println("You have successfully store products in cart");
			
			 System.out.println("-----------------------------------------------------");
			
			mc.makeModification();
			
		}
	*/
		}
	

	
	}


