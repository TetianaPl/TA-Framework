package utils.decorator;

import org.openqa.selenium.WebDriver;

public abstract class SelectionDecorator implements SelectItem {
    private SelectItem selectItem;

    public SelectionDecorator(SelectItem selectItem) {
        this.selectItem = selectItem;
    }

    @Override
    public void selectItem(WebDriver driver, String item) {
        selectItem.selectItem(driver, item);
    }
}
