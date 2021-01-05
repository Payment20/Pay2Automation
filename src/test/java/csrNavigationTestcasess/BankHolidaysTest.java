package csrNavigationTestcasess;

import org.testng.Reporter;
import org.testng.annotations.Test;

import automationPayment20.TestBase;
import csrNavigationFunctionalPage.CsrNavigationFunctionalPage;

public class BankHolidaysTest extends TestBase{
	
	
	@Test
	public void goToBankHolidaysTest() {
		
		CsrNavigationFunctionalPage csrNavigationFunctionalPage = new CsrNavigationFunctionalPage();
		csrNavigationFunctionalPage.goToBankHolydays();
	
		Reporter.log("Going to Bank Hollydays Portal Successfully Executed!!!");
	}

}
