package csrPaginationFunctionPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pagebase.Page;

public class CsrPaginationFunctionPage extends Page{
/**
 * @author milou.rene
 * @Version 1.0
 * this class validates pagination right pull and left pull in all Pages 
 */
	
	public void paginationPagesPullRight(WebElement pullRight) {
		 WebElement toPullRight = pullRight;
		 String nextButton = driver.findElement(By.id("toPullRight")).getAttribute("class");
		 while(!nextButton.contains("disabled"))
		 {
			driver.findElement(By.id("toPullRight")).click();
		 }
	}
	

	public void paginationPagesPullLeft(WebElement pullLeft) {
		WebElement toPullLeft = pullLeft;
		String previousButton = driver.findElement(By.id("toPullLeft")).getAttribute("class");
		 while(!previousButton.contains("disabled"))
		 {
		  	driver.findElement(By.id("toPullLeft")).click();
		 }
	}
	
	
}
