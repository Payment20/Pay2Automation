package csrNavigationTestcasess;

import org.testng.Reporter;
import org.testng.annotations.Test;

import automationPayment20.TestBase;
import csrNavigationFunctionalPage.CsrNavigationFunctionalPage;

public class GroupsTest extends TestBase{
	
	
	
	@Test
	public void goToGroupsTest() {
		
		CsrNavigationFunctionalPage csrNavigationFunctionalPage = new CsrNavigationFunctionalPage();
		csrNavigationFunctionalPage.goToGroups();
	
		Reporter.log("Going to Groups Portal Successfully Executed!!!");
	}

}
