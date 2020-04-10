package generalFilterFunctionalPage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import csrPageObjects.GeneralFilterPageObj;
import pagebase.Page;

/**
 * OSG QA Automation team 
 * Version1.0
 */
public class SearchAllFunctionalPage extends Page {

	
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
		public SearchAllFunctionalPage() {
			
			//System.out.println(generalFilterPageObj.getPageTitle().getText());
			
			Assert.assertTrue(generalFilterPageObj.isElementPresent(generalFilterPageObj.byPageTitle()),"Customer Search page title not found!!");
			
			log.debug("DashboardAPFunctions loaded");
			test.log(LogStatus.INFO, "Opening Dashboard Page in Admin Portal");
			
		}
		/**
		 * Validate SearchAll function  
		 */
	 
		public void checkSearchAllRadioBtn() {
			 
			isElementPresent(generalFilterPageObj.bySearchAll());
			clickSelect(generalFilterPageObj.getSearchAll());
			isElementPresent(generalFilterPageObj.bySearch());
			clickSelect(generalFilterPageObj.getSearch());
			
		}
		
}
