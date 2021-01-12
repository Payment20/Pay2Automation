package csrSearchFilterTestCases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import automationPayment20.TestBase;
import generalFilterFunctionalPage.ClearFilterFunctionalPage;

/** 
 * 
 * @author milou.rene
 *
 */
public class clearFilterTest extends TestBase{

	
	//Test case to Search by search all 
		@Test
		public void doClearFilter() {
		 
			ClearFilterFunctionalPage clearFilterFunctionalPage = new ClearFilterFunctionalPage();
			clearFilterFunctionalPage.clickClearFilterRadioBtn();;
			Reporter.log("Clear Filter Successfully Executed!!!");
		}
}