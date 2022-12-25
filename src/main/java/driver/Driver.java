package driver;

import dataProvider.ConfigReader;
import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.List;

public class Driver {

        private Driver() {
        }

        private static WebDriver driver;

        public static WebDriver getDriver() {
            if (driver == null) {
                switch (ConfigReader.getProperty("browser").toLowerCase()) {
                    case "chrome":
                        driver = ChromeWebDriver.loadChromeDriver();
                }
            }
            return driver;

        }
    public static void closeDriver(){
        try {
            if (driver != null){
                driver.close();
                driver.quit();
                driver = null;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    }

