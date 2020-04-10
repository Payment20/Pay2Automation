package csrFunctionPage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import csrNavigationPageObjects.CsrScheduledPaymentsReportNavigationPageObj;
import pagebase.Page;
/**
 * 
 * @author milou.rene
 *version 1.0
 */
public class CsrScheduledPaymentsReportFunctionPage extends Page{
	/**
	 * instant of the page Object
	 */
	CsrScheduledPaymentsReportNavigationPageObj CsrScheduledPaymentsReportPageObj = new CsrScheduledPaymentsReportNavigationPageObj();
    /**
     *  class constructor 
     */

	public CsrScheduledPaymentsReportFunctionPage() {
Assert.assertTrue(CsrScheduledPaymentsReportPageObj.isElementPresent(CsrScheduledPaymentsReportPageObj.byPageTitle()),"CSR Scheduled Payment report page title not found!!");
		
		log.debug("CsrScheduledPaymentsReportFunctionPage loaded");
		test.log(LogStatus.INFO, "Opening Scheduled Payment report Page");
	}
}
