package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	
	public WebDriver driver;
	
 By signin = By.cssSelector("a[href*=\"sign_in\"]");
 
 By title = By.xpath("//section[@id='content']/div/div/h2");

 By navbar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");

 By newscross = By.xpath("//*[@id=\"homepage\"]/div[4]/div[2]/div/div/div/span/div/div[6]/div/div/button");	
 
 By popup = By.xpath("//button[text()='NO THANKS']");
	
 
 
 public LandingPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	 
	 this.driver=driver;
	 
}







public WebElement getLogin() {
	 
	 
	 return driver.findElement(signin);
	 
 }


public WebElement getTitle() {
	 
	 
	 return driver.findElement(title);
	 
}
	
public WebElement getNavigationMenu() {
	 
	 
	 return (WebElement) driver.findElement(navbar);
	 
}
	
public WebElement getPopup() {
	 
	 
	 return (WebElement) driver.findElement(popup);
	 
}

public List <WebElement> getPopupSize() {
	 
	 
	 return  driver.findElements(popup);
	 
}
	
}
