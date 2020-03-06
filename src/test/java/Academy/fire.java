package Academy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class fire {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String os = System.getProperty("os.name").toLowerCase();

		System.setProperty("webdriver.gecko,driver",System.getProperty("user.dir")+"/geckodriver");
		WebDriver driver =new FirefoxDriver();
		
		driver.get("https://www.rapidtables.com/code/linux/mv.html");
		
	}

}
