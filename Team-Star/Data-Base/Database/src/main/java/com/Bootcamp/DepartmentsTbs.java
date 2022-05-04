package com.Bootcamp;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;

	import org.testng.annotations.Test;

	public class DepartmentsTbs { 
		@Test
		public void getCountriesData() {
			
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				   System.out.println("Driver Loaded\n");
				   
				   //Set connection to the database
				   
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sarvin","root","Oriental68");
				System.out.println("Connected to mySQL\n");


				//--Create Statement

				Statement stmnt = con.createStatement();
				System.out.println("inserting records\n");
			
			    //---Query---
				
				String querie = "SELECT * FROM employee.departments limit 5";

				
				// --Execute query--
				ResultSet rSet = stmnt.executeQuery(querie);
				
				System.out.println("department_id"+"\t"+"department_name"+"\t\t"+"location_id");
		        while(rSet.next()) {
		            System.out.println(
		                    rSet.getInt("department_id")+ "\t\t"
		                            +rSet.getString("department_name")+ "\t\t"
		                            +rSet.getInt("location_id")

				        );

				        System.out.println("");
				    }

				
			}catch (Exception e) {
				System.out.println(e);
			}
			

}
}