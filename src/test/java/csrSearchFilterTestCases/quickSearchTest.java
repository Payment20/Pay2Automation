package csrSearchFilterTestCases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import automationPayment20.TestBase;
import generalFilterFunctionalPage.QuickSearchFunctionalPage;

public class quickSearchTest extends TestBase {
	
	/**
	 * 
	 * @author milou.rene
	 *
	 */
		@Test
		public void doQuickSearch() {
		 
			QuickSearchFunctionalPage quickSearchFunctionalPage = new QuickSearchFunctionalPage();
			quickSearchFunctionalPage.checkQuickSearchRadioBtn();;
			Reporter.log("Quick Search Successfully Executed!!!");
		}

}
