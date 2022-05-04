package com.Bootcamp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

public class LocationsTab {
	@Test
	public void getLocations() {
	
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		   System.out.println("Driver Loaded\n");
		   
		   //---Set connection to the database---
		   
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sarvin","root","Oriental68");
		System.out.println("Connected to mySQL\n");


		//--Create Statement--

		Statement stmnt = con.createStatement();
		System.out.println("inserting records\n");
	
	    //---Query---
		
		String querie = "SELECT * FROM employee.locations LIMIT 5";
		
		// ---Execute query---
		
		ResultSet rSet = stmnt.executeQuery(querie);
		
		  System.out.println("location_id"+"\t"+"street_address"+"\t\t"+"postal_code"+"\t\t\t"+"city"+
		  "\t\t\t"+"state_province"+"\t\t\t"+"country_id");
		          while(rSet.next()) {
		              System.out.println(
		                      rSet.getInt("location_id")+ "\t\t"
		                              +rSet.getString("street_address")+ "\t\t\t"
		                              +rSet.getString("postal_code")+ "\t\t\t"
		                              +rSet.getString("city")+ "\t\t\t"
		                              +rSet.getString("state_province")+ "\t\t\t"
		                              +rSet.getString("country_id")
		                              

		        );

		        System.out.println("");
		    }

		
	}catch (Exception e) 
	{
		System.out.println("\n");
		System.out.println(e);
		
	}

}

}

