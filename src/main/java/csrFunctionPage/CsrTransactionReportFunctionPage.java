package csrFunctionPage;

import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import csrNavigationPageObjects.CsrTransactionReportNavigationPageObj;
import pagebase.Page;
/**
 * 
 * @author milou.rene
 *version 1.0
 */
public class CsrTransactionReportFunctionPage extends Page{
	/**
	 * instant of the page Object
	 */
		CsrTransactionReportNavigationPageObj CsrTransactionReportPageObj = new CsrTransactionReportNavigationPageObj();
    /**
     *  class constructor 
     */

	public CsrTransactionReportFunctionPage() {
		Assert.assertTrue(CsrTransactionReportPageObj.isElementPresent(CsrTransactionReportPageObj.byPageTitle()),"CSR Transaction report page title not found!!");
		
		log.debug("CsrScheduledPaymentsReportFunctionPage loaded");
		test.log(LogStatus.INFO, "Opening Scheduled Payment report Page");
	}
}
