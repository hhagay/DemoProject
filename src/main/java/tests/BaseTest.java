package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    protected WebDriver driver;
    String projectPath;

    @BeforeClass
    public void envSetup(){
        projectPath = System.getProperty("user.dir");
//        System.setProperty("webdriver.chrome.driver", projectPath+"/browsers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", projectPath+"/browsers/geckodriver.exe");
//        System.setProperty("webdriver.edge.driver", projectPath+"/browsers/msedgedriver.exe");
    }
    @BeforeMethod
    public void testSetup(){
        driver = new FirefoxDriver();
    }

    @AfterMethod
    public void tearDown()
    {
        /*
        1. screen shot on faiure
        2. close browser
         */
        driver.quit();

    }
}
