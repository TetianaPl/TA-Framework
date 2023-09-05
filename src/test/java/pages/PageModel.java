package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageModel {
    protected WebDriver driver;
    protected static Logger logger = LogManager.getRootLogger();

    public PageModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
