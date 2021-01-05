package csrNavigationTestcasess;

import org.testng.Reporter;
import org.testng.annotations.Test;

import automationPayment20.TestBase;
import csrNavigationFunctionalPage.CsrNavigationFunctionalPage;

public class ProgramsTest extends TestBase{
	
	

	@Test
	public void goToProgramsTest() {
		
		CsrNavigationFunctionalPage csrNavigationFunctionalPage = new CsrNavigationFunctionalPage();
		csrNavigationFunctionalPage.goToPrograms();
	
		Reporter.log("Going to Programs Portal Successfully Executed!!!");
	}

}
