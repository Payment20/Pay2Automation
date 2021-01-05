package csrFunctionPage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import csrNavigationPageObjects.CsrOSGGatewayPageObj;
import pagebase.Page;

public class CsrOSGGatewaySetUpFunctionalPage extends Page{

	
	
	/**
	 * instant of the page Object
	 */
	CsrOSGGatewayPageObj csrOSGGatewayPageObj = new CsrOSGGatewayPageObj();
    /**
     *  class constructor 
     */

	public CsrOSGGatewaySetUpFunctionalPage() {
		Assert.assertTrue(csrOSGGatewayPageObj.isElementPresent(csrOSGGatewayPageObj.byPageTitle()),"CSR OSG Gateway page title not found!!");
		
		log.debug("CsrScheduledPaymentsReportFunctionPage loaded");
		test.log(LogStatus.INFO, "Opening OSG Gateway   Page");
	}
}
