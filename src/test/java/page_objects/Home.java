package page_objects;

import command_givers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
    //initializing Logger
    public static final Logger LOGGER = LogManager.getLogger(Home.class);

    private final By InternetTab = By.xpath("//a[@class='xc-footer--link'][@href='https://www.xfinity.com/learn/internet-service']");
    private final By AllDealsTab = By.xpath("//a[@class='xc-footer--link'][@href='https://www.xfinity.com/learn/offers']");
    private final By SignInTab = By.xpath("//a[@class='xc-header--signin-link']");
    private final By SiteMapTab = By.xpath("//a[@class='xc-footer--link'][@href='https://www.xfinity.com/site-map']");

    public WebDriver driver;
    public Home(WebDriver driver){
        this.driver = driver;
    }

    //Navigating to Internet Page
    public Internet navigateToInternet() {
        LOGGER.debug("Navigating to Internet Page");
        ActOn.element(driver, InternetTab).click();
        return new Internet(driver);
    }

    //Navigating to All Deals Page
    public AllDeals navigateToAllDeals() {
        LOGGER.debug("Navigating to All Deals Page");
        ActOn.element(driver, AllDealsTab).click();
        return new AllDeals(driver);
    }

    //Navigating to Sign In Page
    public SignIn navigateToSignIn() {
        LOGGER.debug("Navigating to Sign In Page");
        ActOn.element(driver, SignInTab).click();
        return new SignIn(driver);
    }

    //Navigating to All Deals Page
    public SiteMap navigateToSiteMap() {
        LOGGER.debug("Navigating to All Deals Page");
        ActOn.element(driver, SiteMapTab).click();
        return new SiteMap(driver);
    }
}
