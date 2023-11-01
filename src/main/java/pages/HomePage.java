package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestUtil;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePage extends TestBase {

    TestUtil testUtil = new TestUtil();

   @FindBy(xpath = "//td[contains(text(),'User: Ayushi Garg')]")
    WebElement userName;

   @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    WebElement contactsLink;

   @FindBy(xpath = "//a[contains(text(), 'Deals')]")
    WebElement dealsLink;

   @FindBy(xpath = "//a[contains(text(),'New Contact')]")
   WebElement newContactLink;

   //initialize page objects

    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }

    public String verifyHomepageTitle()
    {
       return driver.getTitle();

    }

    public boolean verifyUserName()
    {
       return userName.isDisplayed();
    }
    public ContactsPage clickOnContactLink()
    {
         contactsLink.click();
         return new ContactsPage();

    }
    public DealsPage clickOnDealLink()
    {
       dealsLink.click();
       return new DealsPage();
    }

    public void clickOnNewContact() throws InterruptedException {
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        action.moveToElement(contactsLink).build().perform();
        newContactLink.isEnabled();
        newContactLink.click();
    }


}
