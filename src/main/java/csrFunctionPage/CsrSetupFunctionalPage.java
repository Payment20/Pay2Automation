package csrFunctionPage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import csrNavigationPageObjects.CsrTransactionReportNavigationPageObj;
import pagebase.Page;

public class CsrSetupFunctionalPage extends Page{
	
	/**
	 * instant of the page Object
	 */
		CsrTransactionReportNavigationPageObj CsrTransactionReportPageObj = new CsrTransactionReportNavigationPageObj();
    /**
     *  class constructor 
     */

	public CsrSetupFunctionalPage() {
		Assert.assertTrue(CsrTransactionReportPageObj.isElementPresent(CsrTransactionReportPageObj.byPageTitle()),"CSR Transaction report page title not found!!");
		
		log.debug("CsrScheduledPaymentsReportFunctionPage loaded");
		test.log(LogStatus.INFO, "Opening Scheduled Payment report Page");
	}

}
