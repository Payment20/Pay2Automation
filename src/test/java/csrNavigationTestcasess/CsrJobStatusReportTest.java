package csrNavigationTestcasess;

import org.testng.Reporter;
import org.testng.annotations.Test;

import automationPayment20.TestBase;
import csrNavigationFunctionalPage.CsrNavigationFunctionalPage;

/**
 * 
 * @author milou.rene
 *
 */
public class CsrJobStatusReportTest extends TestBase{
	@Test
	public void goToCsrJobStatusReportTest() {
		
		CsrNavigationFunctionalPage csrNavigationFunctionalPage = new CsrNavigationFunctionalPage();
		csrNavigationFunctionalPage.goToJobStatusReport();
	
		Reporter.log("Going to Job Status report Portal Successfully Executed!!!");
	}


}
