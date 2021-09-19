package step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page_objects.SiteMap;
import page_objects.StoreLocator;
import java.util.List;
import java.util.Map;

public class SiteMapSteps {

    //initializing Logger
    private static Logger LOGGER = LogManager.getLogger(SiteMapSteps.class);
    WebDriver driver = Hooks.driver;

    //Navigate to SiteMap page
    @When("^User navigates to SiteMap$")
    public void userNavigatesToSiteMap() {
        new SiteMap(driver)
                .navigateToSiteMap();
        LOGGER.debug("User is navigated to SiteMap Page");
    }

    //Check if the SiteMap Header exists to verify User is on the SiteMap page
    @Then("^User should see Site map and FindAStore option$")
    public void userShouldSeeSiteMapAndFindAStoreOption() {
        new SiteMap(driver)
                .verifySiteMap()
                .verifyFindAStore();
        LOGGER.debug("Verifying SiteMap Page");
    }

    //Navigating to StoreLocator Page
    @When("^Navigates to Find A Store tab$")
    public void navigatesToFindAStoreTab() {
        new StoreLocator(driver)
                .navigateToStoreLocator();
        LOGGER.debug("User is navigated to the StoreLocator Page");
    }

    //Verify nearest store information against the scenario dataTable
    @Then("^User should see nearby store information upon entering location$")
    public void userShouldSeeNearbyStoreInformationUponEnteringLocation(DataTable table) {
        List<Map<String, String>> dataTable = table.asMaps(String.class, String.class);
        for (Map<String, String> cells : dataTable) {
            By LocationXpath = By.xpath("//span[text()='"+cells.get("storename")+"']");
            new StoreLocator(driver)
                    .enterLocation(cells.get("location"))
                    .clickSearch()
                    .verifyNearestStore(LocationXpath);
        LOGGER.debug("Verifying nearest store information against the Scenario dataTable");
        }
    }

    @Then("^User can use location \"(.+?)\" to find out nearby store \"(.+?)\"$")
    public void user_can_use_location_to_find_out_nearby_store(String location, String storeName) {
        By LocationXpaths = By.xpath("//span[text()='"+storeName+"']");
        new StoreLocator(driver)
                .enterLocation(location)
                .clickSearch()
                .waitForNearestStore(LocationXpaths)
                .verifyNearestStore(LocationXpaths);
        LOGGER.debug("Verifying nearest store information against the Scenario dataTable");
    }
}
