package csrFunctionPage;

import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import csrNavigationPageObjects.CsrBatchNavigationPageObj;
import pagebase.Page;
/**
 * 
 * @author milou.rene
 *version 1.0
 */
public class CsrBatchReportFunctionPage extends Page{
	
	/**
	 * instant of the page Object
	 */
	CsrBatchNavigationPageObj csrBatchReportPageObj =  new CsrBatchNavigationPageObj();
    /**
     *  class constructor 
     */

	public CsrBatchReportFunctionPage() {
Assert.assertTrue(csrBatchReportPageObj.isElementPresent(csrBatchReportPageObj.byPageTitle()),"CSR Batch report page title not found!!");
		
		log.debug("CsrBatchReportFunctionPage loaded");
		test.log(LogStatus.INFO, "Opening Batch report Page");
	}
}
