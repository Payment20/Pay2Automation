package csrNavigationTestcasess;

import org.testng.Reporter;
import org.testng.annotations.Test;

import automationPayment20.TestBase;
import csrNavigationFunctionalPage.CsrNavigationFunctionalPage;

public class ClientSetUpTest extends TestBase{
	
	@Test
	public void goToClientSetUp() {
		
		CsrNavigationFunctionalPage csrNavigationFunctionalPage = new CsrNavigationFunctionalPage();
		csrNavigationFunctionalPage.goToClientSetUp();
	
		Reporter.log("Going to Clien Set Up Portal Successfully Executed!!!");
	}

}
