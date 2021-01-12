package generalFilterFunctionalPage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import csrFunctionPage.DashboardFunctionsAP;
import csrPageObjects.GeneralFilterPageObj;
import pagebase.Page;

/**
 * 
 * @author milou.rene
 *@version 1.0
 */
public class CustomerLastNameFunctionalPage extends Page{
	
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
	public CustomerLastNameFunctionalPage() {
		
		//System.out.println(generalFilterPageObj.getPageTitle().getText());
		
		Assert.assertTrue(generalFilterPageObj.isElementPresent(generalFilterPageObj.byPageTitle()),"Customer Search page title not found!!");
		
		log.debug("DashboardAPFunctions loaded");
		test.log(LogStatus.INFO, "Opening   Page   Portal");
		
	}
	/**
	 * Validate SearchAll function  
	 */
 
	public   DashboardFunctionsAP checkSearchCustomerLastNameRadioBtn() {
		 
		//clickSelect(generalFilterPageObj.getQuickSearch());
		isElementPresent(generalFilterPageObj.byCustomerLastName());
		clickSelect(generalFilterPageObj.getCustomerLastName());
		isElementPresent(generalFilterPageObj.byKeyword());
		
		 
		type(generalFilterPageObj.getKeyword(), "keyword", config.getProperty("customerLastName"));
		isElementPresent(generalFilterPageObj.bySearch());
		clickSelect(generalFilterPageObj.getSearch());
		
		return new DashboardFunctionsAP();
	}

}
