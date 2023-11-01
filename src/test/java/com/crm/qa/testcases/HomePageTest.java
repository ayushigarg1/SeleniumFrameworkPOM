package com.crm.qa.testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.DealsPage;
import pages.HomePage;
import pages.LoginPage;
import utils.TestUtil;

public class HomePageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    TestUtil testUtil;
    ContactsPage contactsPage;
    DealsPage dealsPage;

// create constructor and call super() to call all methods/properties from testbase class
    public HomePageTest()
    {

        super();
    }
    @BeforeMethod

    public void setUp()
    {
        initialization();
        loginPage = new LoginPage();
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        dealsPage = new DealsPage();
        homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test (priority = 1)
    public void verifyHomepageTitleTest()
    {
       String title =  homePage.verifyHomepageTitle();
        Assert.assertEquals(title, "CRMPRO","homepage title not pass");
    }

    @Test (priority = 2)

    public void verifyUserNameTest()
    {
        testUtil.switchToFrame();
        Assert.assertTrue(homePage.verifyUserName());

    }

    @Test (priority = 3)

    public void verifyContactLinkTest()
    {
        testUtil.switchToFrame();
      contactsPage =  homePage.clickOnContactLink();

    }

@Test(priority = 4)
    public void verifyDealsLinkTest()
    {
        testUtil.switchToFrame();
        dealsPage = homePage.clickOnDealLink();

    }

    @AfterMethod

    public void tearDown(){

        driver.close();

    }
}
