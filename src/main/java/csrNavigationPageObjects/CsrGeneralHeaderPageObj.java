package csrNavigationPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pagebase.Page;
 /*
  * OSG QA Automation team
  * Version 1.0
  * 
  * this class sets the element on the Report menu 
  */
public class CsrGeneralHeaderPageObj {
	 
	private By csrReportHover = By.xpath("//*[@id=\"liReport\"]/button/span[1]"); 
	private By csrSuportHover = By.xpath("//*[@id=\"liSupport\"]/div/a");  
	private By csrUserHover = By.xpath("//*[@id=\"liUsers\"]/button/span[1]");
	private By csrSetupHover = By.xpath("//*[@id=\"Setup\"]/button/span[1]");
	private By csrActivitiesReport =By.xpath("//*[@id=\"liReport\"]/div/a[9]") ;
	private By adminActivitiesReport =By.xpath("//*[@id=\"liReport\"]/div/li/a") ;
	private By autoPaymentManagersReport =By.xpath("//*[@id=\"liReport\"]/div/a[11]") ;
	private By batchReprot =By.xpath("//*[@id=\"liReport\"]/div/a[1]") ; 
	private By jobsStatusReport =By.xpath("//*[@id=\"liReport\"]/div/a[10]") ;
	private By osgActivitiesReport =By.xpath("//*[@id=\"liReport\"]/div/a[8]") ;
	private By paymentPlansReport =By.xpath("//*[@id=\"liReport\"]/div/a[6]");
	private By paymentReport =By.xpath("//*[@id=\"liReport\"]/div/a[3]") ; 
	private By registeredUsersReport =By.xpath("//*[@id=\"liReport\"]/div/a[5]") ;
	private By report =By.xpath("") ;
	private By returnReport =By.xpath("//*[@id=\"liReport\"]/div/a[4]") ;
	private By scheduledPaymentsReport =By.xpath("//*[@id=\"liReport\"]/div/a[7]") ;
	private By transactionReport  =By.xpath("//*[@id=\"liReport\"]/div/a[2]") ;
	private By customerOverViewReport = By.xpath("//*[@id=\"liReport\"]/div/a[5]");
	private By manageUsers = By.xpath("//*[@id=\"liUsers\"]/div/a[1]");
	private By manageRoles = By.xpath("//*[@id=\"liUsers\"]/div/a[2]");  
	private By clientDetails = By.xpath("//*[@id=\"Setup\"]/div/a[1]");
	private By clientSetUp = By.xpath("//*[@id=\"Setup\"]/div/a[2]");
	private By billingHierarchySetUp = By.xpath("//*[@id=\"lnkdbh\"]");
	private By convenienceFeeSetUp = By.xpath("//*[@id=\"liStateFeeSetup\"]");
	private By batchSchedule = By.xpath("//*[@id=\"liBatchTime\"]");
	private By bankHolydays = By.xpath("//*[@id=\"liBankHoliday\"]");
	private By OSGGatewaySetUp = By.xpath("//*[@id=\"liOsgGateway\"]");
	private By programs = By.xpath("//*[@id=\"liProgrammenu\"]");
	private By groups = By.xpath("//*[@id=\"liGroupmenu\"]");
	private By fileViewerUtility = By.xpath("//*[@id=\"liFileViewer\"]");
	
	 
	//get and set WebElement 
	
	public WebElement getCsrReportHover() {
		return Page.driver.findElement(csrReportHover);
	}
	
	public By byCsrReportHovert() {
		return csrReportHover;
	}
	
	public WebElement getcsrSuportHover() {
		return Page.driver.findElement(csrSuportHover);
	}
	
	public By bycsrSuportHover() {
		return csrSuportHover;
	}
	
	public WebElement getCsrUserHover() {
		return Page.driver.findElement(csrUserHover);
	}
	
	public By byCsrUserHover() {
		return csrUserHover;
	}
	
	public WebElement getCsrSetupHover() {
		return Page.driver.findElement(csrSetupHover);
	}
	
	public By byCsrSetupHover() {
		return csrSetupHover;
	}
	
	public WebElement getCsrActivitiesReport() {
		return Page.driver.findElement(csrActivitiesReport);
	}
	
	public By byCsrActivitiesReport() {
		return csrActivitiesReport;
	}
	
	public WebElement getAdminActivitiesReport() {
		return Page.driver.findElement(adminActivitiesReport);
	}
	
