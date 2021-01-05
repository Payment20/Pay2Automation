package csrSearchFilterTestCases;

import org.testng.Reporter;
import org.testng.annotations.Test;
import automationPayment20.TestBase;
import generalFilterFunctionalPage.CustomerLastNameFunctionalPage;

/**
 * 
 * @author milou.rene
 *
 */

public class customerLastNameTest extends TestBase {
	// test case to search by customer last name
	@Test
	public void doSearchByCustomerLastName(){
		CustomerLastNameFunctionalPage customerLastNameFunctionalPage = new CustomerLastNameFunctionalPage();
		customerLastNameFunctionalPage.checkSearchCustomerLastNameRadioBtn();
		Reporter.log("Search by Customer Laste name Successfully Executed!!!");
	}
	
	

}
