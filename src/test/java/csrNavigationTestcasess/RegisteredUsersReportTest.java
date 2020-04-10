package csrNavigationTestcasess;

import org.testng.Reporter;
import org.testng.annotations.Test;

import automationPayment20.TestBase;
import csrNavigationFunctionalPage.CsrNavigationFunctionalPage;

/**
 * 
 * @author milou.rene
 *
 */
public class RegisteredUsersReportTest extends TestBase {
	
	@Test
	public void goToRegisteredUsersReportTest() {
		
		CsrNavigationFunctionalPage csrNavigationFunctionalPage = new CsrNavigationFunctionalPage();
		csrNavigationFunctionalPage.goToRegisteredUserReport();
	
		Reporter.log("Going to Registered user report Portal Successfully Executed!!!");
	}

}
