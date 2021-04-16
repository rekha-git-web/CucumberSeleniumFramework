package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;

public class LocatorContainers
{
	  public BaseContainer BaseContainer(WebDriver driver)
      {
		  return new BaseContainer(driver.findElement(null));
      }
      
	
}