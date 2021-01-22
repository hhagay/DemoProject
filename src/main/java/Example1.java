/**
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Example1 {

    static WebDriver driver;


    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+"/browsers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().window().fullscreen();

        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        driver.quit();


    }
}
