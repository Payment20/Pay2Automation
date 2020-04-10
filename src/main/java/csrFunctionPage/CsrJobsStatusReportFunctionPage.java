package csrFunctionPage;

import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import csrNavigationPageObjects.CsrJobsStatusReportNavigationPageObj;
import pagebase.Page;
/**
 * 
 * @author milou.rene
 *version 1.0
 */
public class CsrJobsStatusReportFunctionPage extends Page{
	
	/**
	 * instant of the page Object
	 */
	CsrJobsStatusReportNavigationPageObj CsrJobsStatusReportPageObj = new CsrJobsStatusReportNavigationPageObj();
    /**
     * CsrActivitiesReportNavigationPageObj class constructor 
     */

	public CsrJobsStatusReportFunctionPage() {
Assert.assertTrue(CsrJobsStatusReportPageObj.isElementPresent(CsrJobsStatusReportPageObj.byPageTitle()),"CSR Job Status report page title not found!!");
		
		log.debug("CsrJobsStatusReportPageObj loaded");
		test.log(LogStatus.INFO, "Opening Job Status report Page");
	}
}
