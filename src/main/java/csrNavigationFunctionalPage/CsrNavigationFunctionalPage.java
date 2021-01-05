package csrNavigationFunctionalPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import csrFunctionPage.CsrAdminActivitiesReportFunctionPage;
import csrFunctionPage.CsrAutoPaymentManagersReportFunctionPage;
import csrFunctionPage.CsrBankHolydaysFunctionalPage;
import csrFunctionPage.CsrBatchReportFunctionPage;
import csrFunctionPage.CsrBatchScheduleFunctionalPage;
import csrFunctionPage.CsrBillingHierarchySetUpFunctionalPage;
import csrFunctionPage.CsrClientDetailsFunctionalPage;
import csrFunctionPage.CsrClientSetUpFunctionalPage;
import csrFunctionPage.CsrConvenienceFeeStateSetUpFunctionalPage;
import csrFunctionPage.CsrFileViewerUtilityFunctionalPage;
import csrFunctionPage.CsrGroupsFunctionalPage;
import csrFunctionPage.CsrJobsStatusReportFunctionPage;
import csrFunctionPage.CsrManageUsersFunctionalPage;
import csrFunctionPage.CsrOSGGatewaySetUpFunctionalPage;
import csrFunctionPage.CsrActivitiesReportFunctionPage;
import csrFunctionPage.CsrOsgActivitiesReportFunctionPage;
import csrFunctionPage.CsrPaymentPlansReportFunctionPage;
import csrFunctionPage.CsrPaymentReportFunctionPage;
import csrFunctionPage.CsrProgramsFunctionalPage;
import csrFunctionPage.CsrRegisteredUsersReportFunctionPage;
import csrFunctionPage.CsrReturnReportFunctionPage;
import csrFunctionPage.CsrScheduledPaymentsReportFunctionPage;
import csrFunctionPage.CsrSupportFunctionalPage;
import csrFunctionPage.CsrTransactionReportFunctionPage;
import csrFunctionPage.CsrManageUsersFunctionalPage;
import csrNavigationPageObjects.CsrGeneralHeaderPageObj;
import csrNavigationPageObjects.CsrTransactionReportNavigationPageObj;
 
import pagebase.Page;

/**
 * 
 * @author milou.rene
 *version 1.0
 *Report Navigation 
 */
public class CsrNavigationFunctionalPage extends Page{
	 
	CsrGeneralHeaderPageObj csrNavigateTo = new CsrGeneralHeaderPageObj();
	Page page = new Page();
	 
