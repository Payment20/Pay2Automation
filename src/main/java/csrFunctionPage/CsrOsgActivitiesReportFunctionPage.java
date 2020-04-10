package csrFunctionPage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import csrNavigationPageObjects.CsrOsgActivitiesReportNavigationPageObj;
import pagebase.Page;
/**
 * 
 * @author milou.rene
 *version 1.0
 */
public class CsrOsgActivitiesReportFunctionPage extends Page{
	
	/**
	 * instant of the page Object
	 */
	CsrOsgActivitiesReportNavigationPageObj CsrOsgActivitiesReportPageObj = new CsrOsgActivitiesReportNavigationPageObj();
    /**
     * CsrActivitiesReportNavigationPageObj class constructor 
     */

	public CsrOsgActivitiesReportFunctionPage() {
    Assert.assertTrue(CsrOsgActivitiesReportPageObj.isElementPresent(CsrOsgActivitiesReportPageObj.byPageTitle()),"CSR  OSG Activity report page title not found!!");
		
		log.debug("CsrOsgActivitiesReportPageObj loaded");
		test.log(LogStatus.INFO, "Opening OSG Activity report Page");
	}
}
