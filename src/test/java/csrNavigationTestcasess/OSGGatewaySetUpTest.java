package csrNavigationTestcasess;

import org.testng.Reporter;
import org.testng.annotations.Test;

import automationPayment20.TestBase;
import csrNavigationFunctionalPage.CsrNavigationFunctionalPage;

public class OSGGatewaySetUpTest extends TestBase{
	
	
	@Test
	public void goToOSGGatewaySetUpTest() {
		
		CsrNavigationFunctionalPage csrNavigationFunctionalPage = new CsrNavigationFunctionalPage();
		csrNavigationFunctionalPage.goToOSGGatewaySetUp();
	
		Reporter.log("Going to OSG Gateway set UpTest Portal Successfully Executed!!!");
	}

}
