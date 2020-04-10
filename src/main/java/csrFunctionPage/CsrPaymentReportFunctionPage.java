package csrFunctionPage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import csrNavigationPageObjects.CsrPaymentReportNavigationPageObj;
import pagebase.Page;
/**
 * 
 * @author milou.rene
 *version 1.0
 */
public class CsrPaymentReportFunctionPage extends Page{
 
	/**
	 * instant of the page Object
	 */
	CsrPaymentReportNavigationPageObj CsrPaymentReportPageObj = new CsrPaymentReportNavigationPageObj();
    /**
     *  class constructor 
     */

	public CsrPaymentReportFunctionPage() {
Assert.assertTrue(CsrPaymentReportPageObj.isElementPresent(CsrPaymentReportPageObj.byPageTitle()),"CSR Payment report page title not found!!");
		
		log.debug("CsrPaymentReportPageObj loaded");
		test.log(LogStatus.INFO, "Opening Payment report Page");
	}
}
