package dedalus.dbconnection;

import java.sql.*;
import java.sql.SQLException;

public class TryDBConnection {

	public static Connection con;

	public static Connection getDBConnection() {

	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "sys as sysdba", "");
	}
	catch (SQLException sqlex) {
		sqlex.printStackTrace();
		}
	catch (ClassNotFoundException nfex) {
		nfex.printStackTrace();
		}
	return con;
	}
	
//	public static void main(String[] args) {
		//System.out.println(getDBConnection());
//	}
}