	/*
	 * to navigate to  Reports pages  
	 */
	public CsrActivitiesReportFunctionPage  goToActivityReport() {
	 
		log.debug("Navigating to: Activity report");
		test.log(LogStatus.INFO, "Navigating to: Activity Report");
		
		WebElement elementToHover = csrNavigateTo.getCsrReportHover();
		WebElement elementToClick = csrNavigateTo.getCsrActivitiesReport();
		 /**
		  * from action Method from Page implement here due to JS incompatibility
		  */
		Actions action = new Actions(driver);
		//elementToHover.click();
		action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new CsrActivitiesReportFunctionPage();
		 
	}
	
	
	public CsrAdminActivitiesReportFunctionPage  goToAdminActivityReport() {
		 
		log.debug("Navigating to: Activity report");
		test.log(LogStatus.INFO, "Navigating to: Rctivity report");
		
		
		WebElement elementToHover = csrNavigateTo.getCsrReportHover();
		WebElement elementToClick = csrNavigateTo.getAdminActivitiesReport();
		
		//hoverOnElement(elementToHover, elementToClick );
		//hoverAndClickOnElement(elementToHover, elementToClick);
		
		Actions action = new Actions(driver);
		//elementToHover.click();
		action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new CsrAdminActivitiesReportFunctionPage();
		 
	}
	
	
	public CsrJobsStatusReportFunctionPage  goToJobStatusReport() {
		 
		log.debug("Navigating to: JOb Status report");
		test.log(LogStatus.INFO, "Navigating to: Jobs Status report");
		
		WebElement elementToHover = csrNavigateTo.getCsrReportHover();
		WebElement elementToClick = csrNavigateTo.getJobsStatusReport();
		 
		Actions action = new Actions(driver);
		action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new CsrJobsStatusReportFunctionPage();
		 
	}
	
	
	public CsrOsgActivitiesReportFunctionPage  goToOsgActivityReport() {
		 
		log.debug("Navigating to: OSG Activity report");
		test.log(LogStatus.INFO, "Navigating to: OSG Activity report");
		
		 
		WebElement elementToHover = csrNavigateTo.getCsrReportHover();
		WebElement elementToClick = csrNavigateTo.getOsgActivitiesReport();
		 
		Actions action = new Actions(driver);
		//elementToHover.click();
		action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new CsrOsgActivitiesReportFunctionPage();
		 
	}
	
	
	public CsrAutoPaymentManagersReportFunctionPage  goToAutoPymentMngReport() {
		 
		log.debug("Navigating to: Activity report");
		test.log(LogStatus.INFO, "Navigating to: Rctivity report");
		
	 
		WebElement elementToHover = csrNavigateTo.getCsrReportHover();
		WebElement elementToClick = csrNavigateTo.getAutoPaymentManagersReport();
		 
		Actions action = new Actions(driver);
		//elementToHover.click();
		action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new CsrAutoPaymentManagersReportFunctionPage();
		 
	}
	
	
	public CsrBatchReportFunctionPage  goToBatchReport() {
		 
		log.debug("Navigating to: Batch report");
		test.log(LogStatus.INFO, "Navigating to: Batch report");
		
		WebElement elementToHover = csrNavigateTo.getCsrReportHover();
		WebElement elementToClick = csrNavigateTo.getBatchReprot();
		 
		Actions action = new Actions(driver);
		//elementToHover.click();
		action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new CsrBatchReportFunctionPage();
		 
	}
	
	
	public CsrPaymentPlansReportFunctionPage  goToPaymentPlanReport() {
		 
		log.debug("Navigating to: PAyment Plan report");
		test.log(LogStatus.INFO, "Navigating to: Payment Plan report");
		
		 
		WebElement elementToHover = csrNavigateTo.getCsrReportHover();
		WebElement elementToClick = csrNavigateTo.getPaymentPlansReport();
	 
		Actions action = new Actions(driver);
		//elementToHover.click();
		action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new CsrPaymentPlansReportFunctionPage();
		 
	}
	
	public CsrPaymentReportFunctionPage  goToPaymentReport() {
		 
		log.debug("Navigating to: Activity report");
		test.log(LogStatus.INFO, "Navigating to: Rctivity report");
		
		WebElement elementToHover = csrNavigateTo.getCsrReportHover();
		WebElement elementToClick = csrNavigateTo.getPaymentReport();
		 
		Actions action = new Actions(driver);
		//elementToHover.click();
		action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new CsrPaymentReportFunctionPage();
		 
	}
	
	
	public CsrRegisteredUsersReportFunctionPage  goToRegisteredUserReport() {
		 
		log.debug("Navigating to: Register User report");
		test.log(LogStatus.INFO, "Navigating to: Register User report");
		 
		WebElement elementToHover = csrNavigateTo.getCsrReportHover();
		WebElement elementToClick = csrNavigateTo.getRegisteredUsersReport();
		 
		Actions action = new Actions(driver);
		//elementToHover.click();
		action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new CsrRegisteredUsersReportFunctionPage();
		 
	}
	
	public CsrReturnReportFunctionPage  goToReturnReport() {
		 
		log.debug("Navigating to: Return report");
		test.log(LogStatus.INFO, "Navigating to: Return report");
		
		 
		WebElement elementToHover = csrNavigateTo.getCsrReportHover();
		WebElement elementToClick = csrNavigateTo.getReturnReport();
		 
		Actions action = new Actions(driver);
		//elementToHover.click();
		action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new CsrReturnReportFunctionPage();
		 
	}
	
	
	public CsrScheduledPaymentsReportFunctionPage  goToScheduledPaymentReport() {
		//System.out.println(" here a ");
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.debug("Navigating to: Scheduled Payment report");
		test.log(LogStatus.INFO, "Navigating to: Scheduled Payment report");
		//System.out.println(" here 0 ");
		WebElement elementToHover = csrNavigateTo.getCsrReportHover();
		WebElement elementToClick = csrNavigateTo.getScheduledPaymentsReport();
		//System.out.println(" here 1 ");
		Actions action = new Actions(driver);
		elementToHover.click();
		action.moveToElement(elementToHover).build().perform(); 
		//System.out.println(" here 2 ");
		elementToClick.click();
		//System.out.println(" here 3 ");
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new CsrScheduledPaymentsReportFunctionPage();
		 
	}
	
	
	public CsrTransactionReportFunctionPage  goToTransactionReport() {
		 
		log.debug("Navigating to: Transaction report");
		test.log(LogStatus.INFO, "Navigating to: Transaction report");
		
		WebElement elementToHover = csrNavigateTo.getCsrReportHover();
		WebElement elementToClick = csrNavigateTo.getTransactionReport();
		 
		Actions action = new Actions(driver);
		//elementToHover.click();
		action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new CsrTransactionReportFunctionPage();
		 
	}
	/*All support navigation 
	 * Navigate to Support page
	 */
	
