package csrSearchFilterTestCases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import automationPayment20.TestBase;
import generalFilterFunctionalPage.AddCustomerFunctionalPage;

/**
 * 
 * @author milou.rene
 *
 */
public class addCustomerTest extends TestBase{
	
	//Test case to Search by search all 
		@Test
		public void doAddCustomer() {
		 
			AddCustomerFunctionalPage addCustomerFunctionalPage = new AddCustomerFunctionalPage();
			addCustomerFunctionalPage.clickAddCustomerRadioBtn();;
			Reporter.log("Add Customer Successfully Executed!!!");
		}

}
