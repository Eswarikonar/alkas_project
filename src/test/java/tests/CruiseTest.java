package tests;

import org.testng.annotations.Test;
import base.BaseTest;
import pages.CruisePage;
import utils.ScreenshotUtils;

public class CruiseTest extends BaseTest {

    @Test
    public void fullCruiseFlow() {

        
        CruisePage cp = new CruisePage(driver);

        cp.openHomePage();
        cp.searchShip();
        cp.clickShop();
        cp.filterDates();
        cp.filterDeparturePort();
        cp.filterDestinations();
        cp.filterNights();
        cp.sortResults();

        int resultCount = cp.getResultCount();
        System.out.println("Total search results: " + resultCount);

        // ⭐ TAKE SCREENSHOT AFTER RESULTS
        ScreenshotUtils.takeScreenshot(driver, "CruiseResults");
    }
}