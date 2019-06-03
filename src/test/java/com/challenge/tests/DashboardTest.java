package com.challenge.tests;

import com.challenge.pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    private DashboardPage dashboardPage;

    @Parameters({"contactEmail", "contactName"})
    @Test
    public void testContactsFilter(String contactEmail, String expectedContactName) {
        dashboardPage = new DashboardPage(driver);
        dashboardPage.selectContactToFilter(contactEmail);
        String actualContactValue = dashboardPage.getFilterValue();
        Assert.assertEquals(actualContactValue, expectedContactName);
    }
}
