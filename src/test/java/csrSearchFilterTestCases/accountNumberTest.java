package csrSearchFilterTestCases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import automationPayment20.TestBase;
import generalFilterFunctionalPage.AccountNumberFunctionalPage;

public class accountNumberTest extends TestBase{

	/**
	 * 
	 * @author milou.rene
	 *
	 */
		@Test
		public void doAccountNumberSearch() {
		 
			AccountNumberFunctionalPage accountNumberFunctionalPage = new AccountNumberFunctionalPage();
			accountNumberFunctionalPage.checkAccountNumberRadioBtn();;
			Reporter.log("Quick Search Successfully Executed!!!");
		}
}
