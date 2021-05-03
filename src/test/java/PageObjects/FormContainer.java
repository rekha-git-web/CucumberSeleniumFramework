package PageObjects;


import org.openqa.selenium.*;

public class FormContainer extends BasicLocators
{
    private WebElement webElement;
    public FormContainer(WebElement itemContainer) 
    {
    	super(itemContainer);
        this.webElement = itemContainer;
    }
}