package csrSearchFilterTestCases;

import org.testng.Reporter;
import org.testng.annotations.Test;
import automationPayment20.TestBase;
import generalFilterFunctionalPage.SearchAllFunctionalPage;

/**
 * 
 * @author milou.rene
 *
 */

public class searchAllTest extends TestBase{
	//Test case to Search All function 
	@Test
	public void doSearchAll() {
	 
		SearchAllFunctionalPage searchAllFunctionalPage = new SearchAllFunctionalPage();
		searchAllFunctionalPage.checkSearchAllRadioBtn();
		Reporter.log("Login To QA CSR Portal Successfully Executed!!!");
	}
}
