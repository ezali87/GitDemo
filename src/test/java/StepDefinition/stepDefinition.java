package StepDefinition;


import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.junit.runner.RunWith;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.portalHomePage;
import resources.base;

@RunWith(Cucumber.class)
public class stepDefinition extends base {

    @Given("^Initialize the ChromeBrowser$")
    public void initialize_the_chromebrowser() throws Throwable {
    	
    	driver = initializeDriver();
        
    }

//    @When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
//    public void user_enters_something_and_something_and_logs_in(String strArg1, String strArg2) throws Throwable {
//    	
//LoginPage lp = new LoginPage(driver);
//		
//		lp.getEmail().sendKeys(strArg1);
//		lp.getPassword().sendKeys(strArg2);
//		lp.getLogin().click();
//       
//    }
    

    @When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {

    	LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
    
    }

    @Then("^Verify that is user is logged in \"([^\"]*)\"$")
    public void verify_that_is_user_is_logged_in_something(String strArg1) throws Throwable {
        
    	System.out.println(strArg1);
    	
    	portalHomePage p = new portalHomePage(driver);
   // 	Assert.assertFalse(p.getSearchbox().isDisplayed());
    	
    	
    }

    @And("^Navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
        
             driver.get(strArg1);
    }

    @And("^Clicking on the Login button to Land on Secure SignIn page$")
    public void clicking_on_the_login_button_to_land_on_secure_signin_page() throws Throwable {
       
        LandingPage l = new LandingPage(driver);		
		l.getLogin();
		if (l.getPopupSize().size()>0) {
			l.getPopup().click();
		}
		l.getLogin().click();
    	
    }
    
    @And("close browsers")
    public void close_browsers() {
        // Write code here that turns the phrase above into concrete actions
    	driver.quit();
    	
    }

}