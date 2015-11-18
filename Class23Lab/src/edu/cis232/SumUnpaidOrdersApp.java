package edu.cis232;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class SumUnpaidOrdersApp {

	public static void main(String[] args) throws SQLException{
		final String DB_URL = "jdbc:derby:CoffeeDB;create=true";
		
		Connection conn = DriverManager.getConnection(DB_URL);
		
		Statement stmt = conn.createStatement();
		
		ResultSet results = stmt.executeQuery("select sum(cost) as totalCost from UnpaidOrder");
		
		while(results.next()){
			System.out.printf("Unpaid orders total: $%,.2f%n", results.getDouble("totalCost"));
		}
		conn.close();
	}

}
