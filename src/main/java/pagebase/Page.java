package pagebase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import automationPayment20.ExtentManager;
import automationPayment20.RevopayManageDB;
import automationPayment20.RevopayManageFunctions;

/**
 *  @author milou.rene
 *  @version 1.0
 */
public class Page {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static String browser;
	public static WebDriverWait wait;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public ExtentReports report = ExtentManager.getInstance();
	public static ExtentTest test;
	public static RevopayManageDB connectionDB;
	public static RevopayManageFunctions functionsDB;
	public static Date d = new Date();
	public static ArrayList<String> emailMessage = new ArrayList<String>();
	public static HashMap<String, String> settingsMap = new HashMap<String, String>();

	public static int totalTestExecuted = 0;
	public static int totalTestFailed = 0;
	public static int totalTestPassed = 0;
	public static int totalSuitsExecuted = 0;

	public static boolean isActiveCfeeCredentials = false;
	public static String categoryAmount;

	public static double convenience_fee = 0;
	public static double convenience_fee_float = 0;
	public static double convenience_fee_drp = 0;
	public static double convenience_fee_float_drp = 0;

	public Page() {

		if (driver == null) {

			// To load the file config with the browser.

			try {

				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				log.debug("Config file not found !!!");
				e.printStackTrace();
			}
			try {
				config.load(fis);

				System.setProperty("current.date", d.toString().replace(":", "_").replace(" ", "_"));

				PropertyConfigurator.configure((".\\src\\test\\resources\\properties\\log4j.properties"));

				log.debug("Config file loaded !!!");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.debug("Config file not loaded !!!");
				e.printStackTrace();
			}

			browser = config.getProperty("browser");/** Reading the browser from config file */
			log.debug("Working with " + browser);

			if (browser.equals("firefox")) {

				// System.setProperty("webdriver.gecko.driver", "gecko.exe");
				driver = new FirefoxDriver();

			} else if (browser.equals("chrome")) {

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");

				// Chrome options that can be useful.

				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");

				driver = new ChromeDriver(options);

			} else if (browser.equals("ie")) {

				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				// driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,"0"));
			}

			log.debug("Loading the Test Environment from config file");

			String environment = config.getProperty("environment");
			log.debug("Test Environment: " + environment);

			String application = config.getProperty("application");
			log.debug("Application: " + application);

			String testsiteurl = "";
			
		// CUSTOMER LOGIC 
			if (application.equalsIgnoreCase("payment20csr")) {

				if (environment.equals("qacust")) {

					testsiteurl = config.getProperty("qacusturl");

				} else if (environment.equals("e2ecust")) {

					testsiteurl = config.getProperty("e2ecusturl");

				} else if (environment.equals("prodcust")) {

					testsiteurl = config.getProperty("prodcusturl");
				
		// CSR LOGIC 			
				}else if (environment.equals("prodcsr")) {

					testsiteurl = config.getProperty("prodcsrurl");
					
				}else if (environment.equals("qacsr")) {

						testsiteurl = config.getProperty("qacsrurl");
						
				}else if (environment.equals("e2ecsr")) {

					testsiteurl = config.getProperty("e2ecsrurl");
					
				} else {

					testsiteurl = config.getProperty("qacsrurl");
				}
			}
			
		// End of logic for payment 20 customer and csr		
			else {

				if (environment.equals("e2ecust")) {

					testsiteurl = config.getProperty("e2ecusturl");

				} else if (environment.equals("prodcust")) {

					testsiteurl = config.getProperty("prodcusturl");

				} else if (environment.equals("qacust")) {

					testsiteurl = config.getProperty("qacusturl");

				} else {

					testsiteurl = config.getProperty("qacusturl");

				}
			}

			driver.get(testsiteurl);

			log.debug("Navigating to: " + testsiteurl);

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// JavascriptExecutor jse = (JavascriptExecutor)driver;
			// jse.executeScript("document.body.style.zoom = '75%';");

		//	menu = new LatAndTopMenu();
			connectionDB = new RevopayManageDB();
			functionsDB = new RevopayManageFunctions();
			log.debug("Page Objects loaded");
			wait = new WebDriverWait(driver, 10);
			//validateInfoQP = new ValidateInfoQP();
		}

	}

	public static void quit() {

		d = new Date();
		emailMessage.add(
				"Test Completed: " + d.toString() + "<br>----------------------------------------------------<br>");
		driver.quit();
		log.debug("Driver quit");

	}

