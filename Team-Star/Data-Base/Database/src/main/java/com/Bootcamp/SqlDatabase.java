package com.Bootcamp;
import java.sql.*;

public class SqlDatabase {
	public static void main(String[] args) {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sarvin","root","Oriental68");
			Statement stmnt = con.createStatement();
			System.out.println("inserting records");
		
		
			String querie = "SELECT * FROM sarvin.employeedatasql";
			//stmnt.executeUpdate(querie);
			// Execute query
			ResultSet rSet = stmnt.executeQuery(querie);
			System.out.println("Employee_ID "+ "\t"+ "First Name "+ "\t"+ "Last Name" + "\t"+ "Department_ID"+ 
			"\t"+ "Depertment_Name"+"\t"+ "Yearly_Salary"+ "\t"+ "Yearly_Bonus_10%");
			
			//Console output
			while (rSet.next()) {
				System.out.println(rSet.getString("Employee_ID") + "\t\t"+ 
						rSet.getString("Employee_ID") + "\t\t"+
						rSet.getString("First Name") + "\t\t"+
						rSet.getString("Last Name") + "\t\t"+
						rSet.getString("Department_ID") + "\t\t"+ 
						rSet.getString("Department_Name") + "\t\t"+
						rSet.getString("Yearly_Salary") + "\t\t"+
						rSet.getString("Yearly_Bonus_10%") );
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
