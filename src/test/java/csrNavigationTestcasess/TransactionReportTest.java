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
public class TransactionReportTest extends TestBase{

	@Test
	public void goToTransactionReportTest() {
		
		CsrNavigationFunctionalPage csrNavigationFunctionalPage = new CsrNavigationFunctionalPage();
		csrNavigationFunctionalPage.goToTransactionReport();
	
		Reporter.log("Going to Transcation report Portal Successfully Executed!!!");
	}

}
