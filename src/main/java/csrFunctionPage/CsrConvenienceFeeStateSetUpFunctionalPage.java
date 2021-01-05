package csrFunctionPage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import csrNavigationPageObjects.CsrConvenienceFeePageObj;
import pagebase.Page;

public class CsrConvenienceFeeStateSetUpFunctionalPage extends Page{
	
	/**
	 * instant of the page Object
	 */
	CsrConvenienceFeePageObj csrConvenienceFeePageObj = new CsrConvenienceFeePageObj();
    /**
     *  class constructor 
     */

	public CsrConvenienceFeeStateSetUpFunctionalPage() {
		Assert.assertTrue(csrConvenienceFeePageObj.isElementPresent(csrConvenienceFeePageObj.byPageTitle()),"CSR Convenient fee page set up page title not found!!");
		
		log.debug("CsrBatchNavigationPageObj loaded");
		test.log(LogStatus.INFO, "Opening Convenient fee page set up Page");
	}

}
