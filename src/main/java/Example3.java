
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Example3 {

    WebDriver driver;
    String projectPath;

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite");
    }
    @BeforeClass
    public void envSetup(){
        projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+"/browsers/chromedriver.exe");
    }
    @BeforeMethod
    public void testSetup(){
        driver = new ChromeDriver();
    }
    @Test
    public void gmailNavigation(){
        driver.get("https://www.gmail.com");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("google"), "Expected gmail but found "+currentUrl);
        WebElement userTextBox = driver.findElement(By.id("identifierId"));
        Assert.assertNotNull(userTextBox, "User text box is not found");
    }

    @Test
    public void myTest2(){
        System.out.println("Test # 2");
        Assert.assertTrue(false, "method failed");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
