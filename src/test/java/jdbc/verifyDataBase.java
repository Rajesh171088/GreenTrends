package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class verifyDataBase {

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
			while (result.next()) {
				System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getString(6));
			}
			
		} finally {
			con.close();
		}
		
	}

}
