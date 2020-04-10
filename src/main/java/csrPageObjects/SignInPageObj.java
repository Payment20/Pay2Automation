package csrPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pagebase.Page;

/**
 * @author OSG QA Automation Team
 * @version 1.0
 */
public class SignInPageObj extends Page{ 
 
	private By pageTitle = By.xpath("/html/body/table/tbody/tr[7]/td[2]");
	private By signUpLink =By.xpath("") ;
	private By userName = By.id("loginFormInputEmail");
	private By password = By.id("txtPassword");
	private By forgotPasswordLink = By.id("");
	private By forgotUserNameLink = By.xpath("");
	private By signInButton = By.id("btnlogin");
	private By eyeSlashIcon = By.xpath("");
	private By invalidUseralert = By.xpath("");
	private By logOutIcon = By.xpath(" ");
	private By logOutPopUp = By.xpath("");

	
	// identifying the WebElements of SignIn Page
	public WebElement getPageTitle() {
		return Page.driver.findElement(pageTitle);
	}
	
	public By byPageTitle() {
		return pageTitle;
	}
	
	
	public WebElement getSignUpLink() {
		return Page.driver.findElement(signUpLink);
	}
	
	public By bySignUpLink() {
		return signUpLink;
	}
	
	
	public WebElement getUserName() {
		return Page.driver.findElement(userName);
	}
	
	public By byUserName() {
		return userName;
	}
	
	public WebElement getPassword() {
		return Page.driver.findElement(password);
	}
	
	public By byPassword() {
		return password;
	}
	
	public WebElement getForgotPasswordLink() {
		return Page.driver.findElement(forgotPasswordLink);
	}
	
	public By byForgotPasswordLink() {
		return forgotPasswordLink;
	}
	
	public WebElement getForgotUserNameLink() {
		return Page.driver.findElement(forgotUserNameLink);
	}
	
	public By byForgotUserNameLink() {
		return forgotUserNameLink;
	}
	
	public WebElement getSignInButton() {
		return Page.driver.findElement(signInButton);
	}
	
	public By bySignInButton() {
		
		return userName;
		 
	}
	
	public WebElement getEyeSlashIcon() {
		return Page.driver.findElement(eyeSlashIcon);
	}
	
	public By byEyeSlashIcon() {
		return eyeSlashIcon;
	}
	
public WebElement getinvalidUseralert() {
		
		return Page.driver.findElement(invalidUseralert);
	}
	
    public By byInvalidUseralert() {
		
		return invalidUseralert;
	}
    
    
    public WebElement getLogOutIcon() {
		return Page.driver.findElement(logOutIcon);
	}
    
    public By byLogOutIcon(){
		return logOutIcon;
	}
    

	public WebElement getLogOutPopUp() {
		return Page.driver.findElement(logOutPopUp);
	}
	
	public By byLogOutPopUp(){
		return logOutPopUp;
	}	 
}
