package csrFunctionPage;

import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import csrPageObjects.SignInPageObj;
import pagebase.Page;


/**
 * @author OSG QA Automation Team
 * @version 1.0
 */

public class SignInPageFunction extends Page {
	
	/**
	 * Instance of the Page Object used in the Sign page.
	 */
	SignInPageObj signInPageObj = new SignInPageObj();

	/**
	 * LoginFunctions Class constructor
	 * <p>
	 * It will validate if the SignIn button appear once the page is opened.
	 * </p>
	 * 
	 */
	public SignInPageFunction() {
		Assert.assertTrue(isElementPresent(signInPageObj.bySignInButton()), "SignIn button not found!!");

		log.debug("LoginFunctions loaded");
		//test.log(LogStatus.INFO, "Opening Login Page"); remove back slash to return to normal
		test.log(LogStatus.INFO, "Test name","Opening Login Page");

	}

	/**
	 * Login into the CSR QA Portal.
	 * <p>
	 * It will validate if the Dashboard appear once the page is opened and will use a master admin credentials for login into the system
	 * </p>
	 * @author OSG QA Automation team
	 */
	public DashboardFunctionsAP LoginAP() {

		log.debug("Login into CSR QA Portal");

		type(signInPageObj.getUserName(), "userName", config.getProperty("Pay2User"));
		type(signInPageObj.getPassword(), "password", config.getProperty("Pay2Password"));

		clickSelect(signInPageObj.getSignInButton());

		return new DashboardFunctionsAP();

		}


}
