package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {

    public boolean insertText(WebElement element, String textToInsert)
    {
        element.sendKeys(textToInsert);
        String textAfter = element.getText();
        if(textAfter.isEmpty())
            textAfter = element.getAttribute("value");
        return textToInsert.equals(textAfter);
    }

    public void mouseHover(WebDriver driver, WebElement element)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}
