package com.product_selection;

import java.sql.SQLException;
import java.util.Scanner;

public class NextProcess {
	
	public void nextProcess() throws ClassNotFoundException, SQLException
	{
		int snp=1;
		int d=2;
		
		ProductSelection p=new ProductSelection();
		
		MakeChangeInQuantity mcq=new MakeChangeInQuantity();
		
		ModificationInCart mc=new ModificationInCart();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("\n");
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
			
			mcq.changeQuantity();
			
		}
	
	}

}
