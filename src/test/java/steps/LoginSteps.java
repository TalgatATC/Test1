package steps;

import dataProvider.ConfigReader;
import driver.Driver;
import helpers.Helper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;


public class LoginSteps {

    LoginPage loginPage = new LoginPage();
//    Helper helper = new Helper();

    @Given("Go to login page")
    public void go_to_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("qaEnvironment"));
    }

    @Given("user should enter button and click")
    public void user_should_enter_button_and_click() {
        loginPage.enterInput();

    }
    @Given("Enter {string} in UserName input field")
    public void enter_in_user_name_input_field(String userName) {
        loginPage.inputUserName(userName);
    }
    @Then("user click enter button")
    public void user_click_enter_button() {
        loginPage.clickInputNext();
    }

    @Then("Enter {string} in password input field")
    public void enter_in_password_input_field(String password) {
        loginPage.inputPassword(password);
    }

    @When("user click button enter")
    public void user_click_button_enter() {
        loginPage.clickEnterButton();
    }
    @Then("user should successfully logged in")
    public void user_should_successfully_logged_in() {
//        Assertions.assertEquals("Написать письмо",helper.getText(loginPage.adminTitle));
       
    }

}
