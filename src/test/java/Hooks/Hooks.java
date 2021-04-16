package Hooks;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Hooks {

    public static WebDriver driver;

 @Before
    public void setWebDriver() throws Exception {

        String browser = System.getProperty("browser");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\UmaBolisetty\\Downloads\\chromedriver_win32\\chromedriver.exe");

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("['start-maximized']");
                driver = new ChromeDriver(chromeOptions);

    }
 
 @After
 public void quitDriver(Scenario scenario){
    driver.quit();
 }
 
 
}
