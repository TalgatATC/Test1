package driver;

import dataProvider.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

public class ChromeWebDriver {

    public static WebDriver loadChromeDriver() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--window-size=1920,1080");

        if (Boolean.parseBoolean(ConfigReader.getProperty("headless"))) {
            options.addArguments("--headless");
        }


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    String login = "test_2022test";
    String password = "zadacha11";
    String sentTo = "talgat1103@gmail.com";
    String subject = "TEST TEST";
    String inputText = "Hello!!";
    String letterSend = "Письмо отправлено";


    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://mail.ru/");
        driver.findElement(By.xpath("(//a[@class='mailbox-service svelte-giypkm'])[1]")).click();

//      Навигация на страницу в которой нужно ввести логин и пароль
        List<String> pages = new LinkedList<>(driver.getWindowHandles());
        driver.switchTo().window(pages.get(1));

//      Вводим логин и пароль
        driver.findElement(By.xpath("(//div[@id='root']//div[@data-test-id='username-formfield']//input)[1]"))
                .sendKeys(login);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("(//li[@class='ph-project svelte-8ixhwv'])[1]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//      Указываем адресата, тему, содержание текста и отправляем письмо
        driver.findElement(By.xpath("//span[@class='compose-button__txt']")).click();
        driver.findElement(By.xpath("//div[@class='head_container--3W05z']//input"))
                .sendKeys(sentTo);
        driver.findElement(By.xpath("//div[@class='subject__container--HWnat']//input")).
                sendKeys(subject);
        driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys(inputText);
        driver.findElement(By.xpath("(//span[@class='vkuiButton__in'])[1]")).click();

//      Проверяем сообщение об отправке письма
        WebElement element = driver.findElement(By.xpath("//div[@class='layer__header']//a"));
        System.out.println(element.getText());
        Assert.assertEquals(letterSend,"Письмо отправлено");

    }
}
