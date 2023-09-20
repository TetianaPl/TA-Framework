package tests;

import driverSingletone.DriverManagement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utils.TestListener;
import utils.factoryMethod.Reader;
import utils.factoryMethod.ReaderFactory;
import utils.factoryMethod.ReaderType;

import java.time.Duration;

@Listeners({TestListener.class})
public abstract class TestSetup {
    protected static WebDriver driver;
    protected static Wait<WebDriver> wait;
    public static Logger logger = LogManager.getRootLogger();
//    private static ReaderType readerType = ReaderType.COMMAND_LINE;
    private static final ReaderType readerType = ReaderType.PROPERTIES_FILE;
    public static Reader reader;

    @BeforeSuite
    public void testSetup() {
        reader = new ReaderFactory().getReader(readerType);
        driver = DriverManagement.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterMethod
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void tearDown() {
//        DriverManagement.closeDriver();
    }
}