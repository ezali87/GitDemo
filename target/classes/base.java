package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class base {
	
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException, FileNotFoundException  {
		
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream (System.getProperty("user.dir")+"//src//main//java//resources//data.properties");
		
		
		prop.load(fis);
//		// mvn -Dbrowser=chrome
//
		String BrowserName = System.getProperty("browser");
		
//		String BrowserName = prop.getProperty("browser");
		System.out.println(BrowserName);
		
		if (BrowserName.contains("chrome")) {
			
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//main//java//resources//chromedriver");
			ChromeOptions options = new ChromeOptions();
			if (BrowserName.contains("headless")) {
			 options.addArguments("headless");
			}
			 driver= new ChromeDriver(options);

			
		}
		
		else	if (BrowserName.contains("firefox")) {
			
		
			String os = System.getProperty("os.name").toLowerCase();

			System.setProperty("webdriver.gecko,driver",System.getProperty("user.dir")+"/geckodriver");
			FirefoxOptions options = new FirefoxOptions();
			
			if (BrowserName.contains("headless")) {
				
			options.addArguments("headless");

			}

			 driver = new FirefoxDriver(options);
			
		}
	
		else	if (BrowserName == "safari") {
		

		
	}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
		
		
		
		
	}
	
	
	
public void getScreenshot(String result) throws IOException {
		
		// Take Screenshot
		File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		// now copy the screen shot to desired location using copy file method
		FileUtils.copyFile(file, new File("/Users/osamazafar/eclipse-workspace/"+result+"screen.jpg"));
	
	
		  
	}
	
}
