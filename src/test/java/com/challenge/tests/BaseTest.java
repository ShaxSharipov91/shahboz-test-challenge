package com.challenge.tests;

import com.challenge.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;
    private BasePage basePage;

    @BeforeTest
    public void startTest() throws MalformedURLException {
//        System.setProperty("webdriver.chrome.driver", "/Users/shax/Documents/Projects/UI-Automation-Challenge/vendors/chromedriver");
//        this.driver = new ChromeDriver();

        String host = "localhost";

        DesiredCapabilities desiredCapabilities;

        if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            desiredCapabilities = DesiredCapabilities.firefox();
        } else {
            desiredCapabilities = DesiredCapabilities.chrome();
        }

        if (System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }

        String selenium_hub_url = "http://" + host + ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(selenium_hub_url), desiredCapabilities);


        basePage = new BasePage(this.driver);
        basePage.goToLoginPage();
        basePage.loginWith("civihr_admin", "civihr_admin");
    }

    @AfterTest
    public void quitTest() {
        this.driver.quit();
    }
}
