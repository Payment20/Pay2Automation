package csrFunctionPage;

import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import csrNavigationPageObjects.CsrRegisteredUsersReportNavigationPageObj;
import pagebase.Page;
/**
 * 
 * @author milou.rene
 *
 */
public class CsrRegisteredUsersReportFunctionPage extends Page{
	
	/**
	 * instant of the page Object
	 */
		CsrRegisteredUsersReportNavigationPageObj CsrRegisteredUsersReportPageObj = new CsrRegisteredUsersReportNavigationPageObj();
    /**
     *  class constructor 
     */

	public CsrRegisteredUsersReportFunctionPage() {
		Assert.assertTrue(CsrRegisteredUsersReportPageObj.isElementPresent(CsrRegisteredUsersReportPageObj.byPageTitle()),"CSR Registered User report page title not found!!");
		
		log.debug("CsrRegisteredUsersReportFunctionPage loaded");
		test.log(LogStatus.INFO, "Opening Register User report Page");
	}
}
