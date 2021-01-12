package csrPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pagebase.Page;

/**
 * @author milou.rene
 * @author OSG QA Automation Team
 * @version 1.0
 */
public class GeneralFilterPageObj extends Page{

	private By pageTitle = By.xpath("//*[@id=\"CsrBody\"]/div[4]/div/div/div[1]/div/div/div/ol/li/a");
	private By quickSearch =By.xpath("//*[@id=\"CsrBody\"]/div[4]/div/div/div[2]/div/div[1]/div/div[2]/div/div[1]/div[1]/label[1]") ;
	private By searchAll = By.xpath("//*[@id=\"CsrBody\"]/div[4]/div/div/div[2]/div/div[1]/div/div[2]/div/div[1]/div[1]/label[2]");
	private By accountNumber = By.xpath("//*[@id=\"quickSearchOptions\"]/label[1]");
	private By customerLastName = By.xpath("//*[@id=\"quickSearchOptions\"]/label[2]");
	private By keyword = By.xpath("//*[@id=\"txtSearch\"]");  
	private By clearFilter = By.xpath("//*[@id=\"btnClear\"]");
	private By search = By.xpath("//*[@id=\"btnCustomerSearch\"]");
	private By addCustomer = By.xpath("//*[@id=\"CsrBody\"]/div[4]/div/div/div[2]/div/div[1]/div/div[2]/div/div[3]/div/div/a");
	 

	
	// identifying the WebElements
	public WebElement getPageTitle() {
		return Page.driver.findElement(pageTitle);
	}
	
	public By byPageTitle() {
		return pageTitle;
	}
	
	
	public WebElement getQuickSearch() {
		return Page.driver.findElement(quickSearch);
	}
	
	public By byQuickSearch() {
		return quickSearch;
	}
	
	public WebElement getSearchAll() {
		return Page.driver.findElement(searchAll);
	}
	
	public By bySearchAll() {
		return searchAll;
	}
	
	public WebElement getAccountNumber() {
		return Page.driver.findElement(accountNumber);
	}
	
	public By byAccountNumber() {
		return accountNumber;
	}
	
	public WebElement getCustomerLastName() {
		return Page.driver.findElement(customerLastName);
	}
	
	public By byCustomerLastName() {
		return customerLastName;
	}
	
	public WebElement getKeyword() {
		return Page.driver.findElement(keyword);
	}
	
	public By byKeyword() {
		return keyword;
	}
	
	public WebElement getClearFilter() {
		return Page.driver.findElement(clearFilter);
	}
	
	public By byClearFilter() {
		return clearFilter;
	}
	
	public WebElement getSearch() {
		return Page.driver.findElement(search);
	}
	
	public By bySearch() {
		return search;
	}
	
	public WebElement getAddCustomer() {
		return Page.driver.findElement(addCustomer);
	}
	
	public By byAddCustomer() {
		return addCustomer;
	}
}
