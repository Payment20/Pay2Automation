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
public class ReturnReportTest extends TestBase{
	@Test
	public void goToReturnReportTest() {
		
		CsrNavigationFunctionalPage csrNavigationFunctionalPage = new CsrNavigationFunctionalPage();
		csrNavigationFunctionalPage.goToReturnReport();
	
		Reporter.log("Going to Return report Portal Successfully Executed!!!");
	}

}
