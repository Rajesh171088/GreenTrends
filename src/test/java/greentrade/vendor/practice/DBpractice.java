package greentrade.vendor.practice;

import java.sql.SQLException;

import com.greentreand.genericutility.DataBaseUtility;

public class DBpractice {

	public static void main(String[] args) throws SQLException {
		
		DataBaseUtility db=new DataBaseUtility();
		db.connectDB();
		System.out.println("Connection established");
		db.closeDB();
	}

}
