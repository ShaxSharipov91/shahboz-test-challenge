package com.challenge.tests;

import com.challenge.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;
    private BasePage basePage;

    @BeforeTest
    public void startTest() {
        System.setProperty("webdriver.chrome.driver", "/Users/shax/Documents/Projects/UI-Automation-Challenge/vendors/chromedriver");
        this.driver = new ChromeDriver();
        basePage = new BasePage(driver);
        basePage.goToLoginPage();
        basePage.loginWith("civihr_admin", "civihr_admin");
    }

    @AfterTest
    public void quitTest() {
        this.driver.quit();
    }
}
