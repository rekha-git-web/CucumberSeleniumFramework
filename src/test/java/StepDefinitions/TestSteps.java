package StepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Map;
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
    	
    	Thread.sleep(1000);
    	_lContainers.FormContainer(driver, "CustomerSearch").GetLinkSpanByName("Add New Account").click();
    	
    }
    
    @Then("submit the data")
    public void submit_the_data(DataTable dataTable) throws InterruptedException {
    	 
    	 java.util.List<Map<String,String>> rows = dataTable.asMaps(String.class, String.class);
    	 Thread.sleep(1000);
    	 for (Map<String, String> stepData : rows) {
    		 System.out.println("data " + stepData.get("FormName"));
    		 System.out.println("_______");
    		 _lContainers.FormContainer(driver, stepData.get("FormName")).GetFieldByLabel(stepData.get("FieldName")).sendKeys(stepData.get("Data"));
    		 
    	    }
    	
    	 Thread.sleep(2000); 	  
    }
    
    @Then("I verify finxact using the method {string} and path {string}")
    public void i_verify_finxact_using_the_method_and_path(String apiMethod, String path) {
    
    	System.out.println("_______RESPONSE DATA BEGIN______");
    	
    	String result =	FinxactAPIMethods.finxactGET(path);
    	System.out.println("_______####################RESPONSE DATA END #######################______");
    	
    	assertEquals("200", result , "response code is incorrect");
    }
    
}
