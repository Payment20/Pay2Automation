package csrFunctionPage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import csrNavigationPageObjects.CsrSupportNavigationPageObj;
import pagebase.Page;

public class CsrClientDetailsFunctionalPage extends Page{
	
	/**
	 * instant of the page Object
	 */
		 
		CsrSupportNavigationPageObj CsrSupportPageObj = new CsrSupportNavigationPageObj();
    /**
     *  class constructor 
     */

	public CsrClientDetailsFunctionalPage() {
		Assert.assertTrue(CsrSupportPageObj.isElementPresent(CsrSupportPageObj.byPageTitle()),"CSR Support page title not found!!");
		
		log.debug("CsrSupportFunctionalPage  loaded");
		test.log(LogStatus.INFO, "Opening Support Page");
	}

}
