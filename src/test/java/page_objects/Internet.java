package page_objects;

import command_givers.ActOn;
import command_givers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ReadConfigFiles;


public class Internet extends Home{
    //initializing Logger
    public static final Logger LOGGER = LogManager.getLogger(Internet.class);


    String device = ReadConfigFiles.getPropertyValues("deviceNumber");
    String usage = ReadConfigFiles.getPropertyValues("usageFor");
    String MBPS = ReadConfigFiles.getPropertyValues("mbps");
    private final By deviceId = By.id("device-" + device);
    private final By usageId =By.id("activities-" + usage);
    private final By recommendedSpeed = By.xpath("//p[@class='xds-text-headline1'][text()='"+MBPS+"']");
    private final By ShopInternetSpeed = By.xpath("//a[@href='#hsdspeedtile?INTCMP=InternetLearn2_Connection_ShopInternetSpeeds_LearnInternet']");
    private final By SpeedINeed = By.xpath("//a[@href='/learn/internet-service#hsdhelpmedecide']");


    public Internet(WebDriver driver){super (driver);}

    //Click on Shop Internet Speed
    public Internet shopInternet() {
        LOGGER.debug("Click on Shop Internet Speed");
        ActOn.element(driver, ShopInternetSpeed).click();
        return this;
    }

    //Click on What Speed Do I Need
    public Internet whatSpeed() {
        LOGGER.debug("Click on What Speed Do I Need");
        ActOn.element(driver, SpeedINeed).click();
        return this;
    }

    //Selection of number of devices
    public Internet deviceSelection() {
        LOGGER.debug("Selection of number of devices");
        ActOn.element(driver, deviceId).click();
        return this;
    }

    //Selection of usage of internet
    public Internet usageSelection() {
        LOGGER.debug("Selection of usage of internet");
        ActOn.element(driver, usageId).click();
        return this;
    }

    //wait for recommended recommended internet speed to exist
    public Internet waitForInternetSpeed() {
        LOGGER.debug("Wait for recommended internet speed to exist");
        ActOn.wait(driver, recommendedSpeed).WaitForElementToBeVisible();
        return this;
    }

    //Verification of the recommended internet speed exist
    public Internet verifyInternetSpeed() {
        LOGGER.debug("Verification of the recommended internet speed exist");
        AssertThat.elementAssertions(driver, recommendedSpeed).elementExist();
        return this;
    }


}
