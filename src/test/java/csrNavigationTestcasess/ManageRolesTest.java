package csrNavigationTestcasess;

import org.testng.Reporter;
import org.testng.annotations.Test;

import automationPayment20.TestBase;
import csrNavigationFunctionalPage.CsrNavigationFunctionalPage;

public class ManageRolesTest extends TestBase{
	
	@Test
	public void goToManageRolesTest() {
		
		CsrNavigationFunctionalPage csrNavigationFunctionalPage = new CsrNavigationFunctionalPage();
		csrNavigationFunctionalPage.goToManageRoles();
	
		Reporter.log("Going to Manage Roles Portal Successfully Executed!!!");
	}

}
