package csrNavigationPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pagebase.Page;
/**
 * 
 * @author milou.rene
 *version 1.0
 */
public class CsrReportNavigationPageObj extends Page{

	private By pageTitle = By.xpath("/html/body/table/tbody/tr[7]/td[2]");
	private By report =By.xpath("") ;
	

	
	public WebElement getPageTitle() {
		return Page.driver.findElement(pageTitle);
	}
	
	public By byPageTitle() {
		return pageTitle;
	}
	
	
	public WebElement getReport() {
		return Page.driver.findElement(report);
	}
	
	public By byReport() {
		return report;
	}
}
