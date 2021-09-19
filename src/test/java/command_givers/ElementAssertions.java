package command_givers;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ElementAssertions {
    private WebDriver driver;
    private By locator;

    public ElementAssertions(WebDriver driver,By locator){
        this.driver = driver;
        this.locator = locator;
    }

    public ElementAssertions elementExist(){
        boolean element = driver.findElements(locator).size() >0;
        Assert.assertTrue("the expected element does not exist ", element);
        return this;
    }
}
