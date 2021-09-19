package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.SignIn;


public class LoginSteps {
    //initializing Logger
    private static final Logger LOGGER = LogManager.getLogger(LoginSteps.class);
    WebDriver driver= Hooks.driver;


    //User is navigated to SignIn page and entered username and password
    @When("^User navigates to login page and enters username \"(.+?)\" and password \"(.+?)\"$")
    public void useEntersUsernameAndPassword(String userName, String password) {
        new SignIn(driver)
                .navigateToSignIn()
                .enterUserName(userName)
                .enterPassword(password);
        LOGGER.debug("User is navigated to SignIn page and entered username and password");
    }


    //Click on Sign In button
    @And("^Click on the Sign In button$")
    public void clickOnTheSignInButton() {
        new SignIn(driver)
                .clickOnSignIn();
        LOGGER.debug("User clicked on Login Button");
    }

    //Validating the unsuccessful login error msg with invalid user and invalid password
    @Then("^User should get an error message$")
    public void userShouldGetAndErrorMessage() {
        new SignIn(driver)
                .unsuccessfulLoginError();
        LOGGER.debug("Validating the unsuccessful login error msg with invalid user and invalid password");
    }

    //Entering username
    @When("^User navigates to login page and enters username \"(.+?)\" only$")
    public void userEntersUsernameOnly(String userName) {
        new SignIn(driver)
                .navigateToSignIn()
                .enterUserName(userName);
        LOGGER.debug("User has entered username");
    }

    //Validating the password field error msg with invalid user and no password
    @Then("^User is shown password field error and failed to login$")
    public void userIsShownPasswordFieldErrorAndFailedToLogin() {
        new SignIn(driver)
                .passwordError();
        LOGGER.debug("Validating the password field error msg with invalid user and no password");
    }

    //Navigating to SignIn Page and entering password
    @When("^User navigates to login page and enters password \"(.+?)\" only$")
    public void user_navigates_to_login_page_and_enters_password_only(String password) {
        new SignIn(driver)
                .navigateToSignIn()
                .enterPassword(password);
        LOGGER.debug("User is navigated to SignIn Page and entered password");
    }

    //Validating username field error msg
    @Then("^User is shown user field error and failed to login$")
    public void user_is_shown_user_field_error_and_failed_to_login() {
        new SignIn(driver)
                .userNameError();
        LOGGER.debug("Validating username field error msg");
    }

    //Navigating to SignIn page
    @When("^User navigates to login page$")
    public void user_navigates_to_login_page() {
        new SignIn(driver)
                .navigateToSignIn();
        LOGGER.debug("User is navigated to SignIn page");
    }

    //Validating user and password field error msg
    @Then("^User is shown user field error and password field error and failed to login$")
    public void user_is_shown_user_field_error_and_password_field_error_and_failed_to_login() {
        new SignIn(driver)
                .userNameError()
                .passwordError();
        LOGGER.debug("Validating user and password field error msg");
    }



}
