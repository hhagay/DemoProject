package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailWelcomePage {

    WebDriver driver;
    private By createAccountButton = By.linkText("Create an account");
    private By signInButton = By.linkText("Sign in");


    public void clickOnCreateAccount() {
        driver.findElement(createAccountButton).click();
    }

    public void clickOnSignInButton(){
        driver.findElement(signInButton).click();
    }



}
