package steps;

import dataProvider.ConfigReader;
import driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;

import java.util.LinkedList;
import java.util.List;


public class LoginSteps {

    LoginPage loginPage = new LoginPage();



    @Given("Go to login page")
    public void go_to_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("qaEnvironment"));
    }

    @Given("user should click on email button")
    public void user_should_click_on_email_button() {
        loginPage.enterInput();
        List<String> pages = new LinkedList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(pages.get(1));

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
        Assertions.assertEquals("Входящие",loginPage.adminTitle.getText());
    }

    @Then("user presses the mail button")
    public void user_presses_the_mail_button() {

    }
    @Then("user should click the write a letter button")
    public void user_should_click_the_write_a_letter_button() {
        loginPage.newLetter();
      
    }
    @Then("Enter {string} fill in the to field")
    public void enter_fill_in_the_to_field(String addressee) {
        loginPage.toNewLetter(addressee);
    }
    @Then("Enter {string} fill subject field")
    public void enter_fill_subject_field(String subject) {
        loginPage.subjectTo(subject);
      
    }
    @Then("Enter {string} fill in the text of the letter")
    public void enter_fill_in_the_text_of_the_letter(String str) {
        loginPage.toNewText(str);
      
    }
    @When("user click button sent")
    public void user_click_button_sent() {
        loginPage.clickSentLetter();
    }
    @Then("user should go to the sent folder")
    public void user_should_go_to_the_sent_folder() {
        loginPage.clickOpravPis();
    }



}



