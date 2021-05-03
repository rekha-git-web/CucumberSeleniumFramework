package StepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.*;

import java.awt.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import PageObjects.LocatorContainers;


public class TestSteps extends BasePage {

	  //WebDriver driver = null;
	LocatorContainers _lContainers = new LocatorContainers();

    @Given("^A user navigates to HomePage \"([^\"]*)\"$")
    public void aUserNavigatesToHomePage(String url) {
        driver.get(url);
    System.out.println("Navigate to: " + url);
    } 
    
    @Then("I login using {string} {string}")
    public void i_login_using(String UserName, String Password)throws InterruptedException {
       
    	_lContainers.BaseContainer(driver).GetFieldByPlaceholderName("Username").sendKeys(UserName);
    	_lContainers.BaseContainer(driver).GetFieldByPlaceholderName("Password").sendKeys(Password);
    	_lContainers.BaseContainer(driver).GetButtonByName("Login").click();
    	
    	_lContainers.FormContainer(driver, "CustomerSearch").GetSpanByClassName("close").click();
    	_lContainers.FormContainer(driver, "CustomerSearch").GetIconByName("Tasks").click();
    	
    	Thread.sleep(2000);
    	_lContainers.FormContainer(driver, "CustomerSearch").GetLinkSpanByName("Add New Account").click();
    	
    }
    
    @Then("submit the data")
    public void submit_the_data(DataTable dataTable) {
    	 
    	 java.util.List<Map<String,String>> rows = dataTable.asMaps(String.class, String.class);
    	 
    	 for (Map<String, String> stepData : rows) {
    		 System.out.println("data " + stepData.get("FormName"));
    		 System.out.println("_______");
    		 _lContainers.FormContainer(driver, stepData.get("FormName")).GetFieldByLabel(stepData.get("FieldName")).sendKeys("Uma");
    		 
    	    }
    	
    	 
    	  
    	  
    }
}
