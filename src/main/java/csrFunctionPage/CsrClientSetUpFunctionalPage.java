package csrFunctionPage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import csrNavigationPageObjects.CsrClientSetUpNavigationPageObj;
import pagebase.Page;

public class CsrClientSetUpFunctionalPage extends Page {
	
	 
	/**
	 * instant of the page Object
	 */
	CsrClientSetUpNavigationPageObj csrClientSetUpNavigationPageObj = new CsrClientSetUpNavigationPageObj();
    /**
     *  class constructor 
     */

	public CsrClientSetUpFunctionalPage() {
		Assert.assertTrue(csrClientSetUpNavigationPageObj.isElementPresent(csrClientSetUpNavigationPageObj.byPageTitle()),"CSR Client Set Up page title not found!!");
		
		log.debug("CsrClientSetUpNavigationPageObj loaded");
		test.log(LogStatus.INFO, "Opening Client Set Up Page");
	}

}
