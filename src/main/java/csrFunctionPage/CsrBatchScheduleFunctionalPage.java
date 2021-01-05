package csrFunctionPage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import csrNavigationPageObjects.CsrBatchNavigationPageObj;
import pagebase.Page;

public class CsrBatchScheduleFunctionalPage extends Page{
	

	/**
	 * instant of the page Object
	 */
	CsrBatchNavigationPageObj csrBatchNavigationPageObj = new CsrBatchNavigationPageObj();
    /**
     *  class constructor 
     */

	public CsrBatchScheduleFunctionalPage() {
		Assert.assertTrue(csrBatchNavigationPageObj.isElementPresent(csrBatchNavigationPageObj.byPageTitle()),"CSR Batch Navigation page title not found!!");
		
		log.debug("CsrBatchNavigationPageObj loaded");
		test.log(LogStatus.INFO, "Opening Batch navigation    Page");
	}

}
