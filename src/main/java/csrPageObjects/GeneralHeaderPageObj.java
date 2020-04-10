package csrPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pagebase.Page;

/**
 * @author OSG QA Automation Team
 * @version 1.0
 */
public class GeneralHeaderPageObj extends Page{
	
	private By pageTitle = By.xpath("/html/body/table/tbody/tr[7]/td[2]");
	private By report =By.xpath("") ;
	private By support = By.xpath("");
	private By users = By.xpath("");
	private By setup = By.xpath("");
	private By clickToShadow = By.xpath("");
	private By star = By.xpath("");
	private By search = By.xpath("");
	private By osgLogo = By.xpath("");
	 
	// identifying the WebElements
	public WebElement getPageTitle() {
		return Page.driver.findElement(report);
	}
	
	public By byPageTitle() {
		return pageTitle;
	}
	
	
	public WebElement getReport() {
		return Page.driver.findElement(pageTitle);
	}
	
	public By byReport() {
		return report;
	}
	
	public WebElement getSupport() {
		return Page.driver.findElement(support);
	}
	
	public By bySupport() {
		return support;
	}
	
	public WebElement getUsers() {
		return Page.driver.findElement(users);
	}
	
	public By byUsers() {
		return users;
	}
	
	public WebElement getSetup() {
		return Page.driver.findElement(setup);
	}
	
	public By bySetup() {
		return setup;
	}
	
	public WebElement getClickToShadow() {
		return Page.driver.findElement(clickToShadow);
	}
	
	public By byClickToShadow() {
		return clickToShadow;
	}
	
	public WebElement getStar() {
		return Page.driver.findElement(star);
	}
	
	public By byStar() {
		return star;
	}
	
	public WebElement getSearch() {
		return Page.driver.findElement(search);
	}
	
	public By bySearch() {
		return search;
	}
	
	public WebElement getOsgLogo() {
		return Page.driver.findElement(osgLogo);
	}
	
	public By byOsgLogo() {
		return osgLogo;
	}

}
