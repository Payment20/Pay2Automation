package csrFunctionPage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import csrNavigationPageObjects.CsrAutoPaymentManagersReportNavigationPageObj;
import pagebase.Page;
/**
 * 
 * @author milou.rene
 *version 1.0
 */
public class CsrAutoPaymentManagersReportFunctionPage extends Page{
	/**
	 * instant of the page Object
	 */
	CsrAutoPaymentManagersReportNavigationPageObj AutoPaymentManagerReportPageObj = new CsrAutoPaymentManagersReportNavigationPageObj();
    /**
     * CsrActivitiesReportNavigationPageObj class constructor 
     */

	public CsrAutoPaymentManagersReportFunctionPage() {
Assert.assertTrue(AutoPaymentManagerReportPageObj.isElementPresent(AutoPaymentManagerReportPageObj.byPageTitle()),"CSR Auto Payment Manager   report page title not found!!");
		
		log.debug("AutoPaymentManagerReportPageObj loaded");
		test.log(LogStatus.INFO, "Opening Auto Payment Manager Report   Page");
	}


}
