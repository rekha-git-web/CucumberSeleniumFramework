package PageObjects;

import org.openqa.selenium.WebDriver;

import java.util.List;

import org.openqa.selenium.*;


public class BasicLocators {
	
	WebElement itemContainer;
    public BasicLocators(WebElement itemContainer)
        {
        this.itemContainer = itemContainer;
        }

    public WebElement GetFieldByPlaceholderName(String fieldName)
    {
    	List<WebElement>  fields = itemContainer.findElements(By.tagName("input"));
    			      
      WebElement ExpectedField = null;
      for(WebElement field : fields){
    	  //System.out.println("Here is the field name: " +field.getAttribute("placeholder"));
            if(field.getAttribute("placeholder").equals(fieldName)){
            	ExpectedField = field;
            }
        }
		return ExpectedField;  
    	
    }
    
    public WebElement GetFieldByLabel(String labelName)
    {
   
		return itemContainer.findElement(By.xpath("//label[contains(text(), '"+ labelName +"')]/parent::div")).findElements(By.tagName("input")).get(0); 
    	
    }
    
 
    public WebElement GetButtonByName(String fieldName)
    {
    	List<WebElement>  fields = itemContainer.findElements(By.tagName("input"));
    			      
      WebElement ExpectedField = null;
      for(WebElement field : fields){
    	  //System.out.println("Here is the field name: " +field.getAttribute("value"));
            if(field.getAttribute("value").equals(fieldName)){
            	ExpectedField = field;
            }
        }
		return ExpectedField;  
    	
    }
    
    public WebElement GetIconByName(String iconName)
    {
    	List<WebElement>  fields = itemContainer.findElements(By.tagName("a"));
    			      
      WebElement ExpectedField = null;
      for(WebElement field : fields){
    	 // System.out.println("Here is the field name: " +field.getText());
            if(field.getText().contains(iconName)){
            	ExpectedField = field;
            }
        }
		return ExpectedField;  
    	
    }
    
    public WebElement GetLinkSpanByName(String linkName)
    {
    	List<WebElement>  fields = itemContainer.findElements(By.tagName("span"));
    			      
      WebElement ExpectedField = null;
      for(WebElement field : fields){
    	 // System.out.println("Here is the field name: " +field.getText());
            if(field.getText().contains(linkName)){
            	ExpectedField = field;
            }
        }
		return ExpectedField;  
    	
    }
    
    public WebElement GetSpanByClassName(String name)
    {
    	List<WebElement>  fields = itemContainer.findElements(By.tagName("span"));
    			      
      WebElement ExpectedField = null;
      for(WebElement field : fields){
    	 // System.out.println("Here is the field name: " +field.getText());
            if(field.getAttribute("class").contains(name)){
            	ExpectedField = field;
            }
        }
		return ExpectedField;  
    	
    }
}
