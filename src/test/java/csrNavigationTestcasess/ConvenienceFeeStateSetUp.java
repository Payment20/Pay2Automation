package csrNavigationTestcasess;

import org.testng.Reporter;
import org.testng.annotations.Test;

import automationPayment20.TestBase;
import csrNavigationFunctionalPage.CsrNavigationFunctionalPage;

public class ConvenienceFeeStateSetUp extends TestBase{
	
	
	@Test
	public void goToConvenienceFeeStateSetUpTest() {
		
		CsrNavigationFunctionalPage csrNavigationFunctionalPage = new CsrNavigationFunctionalPage();
		csrNavigationFunctionalPage.goToConvenienceFeeStateSetUp();
	
		Reporter.log("Going to Convenience Fee State Set Up Portal Successfully Executed!!!");
	}

}
