package StepDefinitions;

import org.openqa.selenium.WebDriver;
import Hooks.Hooks;

public class BasePage {

    protected WebDriver driver;
    

    public BasePage() {
        this.driver = Hooks.driver;
    }
}