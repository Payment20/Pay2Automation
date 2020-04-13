package csrNavigationFunctionalPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

import csrFunctionPage.CsrAdminActivitiesReportFunctionPage;
import csrFunctionPage.CsrAutoPaymentManagersReportFunctionPage;
import csrFunctionPage.CsrBatchReportFunctionPage;
import csrFunctionPage.CsrJobsStatusReportFunctionPage;
import csrFunctionPage.CsrActivitiesReportFunctionPage;
import csrFunctionPage.CsrOsgActivitiesReportFunctionPage;
import csrFunctionPage.CsrPaymentPlansReportFunctionPage;
import csrFunctionPage.CsrPaymentReportFunctionPage;
import csrFunctionPage.CsrRegisteredUsersReportFunctionPage;
import csrFunctionPage.CsrReturnReportFunctionPage;
import csrFunctionPage.CsrScheduledPaymentsReportFunctionPage;
import csrFunctionPage.CsrTransactionReportFunctionPage;
import csrNavigationPageObjects.CsrGeneralHeaderPageObj;
import pagebase.Page;

/**
 * 
 * @author milou.rene
 *version 1.0
 */
public class CsrNavigationFunctionalPage extends Page{
	 
	CsrGeneralHeaderPageObj csrNavigateTo = new CsrGeneralHeaderPageObj();
	Page page = new Page();
	 
	/*
	 * to navigate to all pages  
	 */
	public CsrActivitiesReportFunctionPage  goToActivityReport() {
	 
		log.debug("Navigating to: Activity report");
		test.log(LogStatus.INFO, "Navigating to: Rctivity report");
		
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
		Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.debug("Navigating to: Scheduled Payment report");
		test.log(LogStatus.INFO, "Navigating to: Scheduled Payment report");
		
		WebElement elementToHover = csrNavigateTo.getCsrReportHover();
		WebElement elementToClick = csrNavigateTo.getScheduledPaymentsReport();
		
		Actions action = new Actions(driver);
		elementToHover.click();
		action.moveToElement(elementToHover).build().perform(); 
		elementToClick.click();
		
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
}
