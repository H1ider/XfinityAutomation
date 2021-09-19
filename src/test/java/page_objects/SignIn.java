package page_objects;

import command_givers.ActOn;
import command_givers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignIn extends Home{
    //initializing Logger
    private static final Logger LOGGER = LogManager.getLogger(SignIn.class);

    private final By userNameField = By.id("user");
    private final By passwordField = By.id("passwd");
    private final By signInButton = By.id("sign_in");

    public SignIn(WebDriver driver){super (driver);}

    //Enter username
    public SignIn enterUserName(String value){
        ActOn.element(driver, userNameField).setValue(value);
        LOGGER.debug("entered username is "+ value);
        return this;
    }

    //Enter password
    public SignIn enterPassword(String value){
        ActOn.element(driver, passwordField).setValue(value);
        LOGGER.debug("entered password is "+ value);
        return this;
    }

    //Click on Sign In Button
    public SignIn clickOnSignIn(){
        ActOn.element(driver, signInButton).click();
        LOGGER.debug("Click on Sign In Button");
        return this;
    }

    //Validate the error msg with invalid username and invalid password
    public SignIn unsuccessfulLoginError() {
        LOGGER.debug("Validating login attempt is unsuccessful and login error using invalid credentials");
        By ErrTxt = By.id("error");
        AssertThat.elementAssertions(driver,ErrTxt).elementExist();
        return this;

        // Tried to add the text but failed to interact with text of the element with xpath "//p[@id='error']/text()"
//       String actualErrText = driver.findElement(By.xpath("//p[@class='error_message']")).getText();
//       Assert.assertEquals(expectedErrorText, actualErrText);

//       By ErrTxt = By.xpath("//p[contains(normalize-space(text()),'The Xfinity ID or password you entered was incorrect.Please try again.')]");
//       By ErrTxt = By.xpath("//div[@class='container']/form/p/text()");

//       By ErrTxt = By.xpath("//p[@id='error']/text()");
//       By ErrTxt = By.xpath("//p[@id='error']/text()='The Xfinity ID or password you entered was incorrect.Please try again.'");
    }

    //Validate the error msg with invalid username and blank password
    public SignIn passwordError(){
        By PasswordErrTxt = By.id("passwd-error");
        LOGGER.debug("Validating login attempt is unsuccessful and password error using invalid userName and blank password");
        AssertThat.elementAssertions(driver,PasswordErrTxt).elementExist();
        return this;
    }

    //Validate the error msg with blank username and invalid password
    public SignIn userNameError(){
        By userNameErrTxt = By.id("user-error");
        LOGGER.debug("Validating login attempt is unsuccessful and userName error using invalid userName and blank password");
        AssertThat.elementAssertions(driver,userNameErrTxt).elementExist();
        return this;
    }
}
