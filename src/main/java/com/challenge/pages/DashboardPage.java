package com.challenge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DashboardPage extends BasePage {

    //region Page Factory Elements
    @FindBy(how = How.XPATH, using = "//a[contains(.,'Filter Task')]")
    private WebElement filterTasksButton;

    final String contactDropDownLocator = "//div[@class='col-xs-12 col-sm-10']";
    @FindBy(how = How.XPATH, using = contactDropDownLocator)
    private WebElement contactDropDown;

    @FindAll(@FindBy(how = How.XPATH, using = "//*[@id=\"ui-select-choices-0\"]/li/div/small"))
    private List<WebElement> contacts;

    @FindBy(how = How.XPATH, using = contactDropDownLocator + "/div/div/a/span[2]")
    private WebElement contactDropDownValue;
    //endregion

    public DashboardPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    private void clickFilterTaskButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(filterTasksButton));
        this.filterTasksButton.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(contactDropDown));
    }

    public void selectContactToFilter(String contactEmail) {
        clickFilterTaskButton();
        contactDropDown.click();

        for (WebElement element : contacts) {
            if (element.getText().equals(contactEmail)) {
                element.click();
                break;
            }
        }
    }

    public String getFilterValue() {
        return this.contactDropDownValue.getText();
    }


}
