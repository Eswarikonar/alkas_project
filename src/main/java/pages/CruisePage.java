package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;


public class CruisePage {

    WebDriver driver;
    WebDriverWait wait;
    //constructor 
    public CruisePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openHomePage() {
        driver.get("https://www.royalcaribbean.com/alaska-cruises");
    }

    public void searchShip() {
    	WebElement searchiconinhome = driver.findElement(By.xpath("//a[@class='nav-icon-link']"));
        searchiconinhome.click();
        WebElement searchbox = driver.findElement(By.xpath("//input[@placeholder='Start your site search here']"));
        searchbox.sendKeys("Rhapsody of the Seas");


        WebElement searchicon =
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='siteSearchBox__glassIconContainer']")));
        searchicon.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.linkText("Rhapsody of the Seas | Cruise Ships | Royal Caribbean Cruises"))
                .click();
    }

    public void clickShop() {
        // EXACT LINE FROM YOUR LINEAR CODE
        WebElement shop = driver.findElement(By.partialLinkText("SHOP"));
        shop.click();
    }

    public void filterDates() {

        driver.findElement(By.xpath("//span[text()='Cruise dates']")).click();

        driver.findElement(By.xpath("//div[@class='Year_months__qs7vkd2']/child::button[5]")).click();

        List<WebElement> allElements = driver.findElements(
                By.xpath("//button[@class='PillButton_root__xc1jc0 base_button__1hlpncd2 base_trigger__1hlpncd1 Year_eachMonth__qs7vkd3 PillButton_isSelected__xc1jc1']/following-sibling::*"));

        for (int i = 0; i < Math.min(3, allElements.size()); i++) {
            WebElement el = allElements.get(i);
            el.click();
        }

        driver.findElement(By.xpath("//span[text()='Apply']")).click();
    }

    public void filterDeparturePort() {

        driver.findElement(By.xpath("//span[text()='Departure Port']")).click();

        List<WebElement> ports =
                driver.findElements(By.xpath("//button[contains(@class,'PillButton_root') and not(@disabled)]"));

        if (!ports.isEmpty()) {
        	WebElement po=(ports.get(0));
        	po.click();
        }

        driver.findElement(By.xpath("//span[text()='Apply']")).click();
    }

    public void filterDestinations() {

        driver.findElement(By.xpath("//span[text()='Destinations']")).click();
        driver.findElement(By.xpath("//button[text()='Ports']")).click();

        List<WebElement> destinations =
                driver.findElements(By.xpath("//button[contains(@class,'PillButton_root') and not(@disabled)]"));

        if (!destinations.isEmpty()) {
        	WebElement de=(destinations.get(0));
        	de.click();
        }

        driver.findElement(By.xpath("//span[text()='Apply']")).click();
    }

    public void filterNights() {

        driver.findElement(By.xpath("//span[text()='Number of nights']")).click();

        List<WebElement> nights =
                driver.findElements(By.xpath("//button[contains(@class,'PillButton_root') and not(@disabled)]"));

        if (!nights.isEmpty()) {
        	WebElement nig=(nights.get(0));
        	nig.click();
        }

        driver.findElement(By.xpath("//span[text()='Apply']")).click();
    }

    public void sortResults() {

        driver.findElement(By.xpath("//p[text()='Recommended']")).click();

        driver.findElement(By.xpath("//p[text()='Price lowest to highest']")).click();
        
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1200)");
    }

    public int getResultCount() {
        return driver.findElements(By.xpath("//div[contains(@id,'cruise-card')]")).size();
    }
}