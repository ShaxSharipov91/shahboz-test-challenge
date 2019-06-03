package com.challenge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    //region class variables

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    //endregion

    //region Page Factory Elements
    @FindBy(id = "edit-name")
    private WebElement userNameField;

    @FindBy(id = "edit-pass")
    private WebElement passwordField;

    @FindBy(id = "edit-submit")
    private WebElement loginButton;

    //endregion

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 30);
        PageFactory.initElements(webDriver, this);
    }

    public void goToLoginPage(){
        this.webDriver.get("https://demo.civihrhosting.co.uk");
        this.webDriverWait.until(ExpectedConditions.visibilityOf(loginButton));
    }

    public void loginWith(String username, String password){
        this.webDriverWait.until(ExpectedConditions.visibilityOf(userNameField));
        this.userNameField.sendKeys(username);
        this.passwordField.sendKeys(password);
        this.loginButton.click();
    }

    public String getPageTitle(){
        String title = this.webDriver.getTitle();
        return title;
    }

}