	public static void restartLogin() {

		driver.get(config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void restartQP() {

		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	// Common Keywords to be implemented

	public static void click(WebElement locator) {

		log.debug("Clicking on an Element : " + locator.getText());
		test.log(LogStatus.INFO, "Clicking on : " + locator.getText());
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click()", locator);
		//locator.click();

	}

	public static void clickSelect(WebElement locator) {

		log.debug("Clicking on Element : " + locator.getText());
		test.log(LogStatus.INFO, "Clicking on Element: " + locator.getText());
		// JavascriptExecutor ex=(JavascriptExecutor)driver;
		// ex.executeScript("arguments[0].click()",locator);
		locator.click();

	}

	public static void type(WebElement locator, String field, String value) {

		locator.clear();
		log.debug("Typing in field: " + field + " the value: " + value);
		test.log(LogStatus.INFO, "Typing in field: " + field + " the value: " + value);
		locator.sendKeys(value);

	}

	// Select using MouseOver and Action API for Selenium.(doesnt work)

	public void hoverOnElement(WebElement ElementToHover, WebElement ElementToClick) {

		Actions actions = new Actions(driver );

		actions.moveToElement(ElementToHover).build().perform();
		//ElementToClick.click();

		 
		// System.out.println("Done Mouse hover on the select from Menu");

	}
	
	// to Hover and click on an Element 
	public  void hoverAndClickOnElement( WebElement ElementToHover, WebElement ElementToClick ) {
		Actions action = new Actions(driver);
		action.moveToElement(ElementToHover).click(ElementToClick).build().perform();
		//ElementToClick.click();
	}

	
	public void select(WebElement dropdown, String value) {

		Select select = new Select(dropdown);

		/*
		 * List<WebElement> options = select.getOptions();
		 * 
		 * System.out.println(options.size());
		 * 
		 * for (int i = 0; i < options.size(); i++) {
		 * 
		 * System.out.println( "options " + options.get(i).getText()); }
		 */

		select.selectByVisibleText(value);

		log.debug("Selecting from dropdown value as : " + value);
		test.log(LogStatus.INFO, "Selecting from dropdown value as " + value);

	}

	// Dayana:tratando de hacer el mismo select de arriba. NO funciona, the same
	// result
	public void select(By dropdown, WebElement selectbutton, By selectSearch, String value)
			throws InterruptedException {

		// System.out.println( "Estoy en el select...");
		WebDriverWait wait = new WebDriverWait(driver, 300);
		// System.out.println( "Despues del Wait...");
		WebElement triggerDropDown = selectbutton;
		triggerDropDown.click();

		// selectbutton.click();

		// System.out.println( "ya di click y se desplego el select...");
		WebElement selectElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdown));
		// System.out.println( "Ya cree el selectElement WebElement...");

		Select select = new Select(selectElement);
		// System.out.println( "ya cree el otro select...");
		select.selectByVisibleText("California");

		// wait.until( ExpectedConditions.presenceOfElementLocated(select));

		log.debug("Selecting from dropdown value as : " + value);
		test.log(LogStatus.INFO, "Selecting from dropdown value as " + value);

	}

	// Return the options of the selects to get the attributes(util para obtener el
	// payment type.)
	public List<WebElement> selectOptions(WebElement dropdown) throws InterruptedException {

		Select select = new Select(dropdown);

		List<WebElement> options = select.getOptions();

		// System.out.println(options.size());

		/*
		 * for(int i = 0; i< options.size();i++) {
		 * 
		 * System.out.println( "options " + options.get(i).getAttribute("data-method"));
		 * }
		 */

		log.debug("Selecting the options from the dropdown");
		test.log(LogStatus.INFO, "Selecting the options from the dropdown");

		return options;

	}

	// Finding a web element by the locator to see if it is present.
	public boolean isElementPresent(By by) {
		String element = "NO ELEMENT FOUND";

		try {
			if (driver.findElement(by) != null)
				element = driver.findElement(by).getText();

			driver.findElement(by);
			log.debug("Web Element found: " + element);
			return true;

		} catch (NoSuchElementException e) {
			log.debug("Web Element not found: " + element);
			return false;

		}

	}

	// Override method to compare the web element with a text to see if it is
	// present.
	public boolean isElementPresent(WebElement locator, String tagname) {

		String element = locator.getText();

		if (locator.getText().contains(tagname)) {

			log.debug("Web Element contain the text: " + element + " : " + tagname);
			return true;
		} else {

			log.debug("Web Element does not has the same text: " + element + " : " + tagname);
			return false;

		}

	}

	/*
	 * public static void verifyEquals(String expected, String actual) throws
	 * IOException {
	 * 
	 * try {
	 * 
	 * Assert.assertEquals(actual, expected);
	 * 
	 * } catch (Throwable t) {
	 * 
	 * Utilities.captureScreenshot(); // ReportNG Reporter.log("<br>" +
	 * "Verification failure : " + t.getMessage() + "<br>");
	 * Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName +
	 * "><img src=" + Utilities.screenshotName +
	 * " height=200 width=200></img></a>"); Reporter.log("<br>");
	 * Reporter.log("<br>"); // Extent Reports test.log(LogStatus.FAIL,
	 * " Verification failed with exception : " + t.getMessage());
	 * test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));
	 * 
	 * }
	 * 
	 * }
	 */

	/**
	 * Auxiliary Method. Implicit wait for driver
	 * <p>
	 * Set up a time to implicit wait for the driver
	 * </p>
	 * 
	 * @param Numeric value for time in milliseconds
	 * @author Yary.Perez
	 */
	public static WebDriverWait Wait(int time) {

		wait = new WebDriverWait(driver, time);
		return wait;

	}
	/*
	 * @author Milou Rene
	 *  wait function to load page 
	 */
	public class WaitUntilPagesLoad {

	    public void waitUntilPagesLoad(WebDriver driver) {
	        ExpectedCondition<Boolean> pageLoadCondition = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	                    }
	                };
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        wait.until(pageLoadCondition);
	    }
	}

	/**
	 * Auxiliary Method.
	 * <p>
	 * Opening Database connection
	 * </p>
	 * 
	 * @author Yary.Perez
	 */
	public static void openDBConnection() throws SQLException {

		connectionDB.openConnection();
	}

	/**
	 * Auxiliary Method.
	 * <p>
	 * Closing Database connection
	 * </p>
	 * 
	 * @author Yary.Perez
	 */
	public static void closeDBConnection() throws SQLException {

		connectionDB.closeConnection();
	}

	/**
	 * Functional Method. Restore the merchant credentials.
	 * <p>
	 * Method used to restore in the database the credentials used to test
	 * convenience fee for a payment with property id 13045222 to the correct
	 * property id 13045.
	 * </p>
	 * 
	 * @author Yary.Perez
	 * @throws SQLException
	 */
	public static void restoreCfeeCredentials() throws SQLException {

		if (isActiveCfeeCredentials) {
			System.out.println("entre a restoreCfeeCredentials");
			functionsDB.hideCfeeCredentials();
			functionsDB.restoreCredentials();
			isActiveCfeeCredentials = false;
			log.debug("Credentials restored after test payments with convenience fee.");
			test.log(LogStatus.INFO, "Credentials restored after test payments with convenience fee.");

		}

	}

	/**
	 * Auxiliary Method. Navigating to another application.
	 * <p>
	 * Opening a new explorer tab to navigate to any other application
	 * regarding the environment configuration.
	 * </p>
	 * 
	 * @author Yary.Perez
	 * @throws InterruptedException
	 */
	public static void openApplication(String application) throws InterruptedException {

		String environment = config.getProperty("environment");
		log.debug("Test Environment: " + environment);
		log.debug("Opening tab for Application: " + application);

		String testsiteurl = "";

		if (application.equalsIgnoreCase("ApName")) {

			if (environment.equals("qa")) {

				testsiteurl = config.getProperty("qaAppURL");

			} else if (environment.equals("pp")) {

				testsiteurl = config.getProperty("ppAppUrl");

			} else if (environment.equals("production")) {

				testsiteurl = config.getProperty("AppProductionURL");

			} else {

				testsiteurl = config.getProperty("qaAppURL");

			}

		} else {

			if (environment.equals("sandbox")) {

				testsiteurl = config.getProperty("sandboxAPurl");

			} else if (environment.equals("production")) {

				testsiteurl = config.getProperty("prodAPurl");

			} else if (environment.equals("secondsite")) {

				testsiteurl = config.getProperty("secondsiteAPurl");

			} else {

				testsiteurl = config.getProperty("qapAPurl");

			}
		}

		/*
		 * driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		 * ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 * driver.switchTo().window(tabs.get(1));
		 */
		/*
		 * driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		 * Thread.sleep(5000); ArrayList<String> tabs = new
		 * ArrayList<String>(driver.getWindowHandles());
		 * driver.switchTo().window(tabs.get(0));
		 * //driver.switchTo().window(tabs.get(1));
		 */

		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		driver.get(testsiteurl);
		log.debug("Navigating to: " + testsiteurl);
		Thread.sleep(1000);

	}

	/**
	 * Switch windows tabs.
	 * <p>
	 * Opening a new explorer tab.
	 * </p>
	 * 
	 * @author Yary.Perez
	 */
	public static void openAndSwitchTabs() {

		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		/*
		 * driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		 * ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		 * driver.switchTo().window(tabs.get(0));
		 */
	}

	/**
	 * Switch Tabs
	 * <p>
	 * Will Allow to switch Tabs between the application
	 * </p>
	 * 
	 * @param int tab: value of the tab you want to move on.
	 * @author Yary.Perez
	 */
	public static void switchTabs(int tab) throws InterruptedException {

		// ((JavascriptExecutor)driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tab));
		Thread.sleep(1000);
		/*
		 * driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		 * ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		 * driver.switchTo().window(tabs.get(0));
		 */
	}

	/**
	 * Method in test
	 * <p>
	 * </p>
	 * 
	 * @author Yary.Perez
	 */
	public void doLoginPage() {

		By username = By.xpath("//input[@id='username']");
		By password = By.xpath("//input[@id='password']");
		By loginbtn = By.xpath("//button[@class='btn btn-success btn-block']");

		Page.driver.findElement(username).sendKeys(config.getProperty("activeusername"));
		Page.driver.findElement(password).sendKeys(config.getProperty("activepass"));
		Page.driver.findElement(loginbtn).click();

		// type(Page.driver.findElement(username), "username",
		// config.getProperty("activeusername"));
		// type(Page.driver.findElement(password), "password",
		// config.getProperty("activepass"));
		// click(Page.driver.findElement(loginbtn));

	}
	
	//find customer last name
	public void customerLastName() {
		
		By keyword = By.id("txtSearch");
		//By lastName = By.xpath("//input[@id='username']");
		Page.driver.findElement(keyword).sendKeys(config.getProperty("customerLastName"));
		
	}
	// find customer account number
	public void customerAccountNumber() {
		//By accountNumber = By.xpath("//input[@id='username']");
		By keyword = By.id("txtSearch");
		Page.driver.findElement(keyword).sendKeys(config.getProperty("customerAccountNumber"));
		
	}

	/**
	 * Generate Cfee
	 * <p>
	 * Auxiliary Method. Generate a random value for cfee.
	 * </p>
	 * 
	 * @return Double cfee generated.
	 * @author Yary.Perez
	 */
	public double generateCfee() {

		double cfee = Math.random() * 2;
		String str = String.format("%1.2f", cfee);
		cfee = Double.valueOf(str.replace(",", "."));

		return cfee;
	}

	/**
	 * Generate Float Cfee
	 * 
	 * <p>
	 * Auxiliary Method. Generate a random value for float cfee.
	 * </p>
	 * 
	 * @return Double float cfee generated.
	 * @author Yary.Perez
	 */
	public double generateFloatCfee() {

		double cfee = (int) (Math.random() * 10 + 1);
		String str = String.format("%1.2f", cfee);
		double floatfee = Double.valueOf(str.replace(",", "."));

		return floatfee;
	}

	/**
	 * Is Checked Checkbox
	 * <p>
	 * Auxiliary Method. Check whether a checkbox is selected and return the status.
	 * </p>
	 * 
	 * @return True if the checkbox is selected, otherwise returns false.
	 * @author Yary.Perez
	 */
	public boolean isCheckedChckbx(WebElement element) {

		if (element.isSelected()) {

			log.debug("CheckBox is selected");
			test.log(LogStatus.INFO, "CheckBox is selected");
			return true;
		}

		else {

			log.debug("CheckBox: " + element.getText() + " is not selected");
			test.log(LogStatus.INFO, "CheckBox: " + element.getText() + " is not selected");
			return false;
		}
	}

	/**
	 * Auxiliary Method.
	 * <p>
	 * Method to add to the Settings Map the settings values modified in a test
	 * session.
	 * </p>
	 * 
	 * @author Yary.Perez
	 */
	public void addSettingsValue(String settingKey, String settingValue) {

		if (settingsMap.isEmpty()) {

			settingsMap.put(settingKey, settingValue);

		} else {

			if (settingsMap.containsKey(settingKey)) {

				settingsMap.replace(settingKey, settingValue);

			} else {

				settingsMap.put(settingKey, settingValue);
			}
		}

	}

	public void removeFromSettingsValue(String settingKey, String settingValue) {

		if (!settingsMap.isEmpty()) {

			if (settingsMap.containsKey(settingKey)) {

				String value = settingsMap.get(settingKey).toString();
				System.out.println("value: " + value);
				String newValue = "";

				int position = value.indexOf(settingValue);

				if (position != -1) {

					newValue = value.replace(settingValue, "");
					//newValue = value.substring(0,position) + value.substring(settingValue.length()+position);
					settingsMap.replace(settingKey, newValue);
					
				} 
			}

		}

	}

	public void concatenateSettingsValue(String settingKey, String settingValue) {

		if (settingsMap.isEmpty()) {

			settingsMap.put(settingKey, settingValue);

		} else {

			if (settingsMap.containsKey(settingKey)) {

				String value = settingsMap.get(settingKey).toString();
				settingValue += value;
				settingsMap.replace(settingKey, settingValue);

			} else {

				settingsMap.put(settingKey, settingValue);
			}
		}

	}

}
