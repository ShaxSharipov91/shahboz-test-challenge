package com.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegionsPage extends BasePage {

    //region Page Factory Elements
    @FindBy(how = How.CSS, using = "#civicrm-menu > li.menumain.crm-Configure")
    private WebElement configureMenuItem;

    @FindBy(how = How.CSS, using = "#root-menu-div > div:nth-child(14) > ul > li:nth-child(3) > div")
    private WebElement jobRolesSubMenu;

    @FindBy(how = How.CSS, using = "#root-menu-div > div:nth-child(8) > ul > li:nth-child(2) > div")
    private WebElement regionsSubMenu;

    @FindBy(how = How.XPATH, using = "//*[@id=\"crm-main-content-wrapper\"]/div[2]/div[1]/a")
    private WebElement addRegionButton;

    @FindBy(how = How.ID, using = "label")
    private WebElement labelField;

    @FindBy(how = How.ID, using = "weight")
    private WebElement orderField;

    @FindBy(how = How.XPATH, using = "//div[8]/div[11]/div/button[1]")
    private WebElement saveRegionButton;

    //endregion

    public RegionsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void goToRegionsPage() {
        this.configureMenuItem.click();
        Actions actions = new Actions(webDriver);
        actions.moveToElement(this.jobRolesSubMenu).perform();
        webDriverWait.until(ExpectedConditions.visibilityOf(this.regionsSubMenu)).click();

    }

    public void addRegion(String label, String order) {
        webDriverWait.until(ExpectedConditions.visibilityOf(this.addRegionButton)).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(this.labelField)).sendKeys(label);
        webDriverWait.until(ExpectedConditions.visibilityOf(this.orderField)).clear();
        webDriverWait.until(ExpectedConditions.visibilityOf(this.orderField)).sendKeys(order);
        webDriverWait.until(ExpectedConditions.visibilityOf(this.saveRegionButton)).click();
    }

    public String getValueFromRegionsTable(String table_row, String table_column) {
        String value;
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"options\"]/tbody/tr[" + table_row + "]/td[" + table_column + "]/div"));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        value = element.getText();
        return value;
    }

}
