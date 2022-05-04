package com.Bootcamp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

public class EmployeesTbl {
	
	@Test
	public void getEmployeesData() {
		
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
			
			String querie = "SELECT * FROM employee.employees LIMIT 5";
			
			// ---Execute query---
			
			ResultSet rSet = stmnt.executeQuery(querie);
			
			  System.out.println("employee_id"+"\t"+"first_name"+"\t\t"+"last_name"+"\t\t\t"+"email"+
			  "\t\t\t\t\t"+"phone_number"+"\t\t\t"+"hire_date");
			          while(rSet.next()) {
			              System.out.println(
			                      rSet.getInt("employee_id")+ "\t\t"
			                              +rSet.getString("first_name")+ "\t\t\t"
			                              +rSet.getString("last_name")+ "\t\t\t"
			                              +rSet.getString("email")+ "\t\t\t"
			                              +rSet.getString("phone_number")+ "\t\t\t"
			                              +rSet.getDate("hire_date")
			                              

			        );

			        System.out.println("");
			    }

			
		}catch (Exception e) {
			System.out.println("\n");
			System.out.println(e);
			
		}
	}	

}
