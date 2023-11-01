/**
 * Author: Ayushi
 */
package com.crm.qa.testcases;

import base.TestBase;
import com.aventstack.extentreports.ExtentReports;
import extentReporterListener.ExtentReporterNG;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ExtentReports extentReports;

// create constructor and call super() to call all methods/properties from testbase class
    public LoginPageTest()
    {
        super();
    }

    @BeforeSuite

    public  void extentReport()
    {
        extentReports = ExtentReporterNG.getInstance();
    }
    @BeforeMethod

    public void setUp()
    {
        initialization();

         loginPage = new LoginPage();
    }

    @Test (priority = 1)
    public void loginPageTitleTest()
    {
       String title =  loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, and support.");
        extentReport(extentReports, "Validate login page title");

    }

    @Test (priority = 2)

    public void validateCrmImageTest()
    {
         boolean flag = loginPage.validateCrmImage();
         Assert.assertTrue(flag);
         extentReport(extentReports, "validate Crm image");
    }

    @Test (priority = 3)
    public  void loginTest(){
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        extentReport(extentReports, "user login successfully");

    }
    @AfterMethod

    public void tearDown(){
        driver.quit();
    }

    @AfterSuite

    public  void flushExtentReport()
    {
        ExtentReporterNG.flushReports();
    }

}
