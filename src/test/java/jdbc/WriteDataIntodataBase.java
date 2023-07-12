package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;
import com.mysql.jdbc.Driver;

public class WriteDataIntodataBase {

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
			String query="insert into project value('GreenTrend','Rajesh','29/06/2023','BOB','ongoing',8)";
			int result = stat.executeUpdate(query);
			if (result==1) {
				System.out.println("Project is created successfully...!");
				
			}else {
				System.out.println("Project is not created..!");
			}
			
		} finally {
			con.close();
		}
		
		
		
	}

}
