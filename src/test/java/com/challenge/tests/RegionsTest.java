package com.challenge.tests;

import com.challenge.pages.RegionsPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegionsTest extends BaseTest {
    private RegionsPage regionsPage;

    @Parameters({"label", "order", "tableRow", "tableCol"})
    @Test
    public void testAddRegions(String label, String order, String tableRow, String tableCol) {
        regionsPage = new RegionsPage(driver);
        regionsPage.goToRegionsPage();
        regionsPage.addRegion(label, order);
        String actualLabel = regionsPage.getValueFromRegionsTable(tableRow, tableCol);
        Assert.assertEquals(actualLabel, label);
    }
}
