package csrNavigationTestcasess;

import org.testng.Reporter;
import org.testng.annotations.Test;

import automationPayment20.TestBase;
import csrNavigationFunctionalPage.CsrNavigationFunctionalPage;

public class ClientDetailsTest extends TestBase{
	
	@Test
	public void goToClientDetailsTest() {
		
		CsrNavigationFunctionalPage csrNavigationFunctionalPage = new CsrNavigationFunctionalPage();
		csrNavigationFunctionalPage.goToClientDetails();
	
		Reporter.log("Going to Client Details Successfully Executed!!!");
	}

}
