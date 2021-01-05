package csrFunctionPage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import csrNavigationPageObjects.CsrGroupsPageObs;
import pagebase.Page;

public class CsrGroupsFunctionalPage extends Page{


	/**
	 * instant of the page Object
	 */
	CsrGroupsPageObs csrGroupsPageObs = new CsrGroupsPageObs();
    /**
     *  class constructor 
     */

	public CsrGroupsFunctionalPage() {
		Assert.assertTrue(csrGroupsPageObs.isElementPresent(csrGroupsPageObs.byPageTitle()),"CSR Group page title not found!!");
		
		log.debug("CsrScheduledPaymentsReportFunctionPage loaded");
		test.log(LogStatus.INFO, "Opening group   Page");
	}
}