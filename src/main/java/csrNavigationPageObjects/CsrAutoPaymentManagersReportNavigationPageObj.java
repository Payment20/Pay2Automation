package csrNavigationPageObjects;

/**
 * navigation page object 
 * 
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pagebase.Page;

public class CsrAutoPaymentManagersReportNavigationPageObj extends Page{
	private By pageTitle = By.xpath("//*[@id=\"CsrBody\"]/div[4]/div/div/div[1]/div/div/div/ol/li/a");
	private By autoPaymentManagersReport =By.xpath("") ;
	
	
	public WebElement getPageTitle() {
		return Page.driver.findElement(pageTitle);
	}
	
	public By byPageTitle() {
		return pageTitle;
	}
	public WebElement getAutoPaymentManagersReport() {
		return Page.driver.findElement(autoPaymentManagersReport);
	}
	
	public By beAutoPaymentManagersReport() {
		return autoPaymentManagersReport;
	}
	
	
	
	
	
}
