package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portalHomePage {

	
	public WebDriver driver;
	
 By searchbox = By.name("query");
 
 

 public portalHomePage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	 
	 this.driver=driver;
	 
}
 
 

public WebElement getSearchbox() {
	 
	 
	 return driver.findElement(searchbox);
	 
 }


}
