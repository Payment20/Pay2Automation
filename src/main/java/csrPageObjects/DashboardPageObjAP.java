package csrPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pagebase.Page;

/**
 * @author milou.rene
 * @Payment 2 Automation team 
 * @version 1.0
 */
public class DashboardPageObjAP extends Page {
	 
	private By pageTitle = By.xpath("/html/head/title");
		
	public WebElement getPageTitle() {
		
		return Page.driver.findElement(pageTitle);
	}

    public By byPageTitle() {
		
		return pageTitle;
	}

}
 