	public CsrSupportFunctionalPage goToSupport() {
	 
		log.debug("Navigating to: Support Requests");
		test.log(LogStatus.INFO, "Navigating to: Support Requests");
		
		//WebElement elementToHover = csrNavigateTo.getcsrSuportHover();
		WebElement elementToClick = csrNavigateTo.getcsrSuportHover();
		 
		//Actions action = new Actions(driver);
		//elementToHover.click();
		//action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new CsrSupportFunctionalPage();
		
	}
	
	/* All users Navigation 
	 * Navigate to ManageUsers Pages
	 */
	public CsrManageUsersFunctionalPage goToManageUsers() {
		 
		log.debug("Navigating to: Manage Users Page");
		test.log(LogStatus.INFO, "Navigating to: Manage Users Page");
		
		WebElement elementToHover = csrNavigateTo.getCsrUserHover();
		WebElement elementToClick = csrNavigateTo.getManageUsers();
		 
		Actions action = new Actions(driver);
		//elementToHover.click();
		action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new CsrManageUsersFunctionalPage();
		
	}
	
	/*
	 * Navigate to Manage Role Pages
	 */
	public CsrManageUsersFunctionalPage goToManageRoles() {
		 
		log.debug("Navigating to: Manage Role Page");
		test.log(LogStatus.INFO, "Navigating to: Manage Role Page");
		
		WebElement elementToHover = csrNavigateTo.getCsrUserHover();
		WebElement elementToClick = csrNavigateTo.getManageRoles();
		 
		Actions action = new Actions(driver);
		//elementToHover.click();
		action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new CsrManageUsersFunctionalPage();
		
	}
	/* All Set Up Navigation 
	 * Navigate to Set Up Pages
	 */
	/*
	 * Navigate to Manage Role Pages
	 */
	public CsrClientDetailsFunctionalPage goToClientDetails() {
		 
		log.debug("Navigating to: Client Details Page");
		test.log(LogStatus.INFO, "Navigating to: Client Details Page");
		
		WebElement elementToHover = csrNavigateTo.getCsrSetupHover();
		WebElement elementToClick = csrNavigateTo.getClientDetails();
		 
		Actions action = new Actions(driver);
		//elementToHover.click();
		action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new CsrClientDetailsFunctionalPage();
		
	}
	
	/*
	 * Navigate to Manage Role Pages
	 * 
	 */
	public CsrClientSetUpFunctionalPage goToClientSetUp() {
		 
		log.debug("Navigating to: Client Set UpPage");
		test.log(LogStatus.INFO, "Navigating to: Client Set Up Page");
		
		WebElement elementToHover = csrNavigateTo.getCsrSetupHover();
		WebElement elementToClick = csrNavigateTo.getClientSetUp();
		 
		Actions action = new Actions(driver);
		//elementToHover.click();
		action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new CsrClientSetUpFunctionalPage();
		
	}
	
	/*
	 * Navigate to Manage Role Pages
	 */
	public CsrBillingHierarchySetUpFunctionalPage goToBillingHierarchySetUp() {
		 
		log.debug("Navigating to: Billing Hierarchy Set Up Page");
		test.log(LogStatus.INFO, "Navigating to: Billing Hierarchy Set Up Page");
		
		WebElement elementToHover = csrNavigateTo.getCsrSetupHover();
		WebElement elementToClick = csrNavigateTo.getBillingHierarchySetUp();
		 
		Actions action = new Actions(driver);
		//elementToHover.click();
		action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new  CsrBillingHierarchySetUpFunctionalPage();
		
	}
	
