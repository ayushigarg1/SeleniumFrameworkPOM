package pages;

import base.TestBase;
import extentReporterListener.ExtentReporterNG;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends TestBase{


    //page factory
    @FindBy(name= "username")
    WebElement username;

    @FindBy(name= "password")
    WebElement password;

    @FindBy(xpath= "//input[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    WebElement signUpBtn;

    @FindBy(xpath = "//img[contains(@class,'img-responsive')]")
    WebElement crmLogo;

    //Initializing page objects
   public LoginPage()
   {
       PageFactory.initElements(driver, this);

   }

   public String validateLoginPageTitle(){
       return driver.getTitle();

   }

   public boolean validateCrmImage(){
       return crmLogo.isDisplayed();
   }

   public HomePage login(String un, String pwd){
       username.sendKeys(un);
       password.sendKeys(pwd);
       loginBtn.click();

       return new HomePage();
   }


}

