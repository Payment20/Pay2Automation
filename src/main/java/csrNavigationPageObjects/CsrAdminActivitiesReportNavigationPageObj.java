package csrNavigationPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pagebase.Page;
/**
 * 
 * @author milou.rene
 *version 1.0
 */
public class CsrAdminActivitiesReportNavigationPageObj extends Page{
	
	private By pageTitle = By.xpath("//*[@id=\"CsrBody\"]/div[4]/div/div/div[1]/div/div/div/ol/li/a");
	private By adminActivitiesReport =By.xpath("") ;
	private By adminActivitiesReportPaginationTable = By.xpath("");
	
	public WebElement getPageTitle() {
		return Page.driver.findElement(pageTitle);
	}
	
	public By byPageTitle() {
		return pageTitle;
	}
	
	public WebElement getAdminActivitiesReport() {
		return Page.driver.findElement(adminActivitiesReport);
	}
	
	public By byAdminActivitiesReport() {
		return adminActivitiesReport;
	}
	
	public WebElement getAdminActivitiesReportPaginationTable() {
		return Page.driver.findElement(adminActivitiesReportPaginationTable);
	}
	
	public By byAdminActivitiesReportPaginationTable() {
		return adminActivitiesReportPaginationTable;
	}

}
