package com.product_selection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.registration.SelectRegistrationType;

public class ModificationInCart {

	public void makeModification() throws ClassNotFoundException, SQLException {

		ProductSelection pl = new ProductSelection();
		ModificationInCart mc = new ModificationInCart();

		Scanner sc = new Scanner(System.in);

		String bp = "1";
		String ea = "2";

		System.out.println("Select option: 1.Buy the products 2.Exit tha app");
		String custOption = sc.nextLine();

		if (custOption.equals(bp)) {

			System.out.println("Enter your name to buy the product");
			String name = sc.nextLine();


			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cart", "root", "root");
			
			System.out.println("WARDHA RELIANCE DIGITAL");

			System.out.println("Receipt");
			
			System.out.println("------------------------------------------------------------------------------");

			
			System.out.println("Name = " + name);

			System.out.println("\n");

			System.out.println("Product Id " + "      " + " Product Name " + "      " + " Product Price " +"      "+" TotalProduct_Quantity " + "      " + " Total_Price");
			
			System.out.println("-----------------------------------------------------------------------------");

			PreparedStatement ps = con.prepareStatement("select * from carts");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				long product_Id = rs.getLong(1);

				String product_Name = rs.getString(2);

				long product_Price = rs.getLong(3);
				
				long total_quantity=rs.getLong(4);
				
				long total_price=rs.getLong(5);

				System.out.println(rs.getInt(1) + "             " + rs.getString(2) + "                " + rs.getLong(3)+"                     " + rs.getLong(4)+"                         "+rs.getLong(5));
				
				System.out.println("------------------------------------------------------------------------");

				/*PreparedStatement ps10 = con.prepareStatement("select count(Product_Name) from carts ");

				ResultSet rs1 = ps10.executeQuery();*/

				/*while (rs1.next()) {
					
				System.out.println("Total Price of all product = " + rs1.getLong(1) );
				
				
				PreparedStatement ps11=con.prepareStatement("select sum(Product_Price) from carts");
				
				ResultSet rs2=ps11.executeQuery();
				
				while(rs2.next())
				{
				System.out.println("Total Price of all product = " + rs2.getLong(1) );
				*/
				//System.out.println(rs.getInt(1) + "         " + rs.getString(2) + "         " + rs.getString(3) + "        " + rs1.getString(1) + "       " + rs2.getLong(1));

				Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_history", "root",
						"root");

				PreparedStatement ps1 = con1.prepareStatement(
						"insert into history(Customer_Name,Product_Id,Product_Name,Product_Price,TotalProduct_Quantity,Total_Price) values(?,?,?,?,?,?)");

				ps1.setString(1, name);
				ps1.setLong(2, product_Id);
				ps1.setString(3, product_Name);
				ps1.setLong(4, product_Price);
				ps1.setLong(5, total_quantity);
				ps1.setLong(6, total_price);
				
				

				ps1.execute();
				
				Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306/product_list","root","root");
				
				PreparedStatement pp=co.prepareStatement("select Product_Quantity from product");
				
				ResultSet rt=pp.executeQuery();
				
				while(rt.next())
				{
					
					long pq=(rt.getLong(1)-total_quantity);
				
				PreparedStatement pt=co.prepareStatement("update product set Product_Quantity=? where Product_Id=?");
				
				pt.setLong(1, pq);
				pt.setLong(2, product_Id);
				
				pt.execute();
				
				/*ResultSet re=pt.executeQuery();
				
				while(re.next())
				{
					int stock=re.getIn
				}*/

				/*PreparedStatement ps2 = con.prepareStatement("delete from carts");

				ps2.execute();
				
				System.out.println("Thanku You");*/
				
				}

			}
		}
		
		System.out.println("-------------------------------------------------------------------");
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cart", "root", "root");

				PreparedStatement ps10 = con.prepareStatement("select sum(TotalProduct_Quantity) from carts ");

				ResultSet rs1 = ps10.executeQuery();

				while (rs1.next()) {
					
				System.out.println("Total quantity of all product = " + rs1.getLong(1) );
				
				System.out.println("---------------------------------------------------------------");
				
				PreparedStatement ps11=con.prepareStatement("select sum(Total_Price) from carts");
				
				ResultSet rs2=ps11.executeQuery();
				
				while(rs2.next())
				{
				System.out.println("Total Price of all product = " + rs2.getLong(1) );
				
				
				PreparedStatement ps2 = con.prepareStatement("delete from carts");

				ps2.execute();
				
				System.out.println("------------------------------------------------------------------");
				
				System.out.println("Thanku You");
				
				
			}
				
				
		
			
		
	if(custOption.equals(ea))
		{

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/cart", "root", "root");

			PreparedStatement ps2 = con1.prepareStatement("delete from carts");

			ps2.execute();
			
			System.out.println("-------------------------------------------------------------------------------");

			System.out.println("Thank You");
		}
				}

	}

	

}
