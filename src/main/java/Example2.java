import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example2 {

    static WebDriver driver;

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+"/browsers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.wikipedia.org");
//        driver.manage().window().fullscreen();

        WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.clear();
        searchBox.sendKeys("Selenium");
        searchBox.clear();

        WebElement searchBoxByName = driver.findElement(By.name("search"));
        searchBoxByName.clear();
        searchBoxByName.sendKeys("Webdriver");

        WebElement clickSearchButton = driver.findElement(By.className("pure-button-primary-progressive"));
        clickSearchButton.click();

        WebElement resultPageTile = driver.findElement(By.id("firstHeading"));
        String headingText = resultPageTile.getText();

        if(headingText.equals("Selenium (software)"))
            System.out.println("Pass");
        else
            System.out.println("Fail");
    }
}
