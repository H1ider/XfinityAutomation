package page_objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class AllDeals extends Home{
    //initializing Logger
    public static final Logger LOGGER = LogManager.getLogger(AllDeals.class);

    public AllDeals(WebDriver driver){super (driver);}

}
