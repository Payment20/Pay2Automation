package csrNavigationPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pagebase.Page;

public class CsrSetupNavigationPageObj extends Page{
	
	private By pageTitle = By.xpath("//*[@id=\\\"CsrBody\\\"]/div[4]/div/div/div[1]/div/div/div/ol/li/a");
	private By setUp  =By.xpath("") ;
	
	
	public WebElement getPageTitle() {
		return Page.driver.findElement(pageTitle);
	}
	
	public By byPageTitle() {
		return pageTitle;
	}
	
	public WebElement getSetUp() {
		return Page.driver.findElement(setUp);
	}
	
	public By bySetUp() {
		return setUp;
	}

}
