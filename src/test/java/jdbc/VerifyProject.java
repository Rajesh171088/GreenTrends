package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;



public class VerifyProject {
	
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
			Driver driverref=new Driver();
			//to register the database
			DriverManager.registerDriver(driverref);
			//to connect to db
			con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			System.out.println("Connection is done");
			Statement stat = con.createStatement();
			String query="select * from project";
			ResultSet result = stat.executeQuery(query);
			int count=0;
			while (result.next()) {
				String pro = result.getString(1);				
				if(pro.equalsIgnoreCase("Green Trend"))
				{
					System.out.println("The project is present "+pro);
					count++;
					break;
				}
			}
			if (count==0) {
				System.out.println("The project is not present");
			}
		}
		finally {
				con.close();
		}
	} 
}
