package csrNavigationTestcasess;

import org.testng.Reporter;
import org.testng.annotations.Test;

import automationPayment20.TestBase;
import csrNavigationFunctionalPage.CsrNavigationFunctionalPage;

public class ManageUsersTest extends TestBase{
	
	 
		@Test
		public void goToManageUsersTest() {
			
			CsrNavigationFunctionalPage csrNavigationFunctionalPage = new CsrNavigationFunctionalPage();
			csrNavigationFunctionalPage.goToManageUsers();
		
			Reporter.log("Going to users Portal Successfully Executed!!!");
		}

	}



