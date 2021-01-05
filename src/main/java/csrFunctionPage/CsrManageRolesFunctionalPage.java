package csrFunctionPage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import csrNavigationPageObjects.CsrUsersNavigationPageObj;
import pagebase.Page;

public class CsrManageRolesFunctionalPage extends Page{
	
	 
		/**
		 * instant of the page Object
		 */
			CsrUsersNavigationPageObj CsrUsersPageObj = new CsrUsersNavigationPageObj();
	    /**
	     *  class constructor 
	     */

		public CsrManageRolesFunctionalPage() {
			Assert.assertTrue(CsrUsersPageObj.isElementPresent(CsrUsersPageObj.byPageTitle()),"CSR Manage Role page title not found!!");
			
			log.debug("CsrScheduledPaymentsReportFunctionPage loaded");
			test.log(LogStatus.INFO, "Opening Manage Role Page");
		}


}
