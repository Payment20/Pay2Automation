package csrNavigationTestcasess;

import org.testng.Reporter;
import org.testng.annotations.Test;

import automationPayment20.TestBase;
import csrNavigationFunctionalPage.CsrNavigationFunctionalPage;

public class BillingHierarchySetUpTest extends TestBase{
	
	@Test
	public void goToBillingHierarchySetUp() {
		
		CsrNavigationFunctionalPage csrNavigationFunctionalPage = new CsrNavigationFunctionalPage();
		csrNavigationFunctionalPage.goToBillingHierarchySetUp();
	
		Reporter.log("Going to  Billing Hierarchy Set Up Portal Successfully Executed!!!");
	}


}
