package generalFilterFunctionalPage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import csrPageObjects.GeneralFilterPageObj;
import pagebase.Page;
/**
 * 
 * @author milou.rene
 *@version  1.0
 */
public class AccountNumberFunctionalPage extends Page{
	
	
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
	public AccountNumberFunctionalPage() {
		
		//System.out.println(generalFilterPageObj.getPageTitle().getText());
		
		Assert.assertTrue(generalFilterPageObj.isElementPresent(generalFilterPageObj.byPageTitle()),"Account Number Search page title not found!!");
		
		log.debug("DashboardAPFunctions loaded");
		test.log(LogStatus.INFO, "Opening Account Number Page  ");
		
	}
	/**
	 * Validate SearchAll function  
	 */
 
	public void checkAccountNumberRadioBtn() {
		 
		isElementPresent(generalFilterPageObj.byAccountNumber());
		clickSelect(generalFilterPageObj.getAccountNumber());
		isElementPresent(generalFilterPageObj.byQuickSearch());
		clickSelect(generalFilterPageObj.getQuickSearch());
		
	}

}
