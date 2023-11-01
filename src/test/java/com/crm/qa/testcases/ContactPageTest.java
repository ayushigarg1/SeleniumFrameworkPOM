package com.crm.qa.testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.DealsPage;
import pages.HomePage;
import pages.LoginPage;
import utils.TestUtil;

public class ContactPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;
    DealsPage dealsPage;
    String SheetName = "tasks";

    // create constructor and call super() to call all methods/properties from testbase class
    public ContactPageTest() {

        super();
    }

    @BeforeMethod

    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        dealsPage = new DealsPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContactLink();

    }

    @Test(priority = 1)
    public void verifyContactLabelTest() {
        Assert.assertTrue(contactsPage.verifyContactLabel(), "Contact labels is missing");
    }


    @Test(priority = 2)

    public void verifyUserNameLabelTest() {
        Assert.assertTrue(contactsPage.verifyUserNameLabel(), "User name label is missing");
    }


    /*@DataProvider
    public Object[][] getTestContactData() {
        Object data[][] = TestUtil.getTestData(SheetName);
        return data;
    }

    @Test(priority = 3, dataProvider = "getTestContactData")
    public void validateCreateNewContact(String title, String firstName, String midName, String lastName, String country) throws InterruptedException {
        Thread.sleep(100);
        homePage.clickOnNewContact();
        contactsPage.createNewContact(title, firstName, midName, lastName, country);
    }*/

    @AfterMethod

    public void tearDown() {
        driver.quit();
    }
}
