package csrSignInPageTestCase;

import org.testng.Reporter;
import org.testng.annotations.Test;
import automationPayment20.TestBase;
import csrFunctionPage.SignInPageFunction;
 

//Test CSR SignIn page
public class SignInPageTest extends TestBase{
// test to signIn Users
	@Test
	public void doLogin() {
		SignInPageFunction signInPage = new SignInPageFunction();
		signInPage.LoginAP();
		Reporter.log("Login CSR QA Portal Successfully Executed!!!");
	}
}
