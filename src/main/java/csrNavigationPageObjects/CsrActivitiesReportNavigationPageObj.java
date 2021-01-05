package csrNavigationPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pagebase.Page;

/**
 * 
 * @author milou.rene
 * version 1.0
 */
public class CsrActivitiesReportNavigationPageObj extends Page{
	
	private By pageTitle = By.xpath("//*[@id=\"CsrBody\"]/div[4]/div/div/div[1]/div/div/div/ol/li/a");
	 
	private By csrActivitiesReport =By.xpath("") ;
	private By csrActivityReportPaginationTable = By.xpath("");
	
	public WebElement getpageTitle() {
		return Page.driver.findElement(pageTitle);
	}
	
	public By byPageTitle() {
		return pageTitle;
	}

	public WebElement getcsrActivitiesReport() {
		return Page.driver.findElement(csrActivitiesReport);
	}
	
	public By bycsrActivitiesReport() {
		return csrActivitiesReport;
	}
	
	public WebElement getCsrActivityReportPaginationTable() {
		return Page.driver.findElement(csrActivityReportPaginationTable);
	}
	
	public By byCsrActivityReportPaginationTable() {
		return csrActivityReportPaginationTable;
	}
}
