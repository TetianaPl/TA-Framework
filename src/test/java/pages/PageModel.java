package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageModel {
    protected WebDriver driver;
    protected JavascriptExecutor jsExec;

    public PageModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        jsExec = (JavascriptExecutor) driver;
    }
}
