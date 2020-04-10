package csrNavigationPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pagebase.Page;
/**
 * 
 * @author milou.rene
 *version 1.0
 */
public class CsrScheduledPaymentsReportNavigationPageObj extends Page{
	
	private By pageTitle = By.xpath("//*[@id=\"CsrBody\"]/div[4]/div/div/div[1]/div/div/div/ol/li/a");
	private By scheduledPaymentsReport =By.xpath("") ;
	private By scheduledPaymentsPaginationPullRight = By.xpath("//*[@id=\"datatable_paginate\"]/ul/li[7]");
	private By scheduledPaymentsPaginationPullLeft = By.xpath("//*[@id=\"datatable_paginate\"]/ul/li[1]");
	
	public WebElement getPageTitle() {
		return Page.driver.findElement(pageTitle);
	}
	
	public By byPageTitle() {
		return pageTitle;
	}
	
	public WebElement getScheduledPaymentsReport() {
		return Page.driver.findElement(scheduledPaymentsReport);
	}
	
	public By byScheduledPaymentsReport() {
		return scheduledPaymentsReport;
	}
	
	public WebElement getScheduledPaymentsPaginationPullRight() {
		return Page.driver.findElement(scheduledPaymentsPaginationPullRight);
	}
	
	public By byScheduledPaymentsPaginationPullRight() {
		return scheduledPaymentsPaginationPullRight;
	}
	
	public WebElement getScheduledPaymentsPaginationPullLeft() {
		return Page.driver.findElement(scheduledPaymentsPaginationPullLeft);
	}
	
	public By scheduledPaymentsPaginationPullLeft() {
		return scheduledPaymentsPaginationPullLeft;
	}


}
