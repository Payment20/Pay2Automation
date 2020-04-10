package csrFunctionPage;

import org.testng.Assert;
// to change to 
import com.relevantcodes.extentreports.LogStatus;
/**
 * OSG QA Automation Team......
 * @author milou.rene
 */
import csrNavigationPageObjects.CsrActivitiesReportNavigationPageObj;
import pagebase.Page;
/**
 * 
 * @author milou.rene
 *version 1.0
 */
public class CsrActivitiesReportFunctionPage extends Page{
	/**
	 * instant of the page Object
	 */
	CsrActivitiesReportNavigationPageObj activityReportPageObj = new CsrActivitiesReportNavigationPageObj();
    /**
     * CsrActivitiesReportNavigationPageObj class constructor 
     */

	public CsrActivitiesReportFunctionPage() {
Assert.assertTrue(activityReportPageObj.isElementPresent(activityReportPageObj.byPageTitle()),"CSR Activity report page title not found!!");
		
		log.debug("ManagePricingTablesFunctionsAP loaded");
		test.log(LogStatus.INFO, "Opening Manage Pricing Tables Page in Admin Portal");
	}
}
