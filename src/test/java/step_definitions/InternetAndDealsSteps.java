package step_definitions;

import command_givers.ActOn;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page_objects.AllDeals;
import page_objects.Internet;
import utilities.ReadConfigFiles;
import java.util.List;
import java.util.Map;


public class InternetAndDealsSteps {
    private static final By location = By.id("Address_SingleStreetAddress");
    private static final By showDeals = By.xpath("//button[@class='x-button--solid ']");
    private static final By streetAddress = By.id("Address_StreetAddress");
    private static final By unit = By.id("Address_UnitNumber");
    private static final By zipcode = By.id("Address_ZipCode");

    //initializing Logger
    private static Logger LOGGER = LogManager.getLogger(LoginSteps.class);
    WebDriver driver = Hooks.driver;

    //Navigating to the Home Page
    @Given("^a user is on the Home Page$")
    public void aUserIsOnTheXfinityHomePage() {
        String HomePage = ReadConfigFiles.getPropertyValues("homeUrl");
        ActOn.browser(driver).openBrowser(HomePage);
        LOGGER.debug("User is navigated to the Home Page");
    }

    //Navigating to the Internet Page
    @When("^User navigates to internet page$")
    public void userNavigatesToInternetPage() {
        new Internet(driver)
                .navigateToInternet();
        LOGGER.debug("User is navigated to the Internet Page");

    }

    //Selecting the device and usage options
    @And("^Selects the device and usage options$")
    public void selectsTheDeviceAndUsageOptions() {
        new Internet(driver)
                .shopInternet()
                .whatSpeed()
                .deviceSelection()
                .usageSelection();
        LOGGER.debug("User has selected the device and usage options");

    }

    //Validating the recommended internet speed with config file entry
    @Then("^User should see recommended internet speed$")
    public void userShouldSeeRecommendedInternetSpeed() {
        LOGGER.debug("Validating the recommended internet speed with config file entry");
        new Internet(driver)
                .waitForInternetSpeed()
                .verifyInternetSpeed();


    }

    //Navigating to the AllDeals page
    @When("^User navigates to all deals page$")
    public void userNavigatesToAllDealsPage() {
        new AllDeals(driver)
                .navigateToAllDeals();
        LOGGER.debug("User is Navigated to the AllDeals page");
    }

    //Clicking on two deals upon providing location
    @And("^Provides location and selects two deals$")
    public void providesLocationAndSelectsTwoDeals(DataTable table) {
        List<Map<String, String>> dataTable = table.asMaps(String.class, String.class);
        for (Map<String, String> cells : dataTable) {
            ActOn.element(driver, location).setValue(cells.get("address"));
            LOGGER.debug("User has provided location");
//            ActOn.element(driver,showDeals).mouseHover();
//            ActOn.element(driver, showDeals).click();
            WebElement webElement = driver.findElement(By.cssSelector("#f4462693-e8e0-4e5a-9de1-efdc119a535c > div > div > div > section > form > fieldset > div > div.x-flex-row.x-content.center-xs > div > button > span"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
            LOGGER.debug("User has clicked on Show Me Deals button");
//            ActOn.element(driver, streetAddress).setValue(cells.get("street"));
//            ActOn.element(driver, unit).setValue(cells.get("unit"));
//            ActOn.element(driver, zipcode).setValue(cells.get("zipcode"));
//
//            LOGGER.info("User has entered address");
        }

    }

    //Comparing two deals
    @Then("^User can compare deals$")
    public void userCanCompareDeals() {
        //cannot proceed because >>show me deals<< button is clicked but next page isn't appearing

    }

}