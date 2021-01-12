package generalFilterFunctionalPage;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import csrPageObjects.GeneralFilterPageObj;
import pagebase.Page;
/**
 * 
 * @author milou.rene
 *
 */
public class AddCustomerFunctionalPage extends Page{
	
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
	public AddCustomerFunctionalPage() {
		
		//System.out.println(generalFilterPageObj.getPageTitle().getText());
		
		Assert.assertTrue(generalFilterPageObj.isElementPresent(generalFilterPageObj.byPageTitle()),"Add Customer   page title not found!!");
		
		log.debug("DashboardAPFunctions loaded");
		test.log(LogStatus.INFO, "Opening  Portal");
		
	}
	/**
	 * Validate SearchAll function  
	 */
 
	public void clickAddCustomerRadioBtn() {
		 
		isElementPresent(generalFilterPageObj.byAddCustomer());
		clickSelect(generalFilterPageObj.getAddCustomer());
	
	}

}
