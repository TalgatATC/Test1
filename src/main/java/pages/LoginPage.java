package pages;

import driver.Driver;
import helpers.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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
    @FindBy(xpath = "(//li[@class='ph-project svelte-8ixhwv'])[1]")
    public WebElement rela;
    @FindBy(xpath = "(//div[@class='nav__folder-name__txt'])[1]")
    public WebElement adminTitle;
    @FindBy(xpath = "//span[@class='compose-button__txt']")
    public WebElement writeLetter;
    @FindBy (xpath = "//div[@class='head_container--3W05z']//input")
    public WebElement toAdresse;
    @FindBy (xpath = "//div[@class='subject__container--HWnat']//input")
    public WebElement subject;
    @FindBy (xpath = "//div[@role='textbox']")
    public WebElement newText;
    @FindBy (xpath = "(//span[@class='vkuiButton__in'])[1]")
    public WebElement sentLetter;
    @FindBy (xpath = "(//div[@class='nav__folder-name__txt'])[8]")
    public WebElement otpravlenn;


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
        helper.click(enterButton).click(rela);
        return this;
    }
    public LoginPage newLetter (){
        helper.click(writeLetter);
        return this;
    }
    public LoginPage toNewLetter(String str){
        helper.sendKeys(toAdresse,str);
        return this;
    }
    public LoginPage subjectTo(String str1){
        helper.sendKeys(subject,str1);
        return this;
    }
    public LoginPage toNewText(String str3){
        helper.sendKeys(newText,str3);
        return this;
    }
    public LoginPage clickSentLetter(){
        helper.click(sentLetter)
                .pause(22);
        return this;
    }
    public LoginPage clickOpravPis(){
        helper.click(otpravlenn);
        return this;
    }

}