	/*
	 * Navigate to Manage Role Pages
	 */
	public CsrConvenienceFeeStateSetUpFunctionalPage goToConvenienceFeeStateSetUp() {
		 
		log.debug("Navigating to: Convenience Fee State Set Up Page");
		test.log(LogStatus.INFO, "Navigating to: Convenience Fee State Set Up Page");
		
		WebElement elementToHover = csrNavigateTo.getCsrSetupHover();
		WebElement elementToClick = csrNavigateTo.getConvenienceFeeSetUp();
		 
		Actions action = new Actions(driver);
		//elementToHover.click();
		action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new CsrConvenienceFeeStateSetUpFunctionalPage();
		
	}
	
	/*
	 * Navigate to Manage Role Pages
	 */
	public CsrBatchScheduleFunctionalPage goToBatchSchedule() {
		 
		log.debug("Navigating to: Batch Schedule Page");
		test.log(LogStatus.INFO, "Navigating to: Batch Schedule Page");
		
		WebElement elementToHover = csrNavigateTo.getCsrSetupHover();
		WebElement elementToClick = csrNavigateTo.getBatchSchedule();
		 
		Actions action = new Actions(driver);
		//elementToHover.click();
		action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new CsrBatchScheduleFunctionalPage();
		
	}
	
	/*
	 * Navigate to Manage Role Pages
	 */
	public CsrBankHolydaysFunctionalPage goToBankHolydays() {
		 
		log.debug("Navigating to: Bank Holydays Page");
		test.log(LogStatus.INFO, "Navigating to:  Bank Holydays Page");
		
		WebElement elementToHover = csrNavigateTo.getCsrSetupHover();
		WebElement elementToClick = csrNavigateTo.getBankHolydays();
		 
		Actions action = new Actions(driver);
		//elementToHover.click();
		action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new CsrBankHolydaysFunctionalPage();
		
	}
	
	/*
	 * Navigate to Manage Role Pages
	 */
	public CsrOSGGatewaySetUpFunctionalPage goToOSGGatewaySetUp() {
		 
		log.debug("Navigating to: OSG Gateway Set Up Page");
		test.log(LogStatus.INFO, "Navigating to: OSG Gateway Set Up Page");
		
		WebElement elementToHover = csrNavigateTo.getCsrSetupHover();
		WebElement elementToClick = csrNavigateTo.getOSGGatewaySetUp();
		 
		Actions action = new Actions(driver);
		//elementToHover.click();
		action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new  CsrOSGGatewaySetUpFunctionalPage();
		
	}
	
	/*
	 * Navigate to Manage Role Pages
	 */
	public CsrProgramsFunctionalPage goToPrograms() {
		 
		log.debug("Navigating to: Programs Page");
		test.log(LogStatus.INFO, "Navigating to: Programs Page");
		
		WebElement elementToHover = csrNavigateTo.getCsrSetupHover();
		WebElement elementToClick = csrNavigateTo.getPrograms();
		 
		Actions action = new Actions(driver);
		//elementToHover.click();
		action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new  CsrProgramsFunctionalPage();
		
	}
	
	/*
	 * Navigate to Manage Role Pages
	 */
	public CsrGroupsFunctionalPage goToGroups() {
		 
		log.debug("Navigating to: Manage Role Page");
		test.log(LogStatus.INFO, "Navigating to: Manage Role Page");
		
		WebElement elementToHover = csrNavigateTo.getCsrSetupHover();
		WebElement elementToClick = csrNavigateTo.getGroups();
		 
		Actions action = new Actions(driver);
		//elementToHover.click();
		action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new CsrGroupsFunctionalPage();
		
	}
	
	/*
	 * Navigate to Manage Role Pages
	 */
	public CsrFileViewerUtilityFunctionalPage goToFileViewerUtility() {
		 
		log.debug("Navigating to:  File Viewer Utility Page");
		test.log(LogStatus.INFO, "Navigating to: Manage Role Page");
		
		WebElement elementToHover = csrNavigateTo.getCsrUserHover();
		WebElement elementToClick = csrNavigateTo.getFileViewerUtility();
		 
		Actions action = new Actions(driver);
		//elementToHover.click();
		action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new CsrFileViewerUtilityFunctionalPage();
		
	}
}
