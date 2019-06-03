package com.challenge.tests;

import com.challenge.pages.BasePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private BasePage basePage;

    @Parameters({"username", "password", "pageTitle"})
    @Test(priority=2)
    public void successfulLogin(String username, String password, String expectedPageTitle)
    {
        basePage = new BasePage(driver);
        basePage.goToLoginPage();
        basePage.loginWith(username, password);
        String actualTitle = basePage.getPageTitle();
        Assert.assertEquals(actualTitle, expectedPageTitle);
    }


}
