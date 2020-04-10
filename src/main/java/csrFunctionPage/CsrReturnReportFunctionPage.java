package csrFunctionPage;

import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import csrNavigationPageObjects.CsrReturnReportNavigationPageObj;
import pagebase.Page;
/**
 * 
 * @author milou.rene
 *version 1.0
 */
public class CsrReturnReportFunctionPage extends Page{
	/**
	 * instant of the page Object
	 */
	CsrReturnReportNavigationPageObj CsrReturnReportPageObj = new CsrReturnReportNavigationPageObj();
    /**
     *  class constructor 
     */

	public CsrReturnReportFunctionPage() {
Assert.assertTrue(CsrReturnReportPageObj.isElementPresent(CsrReturnReportPageObj.byPageTitle()),"CSR Return report page title not found!!");
		
		log.debug("CsrReturnReportPageObj loaded");
		test.log(LogStatus.INFO, "Opening Return report Page");
	}
}
