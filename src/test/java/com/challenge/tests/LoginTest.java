package com.challenge.tests;

import com.challenge.pages.BasePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private BasePage basePage;

    @Parameters({"pageTitle"})
    @Test
    public void successfulLogin(String expectedPageTitle) {
        basePage = new BasePage(driver);
        String actualTitle = basePage.getPageTitle();
        Assert.assertEquals(actualTitle, expectedPageTitle);
    }


}
