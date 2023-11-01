package pages;


import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends TestBase {

    @FindBy(xpath = "//td[contains(text(),'Contacts')]")
    WebElement contactsLabel;

    @FindBy(xpath = "//a[contains(text(),'Ayushi Garg')]")
    WebElement userNameLabel;
    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id = "middle_initial")
    WebElement middleName;

    @FindBy(id = "surname")
    WebElement lastName;

    @FindBy(name= "client_lookup")
    WebElement companyName;

    @FindBy(xpath = "//input[@type='submit' and @value='Save']")
    WebElement saveButton;


    public ContactsPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyContactLabel() {
        return contactsLabel.isDisplayed();

    }

    public boolean verifyUserNameLabel() {
        return userNameLabel.isDisplayed();
    }

    public void createNewContact(String title,String fName, String mName, String lName, String compName) {
        Select select = new Select(driver.findElement(By.name("title")));
        select.selectByValue(title);

        firstName.sendKeys(fName);
        middleName.sendKeys(mName);
        lastName.sendKeys(lName);
        companyName.sendKeys(compName);
        saveButton.click();


    }
}
