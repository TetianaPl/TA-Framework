package driverSingletone;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

//import static tests.TestSetup.reader;

public class DriverManagement {
    private static WebDriver driver = null;

    public DriverManagement() {
    }

    public static WebDriver getDriver(String browserName) {
        if (driver == null) {
            WebDriverCreator webDriverCreator;
            switch (browserName) {
                case "chrome":
                    webDriverCreator = new ChromeDriverCreator();
                    break;
                case "edge":
                    webDriverCreator = new EdgeDriverCreator();
                    break;
                case "firefox":
                    webDriverCreator = new FirefoxDriverCreator();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid browser name in properties file: " + browserName);
            }
            driver = webDriverCreator.createWebDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
