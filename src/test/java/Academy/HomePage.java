package Academy;

import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

//Using Inheritance concept extends base 
public class HomePage extends base {

	private static Logger Log = LogManager.getLogger(base.class.getName());

	
	@BeforeTest
	
	public void initializa() throws IOException {
		
		driver = initializeDriver();
		Log.info("Driver initialized");

		
	}
	
	@Test(dataProvider="getData")
	
	
	public void basePageNavigation(String username, String password, String text) throws IOException {
		driver.get(prop.getProperty("url"));
		Log.info("Navigated to HomePage");
		
		//Inheritance is one
		//Creating object to that class and invoke methods of it
		
		LandingPage l = new LandingPage(driver);
		
		
		l.getLogin();
		l.getLogin().click();
		
		LoginPage lp = new LoginPage(driver);
		
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
		Log.info("The user is"+" "+text);

	}
	
	
	@DataProvider
	public Object[][] getData() {
		
		//row stands for how many different data types test shuld run
		//coloumn stands for how many values per each test
		
		Object[][] data = new Object[2][3];
		
		//0th row
		data [0][0] = "nonrestricteduser@qa.com";
		data [0][1] = "123456";
		data [0][2] = "Restricted User";
		
		//1th
		data [1][0] = "restricteduser@qa.com";
		data [1][1] = "456789";
		data [1][2] = "Non Restricted User";

		return data;
		

		
	}
	
    @AfterTest
	
	public void tearDown() throws InterruptedException {

    	driver.close();
		driver=null;

		
	}
}
