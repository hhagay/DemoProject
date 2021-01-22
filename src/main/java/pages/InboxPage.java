package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class InboxPage extends BasePage{

    private WebDriver driver;

    public InboxPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

//    By tableElement = By.id(":2d");
    @FindBy(id=":2d")
    WebElement tableElement;

    public boolean deleteMessageByText(String textToDelete)
    {
        List<WebElement> rows = tableElement.findElements(( By.tagName("tr")));

        for(WebElement row: rows){
            String rowText = row.getText();
            if(rowText.contains(textToDelete)) {

                super.mouseHover(driver, row);

                WebElement deleteButton = row.findElement(By.cssSelector("li[data-tooltip='Delete']"));
                deleteButton.click();
                return true;

            }
        }
        return false;
    }


}
