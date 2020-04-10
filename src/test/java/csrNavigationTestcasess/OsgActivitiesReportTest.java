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
public class OsgActivitiesReportTest extends TestBase{
	
	@Test
	public void goToOSGActivitiesReportTest() {
		
		CsrNavigationFunctionalPage csrNavigationFunctionalPage = new CsrNavigationFunctionalPage();
		csrNavigationFunctionalPage.goToOsgActivityReport();
	
		Reporter.log("Going to OSG Activity report Portal Successfully Executed!!!");
	}

}
