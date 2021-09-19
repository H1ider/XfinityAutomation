package command_givers;

import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private WebDriver driver;



    //creating a constructor and passing value of driver through the constructor
    public BrowserActions(WebDriver driver){
        this.driver = driver;
    }

    //openBrowser is used to launch browser
    public BrowserActions openBrowser(String url){
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().window().maximize();
        return this;  //returning the class itself and if we go to the class it's returning >>this<< keyword

    }

    //closeBrowser is used to close browser
    public BrowserActions closeBrowser(){
        driver.quit();
        return this;
    }

    //captureTitle is used to capture the title of the Webpage
    public String captureTitle(){
        return driver.getTitle();
    }

}