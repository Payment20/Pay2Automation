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
public class PaymentPlanReportTest extends TestBase{
	@Test
	public void goToPaymentPlanReportTest() {
		
		CsrNavigationFunctionalPage csrNavigationFunctionalPage = new CsrNavigationFunctionalPage();
		csrNavigationFunctionalPage.goToPaymentPlanReport();
	
		Reporter.log("Going to Payment Plan report Portal Successfully Executed!!!");
	}
	

}
