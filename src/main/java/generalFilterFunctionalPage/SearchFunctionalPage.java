package generalFilterFunctionalPage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import csrFormsPageObj.AddCustomerForms;
import csrPageObjects.GeneralFilterPageObj;
import pagebase.Page;
/**
 * 
 * @author milou.rene
 *
 */
public class SearchFunctionalPage extends Page {
	/**
	 * Instance of the Page Object used in the Functions page.
	 */
	GeneralFilterPageObj generalFilterPageObj = new GeneralFilterPageObj();

	/**
	 * SearchFunctionalPage Class constructor
	 * <p>
	 * It will validate if the page title appear once the page is opened.
	 * </p>
	 * 
	 */
	public SearchFunctionalPage() {
	 
		Assert.assertTrue(generalFilterPageObj.isElementPresent(generalFilterPageObj.byPageTitle()),"Search page title not found!!");
		
		log.debug("SearchFunctionalPage loaded");
		test.log(LogStatus.INFO, "Opening Search Page in CSR layout");
		
	}
	
	
	public void clickSearchAllButton() {
		
		click(generalFilterPageObj.getSearchAll());
		click(generalFilterPageObj.getClearFilter());
		click(generalFilterPageObj.getSearch());
		
		
		log.debug("Action to search by All ");
		test.log(LogStatus.INFO, "Action to search by All");
	}
	
	public void quickSearchByAccNmb() {
		click(generalFilterPageObj.getQuickSearch());
		click(generalFilterPageObj.getAccountNumber());
		click(generalFilterPageObj.getClearFilter());
		/*
		 * need logic for account number validation
		 * check all account naming and number conventions
		 */
		
		click(generalFilterPageObj.getSearch());
		
		log.debug("Action to search by Account Number");
		test.log(LogStatus.INFO, "Action to search by Account Number");
	}
	
	public void quickSearchByLastNme() throws InterruptedException {
		click(generalFilterPageObj.getQuickSearch());
		click(generalFilterPageObj.getCustomerLastName());
		click(generalFilterPageObj.getClearFilter());
		
		log.debug("Action to search by last name ");
		test.log(LogStatus.INFO, "Action to search by last name");
		/*
		 *  need logic for last name validation
		 *  check all naming conventions
		 */
		
		click(generalFilterPageObj.getSearch());
		
	}
	 
	
	public void addCustomers() {
		click(generalFilterPageObj.getAddCustomer());
		// fill out Add customer form 
		AddCustomerForms form = new AddCustomerForms();
	
		log.debug("Action to add customer ");
		test.log(LogStatus.INFO, "Action to add customer");
	}
	
	
	 
}
