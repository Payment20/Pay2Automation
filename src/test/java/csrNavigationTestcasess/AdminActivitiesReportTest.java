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
public class AdminActivitiesReportTest extends TestBase{
	@Test
	public void goToAdminActivitiesReportTest() {
		
		CsrNavigationFunctionalPage csrNavigationFunctionalPage = new CsrNavigationFunctionalPage();
		csrNavigationFunctionalPage.goToAdminActivityReport();
	
		Reporter.log("Going to Admin Activity report Portal Successfully Executed!!!");
	}
}
