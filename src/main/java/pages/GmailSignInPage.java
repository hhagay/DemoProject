package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailSignInPage extends BasePage{

    WebDriver driver;

    private By userNameField = By.id("identifierId");
    private By nextButton = By.id("identifierNext");
    private By passwordField = By.name("password");
    private By passwordNextButton = By.id("passwordNext");

    public GmailSignInPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean insertUserName(String userName){
        WebElement userNameElement = driver.findElement(userNameField);
        return super.insertText(userNameElement, userName);
    }

    public void insertPassword(String password)
    {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickNextButton(){
        driver.findElement(nextButton).click();
    }

    public void clickOnPasswordNextButton(){
        driver.findElement(passwordField).click();
    }

    public void waitForPasswordField()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
    }

}
