package csrFunctionPage;

import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import csrNavigationPageObjects.CsrUsersNavigationPageObj;
import pagebase.Page;


public class CsrManageUsersFunctionalPage extends Page {
	
	/**
	 * instant of the page Object
	 */
		CsrUsersNavigationPageObj CsrUsersPageObj = new CsrUsersNavigationPageObj();
    /**
     *  class constructor 
     */

	public CsrManageUsersFunctionalPage() {
		Assert.assertTrue(CsrUsersPageObj.isElementPresent(CsrUsersPageObj.byPageTitle()),"CSR Manage Users page title not found!!");
		
		log.debug("CsrScheduledPaymentsReportFunctionPage loaded");
		test.log(LogStatus.INFO, "Opening Manage User Page");
	}

}
