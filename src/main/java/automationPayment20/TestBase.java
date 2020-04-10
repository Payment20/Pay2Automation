package automationPayment20;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import pagebase.Page;

public class TestBase extends Page{
	/**
	* Test Method.
	* <p> To execute after run a suite and close the browser and close the database connection </p>                        
	* @author Yary.Perez
	 */
	@AfterSuite
	public void tearDown() throws SQLException{
		
		
		Page.quit();
		Page.restoreCfeeCredentials();
		Page.closeDBConnection();
		
	}
	
	/**
	* Test Method.
	* <p> To execute before run a suite and close the database connection  </p>                        
	* @author Yary.Perez
	 */
	@BeforeSuite
	public void buildUp() throws SQLException{

		Page.openDBConnection();
	
	}
}
