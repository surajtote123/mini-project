package com.product_selection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MakeChangeInQuantity {

	public void changeQuantity() throws ClassNotFoundException, SQLException {

		String rpc = "1";
		String ipq = "2";
		String dpq = "3";

		ModificationInCart mc = new ModificationInCart();

		NextProcess np = new NextProcess();

		Scanner sc = new Scanner(System.in);

		System.out.println("-------------------------------------------------------------------------------");

		System.out.println(
				"Select option: 1.Remove the product from cart  2.Increse product quantity  3.decrease product quantity  4.Next Process");
		String option = sc.nextLine();

		Class.forName("com.mysql.cj.jdbc.Driver");

		//Connection co1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_list", "root", "root");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cart", "root", "root");

		if (option.equals(rpc)) {

			System.out.println("-----------------------------------------------------------------------------");
			System.out.println("Enter the product Id");
			long pId = sc.nextLong();

			PreparedStatement ps = con.prepareStatement("delete from carts where Product_Id=?");

			ps.setLong(1, pId);

			ps.execute();

			PreparedStatement ps1 = con.prepareStatement("select * from carts");

			ResultSet rs = ps.executeQuery();

			System.out.println(
					"--------------------------------------------------------------------------------------------------------------------------------------");

			System.out.println("Product Id" + "   " + "Product Name" + "        " + "Total Product Quantity" + "   "
					+ "Total Price");

			System.out.println("\n");

			while (rs.next()) {
				System.out.println(
						rs.getLong(1) + "   " + rs.getString(2) + "    " + rs.getLong(4) + "    " + rs.getLong(5));
			}

			System.out
					.println("--------------------------------------------------------------------------------------");

			PreparedStatement ps2 = con.prepareStatement("select sum(TotalProduct_Quantity) from carts");

			ResultSet rs1 = ps2.executeQuery();

			while (rs1.next()) {
				System.out.println("Total quantity of product = " + rs1.getLong(1));
			}

			System.out.println("-------------------------------------------------------------------------------------");

			PreparedStatement ps3 = con.prepareStatement("select sum(Total_Price) from carts");

			ResultSet rs2 = ps3.executeQuery();

			while (rs2.next()) {
				System.out.println("Total Price = " + rs2.getLong(1));
			}

			np.nextProcess();
		}

		else if (option.equals(ipq)) {

			System.out.println("Enter the Product Id");
			int pd = sc.nextInt();

			PreparedStatement ps4 = con.prepareStatement("select * from carts");

			ResultSet rs3 = ps4.executeQuery();

			while (rs3.next()) {

				long prq = rs3.getLong(4);
				long pp = rs3.getLong(3);

				PreparedStatement ps5 = con.prepareStatement("update carts set TotalProduct_Quantity=?  where Product_Id=?");

				//PreparedStatement ps15 = con.prepareStatement("update carts set Total_Price=?  where Product_Id=?");

				ps5.setLong(1, (prq+1));
				
				ps5.setLong(1, prq);

				ps5.setLong(2, pd);

				/*ps15.setLong(1, (pp * prq));

				ps15.setLong(2, pd);*/

				ps5.execute();
				//ps15.execute();
				
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_list", "root","root");

				PreparedStatement ps40 = con1.prepareStatement("select * from product where Product_Id=?");

				ps40.setInt(1, pd);

				ResultSet rs30 = ps40.executeQuery();


				while (rs30.next()) {

					long prq1=rs30.getLong(4); 
					
					PreparedStatement ps41 = con.prepareStatement("select * from carts where Product_Id=?");
					
					ps41.setInt(1, pd);
					
					ResultSet rs31=ps41.executeQuery();
					
					while(rs31.next())
					{
						
						
					long tp1 = rs31.getLong(4);
					PreparedStatement ps16 = con.prepareStatement("update carts set Total_Price=? where Product_Id=?");

					ps16.setLong(1, (prq1 * tp1));

					ps16.setInt(2, pd);

					ps16.execute();
				}
				}
			}

			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------");

			PreparedStatement ps24 = con.prepareStatement("select * from carts");

			ResultSet rs23 = ps4.executeQuery();

			System.out.println("Product Id" + "   " + "Product Name" + "        " + "Total Product Quantity" + "   "+ "Total Price");

			System.out.println("\n");

			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------");

			while (rs23.next()) {

				System.out.println(rs23.getLong(1) + "             " + rs23.getString(2) + "        "+ rs23.getLong(4) + "         " + rs23.getLong(5));

			}

			System.out.println(
					"----------------------------------------------------------------------------------------");

			PreparedStatement ps2 = con.prepareStatement("select sum(TotalProduct_Quantity) from carts");

			ResultSet rs1 = ps2.executeQuery();

			while (rs1.next()) {
				System.out.println("Total quantity of product = " + rs1.getLong(1));
			}

			System.out.println(
					"-------------------------------------------------------------------------------------------------");

			PreparedStatement ps3 = con.prepareStatement("select sum(Total_Price) from carts");

			ResultSet rs2 = ps3.executeQuery();

			while (rs2.next()) {
				System.out.println("Total Price = " + rs2.getLong(1));
			}

			np.nextProcess();
		}

		else if (option.equals(dpq)) {

			System.out.println("Enter the Product Id");
			int pd = sc.nextInt();

			PreparedStatement ps4 = con.prepareStatement("select * from carts");

			ResultSet rs3 = ps4.executeQuery();

			while (rs3.next()) {

				long tp = rs3.getLong(3);
				long prq = rs3.getLong(4);

				PreparedStatement ps5 = con.prepareStatement("update carts set TotalProduct_Quantity=? where Product_Id=?");

				
				ps5.setLong(1, (prq-1));
				
				ps5.setLong(1, prq);

				ps5.setInt(2, pd);

				ps5.execute();

				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_list", "root","root");

				PreparedStatement ps40 = con1.prepareStatement("select * from product where Product_Id=?");

				ps40.setInt(1, pd);

				ResultSet rs30 = ps40.executeQuery();


				while (rs30.next()) {

					long prq1=rs30.getLong(4); 
					
					PreparedStatement ps41 = con.prepareStatement("select * from carts where Product_Id=?");
					
					ps41.setInt(1, pd);
					
					ResultSet rs31=ps41.executeQuery();
					
					while(rs31.next())
					{
						
						
					long tp1 = rs31.getLong(4);
					PreparedStatement ps16 = con.prepareStatement("update carts set Total_Price=? where Product_Id=?");

					ps16.setLong(1, (prq1 * tp1));

					ps16.setInt(2, pd);

					ps16.execute();
				}
				}
			}
			System.out.println(
					"---------------------------------------------------------------------------------------------------------");

			PreparedStatement ps14 = con.prepareStatement("select * from carts");

			ResultSet rs13 = ps14.executeQuery();

			System.out.println("Product Id" + "   " + "Product Name" + "        " + "Total Product Quantity" + "   "+ "Total Price");

			System.out.println("\n");

			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------");
			while (rs13.next()) {
				System.out.println(rs13.getLong(1) + "              " + rs13.getString(2) + "       "+ rs13.getLong(4) + "         " + rs13.getLong(5));
			}

			System.out.println(
					"-----------------------------------------------------------------------------------------------------------------------");

			PreparedStatement ps2 = con.prepareStatement("select sum(TotalProduct_Quantity) from carts");

			ResultSet rs1 = ps2.executeQuery();

			while (rs1.next()) {
				System.out.println("Total quantity of product = " + rs1.getLong(1));
			}

			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------");

			PreparedStatement ps3 = con.prepareStatement("select sum(Total_Price) from carts");

			ResultSet rs2 = ps3.executeQuery();

			while (rs2.next()) {
				System.out.println("Total Price = " + rs2.getLong(1));
			}

			System.out.println(
					"------------------------------------------------------------------------------------------------------------------");

			np.nextProcess();
		}

		else {
			mc.makeModification();
		}
	}

}
