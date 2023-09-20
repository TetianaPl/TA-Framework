package utils.decorator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.HighlightElement.highlightElement;

public class HighlightingDecorator extends SelectionDecorator {
    public HighlightingDecorator(SelectItem selectItem) {
        super(selectItem);
    }

    public void selectItem(WebDriver driver, String item) {
        highlightElement(driver, driver.findElement(By.xpath("//md-option//div[contains(text(), '" + item + "')]")));
        super.selectItem(driver, item);
    }
}
