package StepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
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
    	
    	Thread.sleep(1000);

    }
    
    @Then("I enter into placeholder field {string} data {string}")
    public void i_enter_into_placeholder_field_data(String fieldName, String data) throws InterruptedException {
    	Thread.sleep(1000);
    	_lContainers.BaseContainer(driver).GetFieldByPlaceholderName(fieldName).sendKeys(data);
       
    }
    
    @Then("I click on {string} span on {string}")
    public void i_click_on_span_on(String spanName, String page) throws InterruptedException {

    	Thread.sleep(1000);
    	_lContainers.FormContainer(driver, page).GetSpanByClassName(spanName).click();
    }

    @Then("I click on {string} button on {string}")
    public void i_click_on_button_on(String buttonName, String page) throws InterruptedException {

    	Thread.sleep(1000);
    	_lContainers.FormContainer(driver, page).GetButtonByName(buttonName).click();
    }
    
    @Then("I click on icon {string} on {string}")
    public void i_click_on_icon_on(String iconName, String page) throws InterruptedException {

    	Thread.sleep(1000);
    	_lContainers.FormContainer(driver, page).GetIconByName(iconName).click();
    }

    @Then("I click on link {string} on {string}")
    public void i_click_on_link_on(String linkName , String page) throws InterruptedException {

    	Thread.sleep(1000);
    	_lContainers.FormContainer(driver, page).GetLinkSpanByName(linkName).click();
    }

    
    @Then("submit the data")
    public void submit_the_data(DataTable dataTable) throws InterruptedException {
    	 
    	 java.util.List<Map<String,String>> rows = dataTable.asMaps(String.class, String.class);
    	 Thread.sleep(1000);
    	 for (Map<String, String> stepData : rows) {
    		 System.out.println("data " + stepData.get("FormName"));
    		 System.out.println("_______");
    		 Thread.sleep(2000); 
    		 if(stepData.get("Data") == "click")
    		 {
    			 
    			 _lContainers.FormContainer(driver, stepData.get("FormName")).GetButtonByName(stepData.get("FieldName")).click();
    			 Thread.sleep(5000);  
    		 }
    		 
    		 else
    		 {
    		 _lContainers.FormContainer(driver, stepData.get("FormName")).GetFieldByLabel(stepData.get("FieldName")).sendKeys(stepData.get("Data"));
    		//_lContainers.FormContainer(driver, stepData.get("FormName")).GetFieldByPlaceholderName(stepData.get("FieldName")).sendKeys(stepData.get("Data"));
    		 }
    		 
    	    }
    	
    	 Thread.sleep(2000); 	  
    }
    
    @Then("I verify finxact using the method {string} and path1 {string} path2  {string}")
    public void i_verify_finxact_using_the_method_and_path1_path2(String apiMethod, String path1,String path2) {
    
    	System.out.println("_______RESPONSE DATA BEGIN______");
    	
    	String result =	FinxactAPIMethods.finxactGET(path1,path2);
    	System.out.println("_______####################RESPONSE DATA END #######################______");
    	
    	assertEquals("200", result , "response code is incorrect");
    }
    
    @Given("I invoke finxact API using method {string} path1 {string} path2  {string} and body from {string}")
    public void i_invoke_finxact_api_using_method_path1_path2_and_body_from(String apiMethod,  String path1,String path2, String jsonFile) throws FileNotFoundException, IOException {
    	System.out.println("_______####################JSON data #######################______");
    	String jsonString = JSONParser.JSON_Object_ByFileName(jsonFile);
    	String result =	FinxactAPIMethods.finxactPOST(path1,path2, jsonString);
    	System.out.println(jsonString);
    	System.out.println("Result $$##: :" + result);
       
    }
    
}
