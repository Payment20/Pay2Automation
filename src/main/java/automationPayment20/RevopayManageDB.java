package automationPayment20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import pagebase.Page;


/**
 * @author Yary Perez <yfraga@revopay.com>
 * @version 1.2.0
 */
public class RevopayManageDB {

	static int rport = 3306;
	static String dbuserName = "testRevo2018";
	static String dbpassword = "test#Revo!2018";
	static String url = "jdbc:mysql://testdb.cv6exk3land5.us-west-2.rds.amazonaws.com/revopay_manage";
	static String driverName = "com.mysql.cj.jdbc.Driver";
	static Connection conn = null;
	Statement statement = null;

	public Connection getConnection() {

		return conn;
	}

	public void openConnection() throws SQLException {

		try {

			Class.forName(driverName).newInstance();
			conn = DriverManager.getConnection(url, dbuserName, dbpassword);
		//	System.out.println ("Database connection established " + conn);
			Page.log.debug("Database connection established");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println ("Error Database connection established");
		}
	}

	public void closeConnection() throws SQLException {

		conn.close();
		// System.out.println("Closing Database Connection");
		Page.log.debug("Closing Database Connection");
	}

	public Statement getStatement() throws SQLException {
	//	System.out.println("creating stattement " + conn.createStatement());
		return statement = conn.createStatement();

	}

	// To print the query results
	/*
	 * while (resultSet.next()){
	 * 
	 * System.out.println(resultSet.getString(1)); }
	 */

}
