package Academy;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

//Using Inheritance concept extends base 
public class validateTitle extends base {

	private static Logger Log = LogManager.getLogger(base.class.getName());

	
	@BeforeTest
	
	public void initializa() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
		
	}
	
	@Test
	
	
	public void basePageNavigation() throws IOException {
		

		
		
		//Inheritance is one
		//Creating object to that class and invoke methods of it
		
		LandingPage l = new LandingPage(driver);
		l.getTitle().getText();
		
		//Compare the text from browser with actual text		
		AssertJUnit.assertEquals(l.getTitle().getText(), "FEATURED COURSES");

	
		Log.info("Featured Courses is there");
		
		
	}
	
	
	@AfterTest
	
	public void tearDown() throws InterruptedException {
		driver.close();
		
		driver=null;

	}

	
}
