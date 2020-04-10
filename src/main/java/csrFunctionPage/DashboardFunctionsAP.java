package csrFunctionPage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import csrPageObjects.DashboardPageObjAP;
import pagebase.Page;

/**
 * Payment 2.0 Automation Team
 * @version 1.0
 */
public class DashboardFunctionsAP extends Page{
	
	/**
	 * Instance of the Page Object used in the Dashboard page.
	 */
	DashboardPageObjAP dashboardAPPageObj = new DashboardPageObjAP();
	
	/**
	 * DashboardFunctions Class constructor
	 * <p>
	 * It will validate if the page title DASHBOARD appear once the page is opened.
	 * </p>
	 * 
	 */
	public DashboardFunctionsAP() {
		
		//System.out.println(dashboardPageObj.getPageTitle().getText());
		
		Assert.assertTrue(dashboardAPPageObj.isElementPresent(dashboardAPPageObj.byPageTitle()),"DASHBOARD page title not found!!");
		
		log.debug("DashboardAPFunctions loaded");
		test.log(LogStatus.INFO, "Opening Dashboard Page in Admin Portal");
		
	}

}
