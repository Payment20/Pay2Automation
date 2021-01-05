package csrNavigationTestcasess;

import org.testng.Reporter;
import org.testng.annotations.Test;

import automationPayment20.TestBase;
import csrNavigationFunctionalPage.CsrNavigationFunctionalPage;

public class BatchScheduleTest extends TestBase{
	
	
	@Test
	public void goToBatchScheduleTest() {
		
		CsrNavigationFunctionalPage csrNavigationFunctionalPage = new CsrNavigationFunctionalPage();
		csrNavigationFunctionalPage.goToBatchSchedule();
	
		Reporter.log("Going to Batch Schedule   Portal Successfully Executed!!!");
	}

}
