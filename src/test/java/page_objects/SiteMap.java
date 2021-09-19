package page_objects;

import command_givers.ActOn;
import command_givers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SiteMap extends Home{
    //initializing Logger
    private static final Logger LOGGER = LogManager.getLogger(SiteMap.class);

    private static final By SiteMapHeader = By.xpath("//h3[@class='x-display3']");
    private static final By FindAStoreTab = By.xpath("//a[@name='findastore']");

    public SiteMap(WebDriver driver){super (driver);}

    //verify that Site Map logo exist
    public SiteMap verifySiteMap() {
        LOGGER.debug("verify that Site Map logo exist");
        AssertThat.elementAssertions(driver, SiteMapHeader).elementExist();
        return this;
    }

    //verify that Find A Store option exist
    public SiteMap verifyFindAStore() {
        LOGGER.debug("verify that Find A Store option exist");
        AssertThat.elementAssertions(driver, FindAStoreTab).elementExist();
        return this;
    }

    //navigating to StoreLocator page
    public StoreLocator navigateToStoreLocator() {
        LOGGER.debug("navigating to StoreLocator page");
        ActOn.element(driver, FindAStoreTab).click();
        return new StoreLocator(driver);
    }

}
