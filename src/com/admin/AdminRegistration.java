package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminRegistration {
	
	public void admintrgister() throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter your name");
		String aname=sc.nextLine();
		
		System.out.println("Enter mobile number");
		String anum=sc.nextLine();
		
		System.out.println("Enter user name");
		String auname=sc.nextLine();
		
		System.out.println("Set the password");
		String apass=sc.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin_registration","root","root");
		
		PreparedStatement ps=con.prepareStatement("insert into admin_info(Admin_Name,Admin_Number,Admin_UserName,Admin_Password) value (?,?,?,?)");
		
		ps.setString(1, aname);
		ps.setString(2, anum);
		ps.setString(3, auname);
		ps.setString(4, apass);
		
		ps.execute();
	}
	
	

}
