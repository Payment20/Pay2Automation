package csrNavigationTestcasess;

import org.testng.Reporter;
import org.testng.annotations.Test;

import automationPayment20.TestBase;
import csrNavigationFunctionalPage.CsrNavigationFunctionalPage;

public class FileViewerUtilityTest extends TestBase{

	
	@Test
	public void goToFileViewerUtilityTest() {
		
		CsrNavigationFunctionalPage csrNavigationFunctionalPage = new CsrNavigationFunctionalPage();
		csrNavigationFunctionalPage.goToFileViewerUtility();
	
		Reporter.log("Going to File Viewer Utility Portal Successfully Executed!!!");
	}
}