	public By byAdminActivitiesReport() {
		return adminActivitiesReport;
	}
	
	public WebElement getAutoPaymentManagersReport() {
		return Page.driver.findElement(autoPaymentManagersReport);
	}
	
	public By byAutoPaymentManagersReport() {
		return autoPaymentManagersReport;
	}
	
	public WebElement getBatchReprot() {
		return Page.driver.findElement(batchReprot);
	}
	
	public By byBatchReprot() {
		return batchReprot;
	}
	
	public WebElement getJobsStatusReport() {
		return Page.driver.findElement(jobsStatusReport);
	}
	
	public By byJobsStatusReport() {
		return jobsStatusReport;
	}
	
	public WebElement getOsgActivitiesReport() {
		return Page.driver.findElement(osgActivitiesReport);
	}
	
	public By byOsgActivitiesReport() {
		return osgActivitiesReport;
	}
	
	public WebElement getPaymentPlansReport() {
		return Page.driver.findElement(paymentPlansReport);
	}
	
	public By byPaymentPlansReport() {
		return paymentPlansReport;
	}
	
	public WebElement getPaymentReport() {
		return Page.driver.findElement(paymentReport);
	}
	
	public By byPaymentReport() {
		return paymentReport;
	}
	
	public WebElement getRegisteredUsersReport() {
		return Page.driver.findElement(registeredUsersReport);
	}
	
	public By byRegisteredUsersReport() {
		return registeredUsersReport;
	}
	
	public WebElement getReport() {
		return Page.driver.findElement(report);
	}
	
	public By byReport() {
		return report;
	}
	
	public WebElement getReturnReport() {
		return Page.driver.findElement(returnReport);
	}
	
	public By byReturnReport() {
		return returnReport;
	}
	
	public WebElement getScheduledPaymentsReport() {
		return Page.driver.findElement(scheduledPaymentsReport);
	}
	
	public By byScheduledPaymentsReport() {
		return scheduledPaymentsReport;
	}
	
	public WebElement getTransactionReport() {
		return Page.driver.findElement(transactionReport);
	}
	
	public By byTransactionReport() {
		return transactionReport;
	}
	
	public WebElement getCustomerOverViewReport() {
		return Page.driver.findElement(customerOverViewReport);
	}
	
	public By byCustomerOverViewReport() {
		return customerOverViewReport;
	}
	
	public WebElement getManageUsers() {
		return Page.driver.findElement(manageUsers);
	}
	
	public By byManageUsers() {
		return manageUsers;
	}
	
	public WebElement getManageRoles() {
		return Page.driver.findElement(manageRoles);
	}
	
	public By byManageRoles() {
		return manageRoles;
	}
	
	public WebElement getClientDetails() {
		return Page.driver.findElement(clientDetails);
	}
	
	public By byClientdetails() {
		return clientDetails;
	}
	public WebElement getClientSetUp() {
		return Page.driver.findElement(clientSetUp);
	}
	
	public By byClientSetUp() {
		return clientSetUp;
	}
	public WebElement getBillingHierarchySetUp() {
		return Page.driver.findElement(billingHierarchySetUp);
	}
	
	public By byBillingHierarchySetUp() {
		return billingHierarchySetUp;
	}
	public WebElement getConvenienceFeeSetUp() {
		return Page.driver.findElement(convenienceFeeSetUp);
	}
	
	public By byConvenienceFeeSetUp() {
		return convenienceFeeSetUp;
	}
	public WebElement getBatchSchedule() {
		return Page.driver.findElement(batchSchedule);
	}
	
	public By byBatchSchedule() {
		return batchSchedule;
	}
	public WebElement getBankHolydays() {
		return Page.driver.findElement(bankHolydays);
	}
	
	public By byBankHolydays() {
		return bankHolydays;
	}
	public WebElement getOSGGatewaySetUp() {
		return Page.driver.findElement(OSGGatewaySetUp);
	}
	
	public By byOSGGatewaySetUp() {
		return OSGGatewaySetUp;
	}
	public WebElement getPrograms() {
		return Page.driver.findElement(programs);
	}
	
	public By byPrograms() {
		return programs;
	}
	public WebElement getGroups() {
		return Page.driver.findElement(groups);
	}
	
	public By byGroups() {
		return groups;
	}
	public WebElement getFileViewerUtility() {
		return Page.driver.findElement(fileViewerUtility);
	}
	
	public By byFileViewerUtility() {
		return fileViewerUtility;
	}
}
