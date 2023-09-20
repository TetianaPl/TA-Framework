package utils.decorator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectDropdownItem implements SelectItem {
    @Override
    public void selectItem(WebDriver driver, String item) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//md-option//div[contains(text(), '" + item + "')]"));
        jsExec.executeScript("arguments[0].click();", element);
    }
}
