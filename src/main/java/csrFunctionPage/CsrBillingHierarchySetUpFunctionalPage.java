package csrFunctionPage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import csrNavigationPageObjects.CsrBatchNavigationPageObj;
import csrNavigationPageObjects.CsrBillingHierarchySetUpPageObj;
import pagebase.Page;

public class CsrBillingHierarchySetUpFunctionalPage extends Page{
	
	/**
	 * instant of the page Object
	 */
	CsrBillingHierarchySetUpPageObj csrBillingHierarchySetUpPageObj = new CsrBillingHierarchySetUpPageObj();
    /**
     *  class constructor 
     */

	public CsrBillingHierarchySetUpFunctionalPage() {
		Assert.assertTrue(csrBillingHierarchySetUpPageObj.isElementPresent(csrBillingHierarchySetUpPageObj.byPageTitle()),"CSR Billing Hierarchy page title not found!!");
		
		log.debug("CsrBatchNavigationPageObj loaded");
		test.log(LogStatus.INFO, "Opening Billing Hierarchy    Page");
	}

}
