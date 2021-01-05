package csrFunctionPage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import csrNavigationPageObjects.CsrGroupsPageObs;
import csrNavigationPageObjects.CsrProgramsPageObj;
import pagebase.Page;

public class CsrProgramsFunctionalPage extends Page{
	
	/**
	 * instant of the page Object
	 */
	CsrProgramsPageObj csrProgramsPageObj = new CsrProgramsPageObj();
    /**
     *  class constructor 
     */

	public CsrProgramsFunctionalPage() {
		Assert.assertTrue(csrProgramsPageObj.isElementPresent(csrProgramsPageObj.byPageTitle()),"CSR Programs page title not found!!");
		
		log.debug("CsrProgramsFunctionalPage loaded");
		test.log(LogStatus.INFO, "Opening Programs Page");
	}
}
