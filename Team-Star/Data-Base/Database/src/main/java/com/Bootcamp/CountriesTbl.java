package com.Bootcamp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

public class CountriesTbl {
	@Test
	public void getCountriesData() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			   System.out.println("Driver Loaded\n");
			   
			   //--Set connection to the database--
			   
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sarvin","root","Oriental68");
			System.out.println("Connected to mySQL");


			//--Create Statement--

			Statement stmnt = con.createStatement();
			System.out.println("inserting records");
		
		    //--Query--
			
			String querie = "SELECT * FROM employee.countries LIMIT 5";
		
			
			// --Execute query--
			
			ResultSet rSet = stmnt.executeQuery(querie);
			
			 System.out.println("country_id"+"\t\t"+"country_name"+"\t"+" region_id");
			    while(rSet.next()) {
			        System.out.println(
			               rSet.getString("country_id")+"\t\t\t"
			               +rSet.getString("country_name")+"\t\t"
			                +rSet.getInt("region_id")
			        );

			        System.out.println("");
			    }

			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
