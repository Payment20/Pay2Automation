package csrNavigationPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pagebase.Page;

/**
 * 
 * @author milou.rene
 *version 1.0
 */
public class CsrJobsStatusReportNavigationPageObj extends Page{

	private By pageTitle = By.xpath("//*[@id=\"CsrBody\"]/div[4]/div/div/div[1]/div/div/div/ol/li/a");
	private By jobsStatusReport =By.xpath("") ;
	
	
	public WebElement getPageTitle() {
		return Page.driver.findElement(pageTitle);
	}
	
	public By byPageTitle() {
		return pageTitle;
	}
	
	
	public WebElement getjobsStatusReport() {
		return Page.driver.findElement(jobsStatusReport);
	}
	
	public By byjobsStatusReport() {
		return jobsStatusReport;
	}
}
