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
	
	
	//get and set WebElement 
	
	public WebElement getCsrReportHover() {
		return Page.driver.findElement(csrReportHover);
	}
	
	public By byCsrReportHovert() {
		return csrReportHover;
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
}
