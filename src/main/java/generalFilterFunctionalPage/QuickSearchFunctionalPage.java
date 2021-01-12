package generalFilterFunctionalPage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import csrPageObjects.GeneralFilterPageObj;
import pagebase.Page;

public class QuickSearchFunctionalPage extends Page {
	
	
	
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
	public QuickSearchFunctionalPage() {
		
		//System.out.println(generalFilterPageObj.getPageTitle().getText());
		
		Assert.assertTrue(generalFilterPageObj.isElementPresent(generalFilterPageObj.byPageTitle()),"Quick Search page title not found!!");
		
		log.debug("DashboardAPFunctions loaded");
		test.log(LogStatus.INFO, "Opening Customer Search Page  ");
		
	}
	/**
	 * Validate SearchAll function  
	 */
 
	public void checkQuickSearchRadioBtn() {
		 
		isElementPresent(generalFilterPageObj.byQuickSearch());
		clickSelect(generalFilterPageObj.getQuickSearch());
		isElementPresent(generalFilterPageObj.byQuickSearch());
		clickSelect(generalFilterPageObj.getQuickSearch());
		
	}

}
