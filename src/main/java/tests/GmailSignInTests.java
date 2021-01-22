package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GmailSignInPage;
import pages.InboxPage;

public class GmailSignInTests extends BaseTest{


    @Test
    public void validGmailLogin()
    {

        ExtentReports report = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/testReport.html");
        report.attachReporter(spark);
        ExtentTest test = report.createTest("validateGmailLogin");
        GmailSignInPage gmailSignInPage = new GmailSignInPage(driver);
        driver.get("https://accounts.google.com/");
        boolean result = gmailSignInPage.insertUserName("hhagay@gmail.com");
        Assert.assertTrue(result, "Insert Username failed");
        gmailSignInPage.clickNextButton();
        gmailSignInPage.waitForPasswordField();

        test.pass("Wait for password succeed");

        gmailSignInPage.insertPassword("2@@3cL600");
        gmailSignInPage.clickOnPasswordNextButton();

        InboxPage inboxPage = new InboxPage(driver);
        result = inboxPage.deleteMessageByText("Greetings");
        if(!result)
            test.fail("Failed to delete message");
        Assert.assertTrue(result, "Unable to delete message");

        report.flush();
    }
}
