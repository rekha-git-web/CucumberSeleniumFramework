package PageObjects;

import java.util.List;

import org.openqa.selenium.*;

public class LocatorContainers
{
	  public BaseContainer BaseContainer(WebDriver driver)
      {
		 // return new BaseContainer(driver.findElement(By.className("Login__Form")));
		  return new BaseContainer(driver.findElement(By.tagName("form")));
      }
      
	  public FormContainer FormContainer(WebDriver driver, String formName)
      {
		  List<WebElement>  fields = driver.findElements(By.tagName("form"));
	      
	      WebElement ExpectedField = null;
	      for(WebElement field : fields){
	    	  System.out.println("Here is the form name: " +field.getAttribute("action"));
	            if(field.getAttribute("action").contains(formName)){
	            	ExpectedField = field;
	            }
	        }
			
		  return new FormContainer(ExpectedField);
      }
      
	
}