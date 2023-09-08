package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.HighlightElement.highlightElement;

public class EmailYourEstimateModalForm extends PageModel {
    @FindBy(xpath = "//input[@ng-model='emailQuote.user.email']")
    private static WebElement emailField;
    @FindBy(xpath = "//button[contains(text(), 'Send Email')]")
    private static WebElement sendEmailButton;

    public EmailYourEstimateModalForm(WebDriver driver) {
        super(driver);
    }

    public void enterEmailAddress(String emailAddress) {
        highlightElement(driver, emailField);
        emailField.click();
        emailField.sendKeys(emailAddress);
        logger.info("The email address " + emailAddress + " is filled in the Email field on the 'Email Your Estimate' form.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickSendEmailButton() {
        highlightElement(driver, sendEmailButton);
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].click();", sendEmailButton);
        logger.info("The 'Email Your Estimate' form submitted.");
    }
}
