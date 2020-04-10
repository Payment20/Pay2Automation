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
public class ScheduledPaymentsReportTest extends TestBase{
	@Test
	public void goToScheduledPaymentsReportTest() {
		
		CsrNavigationFunctionalPage csrNavigationFunctionalPage = new CsrNavigationFunctionalPage();
		csrNavigationFunctionalPage.goToScheduledPaymentReport();
	
		Reporter.log("Going to Scheduled Payment report Portal Successfully Executed!!!");
	}
	 
}
