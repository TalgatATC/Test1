package pages;

import driver.Driver;
import helpers.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedList;
import java.util.List;


public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    Helper helper = new Helper();




    @FindBy(xpath = "(//a[@class='mailbox-service svelte-giypkm'])[1]")
    public WebElement enterClick;
    @FindBy(xpath = "(//div[@id='root']//div[@data-test-id='username-formfield']//input)[1]")
    public WebElement userNameInput;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement nextInput;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInput;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement enterButton;

    @FindBy(xpath = "//span[@class='compose-button__txt']")
    public WebElement adminTitle;

    public LoginPage enterInput(){
        helper.click(enterClick);
        return this;
    }
    public LoginPage inputUserName(String userName) {
        helper.pause(4)
                .click(userNameInput)
                .sendKeys(userNameInput, userName);
        return this;
    }

    public LoginPage clickInputNext() {
        helper.click(nextInput);
        return this;
    }

    public LoginPage inputPassword(String password) {
        helper.sendKeys(passwordInput, password);
        return this;
    }

    public LoginPage clickEnterButton() {
        helper.click(enterButton);
        return this;
    }
}
