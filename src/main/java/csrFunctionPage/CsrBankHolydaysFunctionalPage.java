package csrFunctionPage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import csrNavigationPageObjects.CsrBankHolidaysPageObj;
import pagebase.Page;

public class CsrBankHolydaysFunctionalPage extends Page{

	
	/**
	 * instant of the page Object
	 */
	CsrBankHolidaysPageObj csrBankHolidaysPageObj = new CsrBankHolidaysPageObj();
    /**
     *  class constructor 
     */

	public CsrBankHolydaysFunctionalPage() {
		Assert.assertTrue(csrBankHolidaysPageObj.isElementPresent(csrBankHolidaysPageObj.byPageTitle()),"CSR Bank Holiday page title not found!!");
		
		log.debug("CsrScheduledPaymentsReportFunctionPage loaded");
		test.log(LogStatus.INFO, "Opening Bank Holiday   Page");
	}
}
