package step_definitions;

import command_givers.ActOn;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    //initializing Logger
    private static final Logger LOGGER = LogManager.getLogger(Hooks.class);
    static WebDriver driver;

    @Before
    //Launching the Chrome Browser
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        LOGGER.info("Launch Chrome Browser");
    }

    @After
    //Closing the Browser
    public void closeBrowser() {
        ActOn.browser(driver).closeBrowser();
        LOGGER.info("close Chrome Browser");
    }

}
