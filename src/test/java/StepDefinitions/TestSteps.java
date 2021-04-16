package StepDefinitions;


import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class TestSteps extends BasePage {

	  //WebDriver driver = null;

    @Given("^A user navigates to HomePage \"([^\"]*)\"$")
    public void aUserNavigatesToHomePage(String url) {
        driver.get(url);
    System.out.println("Navigate to: " + url);
    }  
}
