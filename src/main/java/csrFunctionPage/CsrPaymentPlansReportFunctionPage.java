package csrFunctionPage;

import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import csrNavigationPageObjects.CsrPaymentPlansReportNavigationPageObj;
import pagebase.Page;
/**
 * 
 * @author milou.rene
 *version 1.0
 */
public class CsrPaymentPlansReportFunctionPage extends Page {
	
	/**
	 * instant of the page Object
	 */
	CsrPaymentPlansReportNavigationPageObj CsrPaymentPlansReportPageObj = new CsrPaymentPlansReportNavigationPageObj();
    /**
     * class constructor 
     */

	public CsrPaymentPlansReportFunctionPage() {
Assert.assertTrue(CsrPaymentPlansReportPageObj.isElementPresent(CsrPaymentPlansReportPageObj.byPageTitle()),"CSR Payment Plan report page title not found!!");
		
		log.debug("CsrPaymentPlansReportPageObj loaded");
		test.log(LogStatus.INFO, "Opening Payment Plan report Page");
	}
}
