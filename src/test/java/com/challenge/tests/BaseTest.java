package com.challenge.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void startTest(){
        System.setProperty("webdriver.chrome.driver", "/Users/shax/Documents/Projects/UI-Automation-Challenge/vendors/chromedriver");
        this.driver = new ChromeDriver();
    }

    @AfterTest
    public void quitTest(){
        this.driver.quit();
    }
}
