package csrNavigationPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pagebase.Page;

public class CsrGroupsPageObs extends Page{

	private By pageTitle = By.xpath("//*[@id=\"CsrBody\"]/div[4]/div/div/div[1]/div/div/div/ol/li/a");
	 
	private By usersNavigation  =By.xpath("") ;
	
	public WebElement getPageTitle() {
		return Page.driver.findElement(pageTitle);
	}
	
	public By byPageTitle() {
		return pageTitle;
	}
	
	public WebElement getUsersNavigation() {
		return Page.driver.findElement(usersNavigation);
	}
	
	public By byUsersNavigation() {
		return usersNavigation;
	}
}
