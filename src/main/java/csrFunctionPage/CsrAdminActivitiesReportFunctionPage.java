package csrFunctionPage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

 
import csrNavigationPageObjects.CsrAdminActivitiesReportNavigationPageObj;
import pagebase.Page;
/**
 * 
 * @author milou.rene
 *version 1.0
 */
public class CsrAdminActivitiesReportFunctionPage extends Page{
	
	/**
	 * instant of the page Object
	 */
	CsrAdminActivitiesReportNavigationPageObj AdminActivityReportPageObj = new CsrAdminActivitiesReportNavigationPageObj();
    /**
     * CsrActivitiesReportNavigationPageObj class constructor 
     */

	public CsrAdminActivitiesReportFunctionPage() {
Assert.assertTrue(AdminActivityReportPageObj.isElementPresent(AdminActivityReportPageObj.byPageTitle()),"CSR Admin Activity report page title not found!!");
		
		log.debug("CsrAdminActivitiesReportFunctionPage loaded");
		test.log(LogStatus.INFO, "Opening Admin Activity Page");
	}

}
