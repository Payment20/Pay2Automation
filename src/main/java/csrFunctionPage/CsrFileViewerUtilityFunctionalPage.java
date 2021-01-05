package csrFunctionPage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import csrNavigationPageObjects.CsrFileViewerUtilityPageObj;
import pagebase.Page;

public class CsrFileViewerUtilityFunctionalPage extends Page{
	
	
	/**
	 * instant of the page Object
	 */
	CsrFileViewerUtilityPageObj csrFileViewerUtilityPageObj = new CsrFileViewerUtilityPageObj();
    /**
     *  class constructor 
     */

	public CsrFileViewerUtilityFunctionalPage() {
		Assert.assertTrue(csrFileViewerUtilityPageObj.isElementPresent(csrFileViewerUtilityPageObj.byPageTitle()),"CSR File viewer report page title not found!!");
		
		log.debug("csrFileViewerUtilityPageObj loaded");
		test.log(LogStatus.INFO, "Opening file viewer report Page");
	}

}
