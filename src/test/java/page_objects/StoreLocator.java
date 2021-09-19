package page_objects;

import command_givers.ActOn;
import command_givers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StoreLocator extends SiteMap{
    //initializing Logger
    private static final Logger LOGGER = LogManager.getLogger(StoreLocator.class);

    public static final By LocationField = By.id("q");

    public StoreLocator(WebDriver driver){super (driver);}

    //enter location
    public StoreLocator enterLocation(String value){
        driver.findElement(LocationField).clear();
        ActOn.element(driver, LocationField).setValue(value);
        LOGGER.debug("enter location");
        return this;
    }

    //click on search magnifying glass icon
    public StoreLocator clickSearch() {
        //this will click on Web element even if there are overlays
        WebElement webElement = driver.findElement(By.cssSelector("#search-form > div.Locator-searchContent > div.Locator-searchBar > button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
        LOGGER.debug("click on search magnifying glass icon");
        return this;
    }

    //Wait for nearest store information to appear/exist
    public StoreLocator waitForNearestStore(By xpath) {
        LOGGER.debug("Wait for nearest store information to exist");
        ActOn.wait(driver, xpath).WaitForElementToBeVisible();
        return this;
    }

    //verify nearest store information
    public StoreLocator verifyNearestStore(By xpath) {
        AssertThat.elementAssertions(driver, xpath).elementExist();
        LOGGER.debug("verify nearest store information");
        return this;
    }

}
