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
//import utils.factoryMethod.Reader;
//import utils.factoryMethod.ReaderFactory;
//import utils.factoryMethod.ReaderType;

import java.time.Duration;

@Listeners({TestListener.class})
public abstract class TestSetup {
    public static WebDriver driver;
    protected static Wait<WebDriver> wait;
    public static Logger logger = LogManager.getRootLogger();

}