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
public class AutoManagerReportTest extends TestBase{
	
	@Test
	public void goToAutoPaymentMngReportTest() {
		
		CsrNavigationFunctionalPage csrNavigationFunctionalPage = new CsrNavigationFunctionalPage();
		csrNavigationFunctionalPage.goToAutoPymentMngReport();
	
		Reporter.log("Going to Auto Payment Manager report Portal Successfully Executed!!!");
	}

}
