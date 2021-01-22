import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Example2_2 {
    static WebDriver driver;

//    public static void main(String[] args) {
    @Test
    public void mainTest(){
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+"/browsers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.heraldtribune.com/");
        List<WebElement> navMenuItems = driver.findElements(By.className("gnt_n_mn_l"));
        System.out.println(navMenuItems.size());

        for(WebElement navMenuItem: navMenuItems){
            System.out.println(navMenuItem.getText());
            String navMenuItemText = navMenuItem.getText();
            if(navMenuItemText.equals("Ticket")){
                navMenuItem.click();
                break;
            }


        }

        driver.quit();

    }
}
