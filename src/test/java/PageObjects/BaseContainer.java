package PageObjects;


import org.openqa.selenium.*;

public class BaseContainer extends BasicLocators
{
    private WebElement webElement;
    public BaseContainer(WebElement itemContainer) 
    {
    	super(itemContainer);
        this.webElement = itemContainer;
    }
}