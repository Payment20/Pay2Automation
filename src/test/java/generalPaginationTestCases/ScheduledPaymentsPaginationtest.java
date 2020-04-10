package generalPaginationTestCases;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import automationPayment20.TestBase;
import csrFunctionPage.SignInPageFunction;
import csrNavigationFunctionalPage.CsrNavigationFunctionalPage;
import csrNavigationPageObjects.CsrScheduledPaymentsReportNavigationPageObj;
import csrPaginationFunctionPage.CsrPaginationFunctionPage;
 
/**
 * 
 * @author milou.rene
 *
 */
public class ScheduledPaymentsPaginationtest extends TestBase{
	
	 
	@Test
	public void doSchedulePaymentPaginationTest() {
		
		SignInPageFunction signInPage = new SignInPageFunction();
		signInPage.LoginAP();
		
		CsrNavigationFunctionalPage csrNavigationFunctionalPage = new CsrNavigationFunctionalPage();
		csrNavigationFunctionalPage.goToScheduledPaymentReport();
		
		CsrScheduledPaymentsReportNavigationPageObj pageToClick = new CsrScheduledPaymentsReportNavigationPageObj();
		WebElement element = pageToClick.getScheduledPaymentsPaginationPullRight();
		
		CsrPaginationFunctionPage csrPaginationFunctionPage = new CsrPaginationFunctionPage();
		csrPaginationFunctionPage.paginationPagesPullRight(element);
		Reporter.log("Login CSR QA Portal Successfully Executed!!!");
	}

}
