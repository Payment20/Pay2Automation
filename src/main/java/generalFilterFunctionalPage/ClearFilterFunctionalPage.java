package generalFilterFunctionalPage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import csrPageObjects.GeneralFilterPageObj;
import pagebase.Page;

public class ClearFilterFunctionalPage extends Page{
	
	/**
	 * Instance of the Page Object used in the General Filter Page Obj.
	 */
	GeneralFilterPageObj generalFilterPageObj = new GeneralFilterPageObj();
	
	/**
	 * General Filter Class constructor
	 * <p>
	 * It will validate if the page title Search appear once the page is opened.
	 * </p>
	 * 
	 */
	public ClearFilterFunctionalPage() {
		
		//System.out.println(generalFilterPageObj.getPageTitle().getText());
		
		Assert.assertTrue(generalFilterPageObj.isElementPresent(generalFilterPageObj.byPageTitle()),"Clear filter page title not found!!");
		
		log.debug("DashboardAPFunctions loaded");
		test.log(LogStatus.INFO, "Opening Dashboard Page in Admin Portal");
		
	}
	/**
	 * Validate SearchAll function  
	 */
 
	public void clickClearFilterRadioBtn() {
		 
		isElementPresent(generalFilterPageObj.byClearFilter());
		clickSelect(generalFilterPageObj.getClearFilter());		
	}

}
