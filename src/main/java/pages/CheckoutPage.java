package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//button[contains(@class,'choose-payment-method__btn--regular-card')]")
    private WebElement paymentCartButton;

    @FindBy(xpath = "//*[@class='opc-billing-form']/*[@class='opc-billing-form__wrapper']")
    private WebElement billingForm;

    @FindBy(xpath = "//div[@class='checkout-payment-form__wrapper']")
    private WebElement paymentForm;

    @FindBy(xpath = "//button[contains(@class,'checkout-order-summary__continue-btn')]")
    private WebElement completeOrderButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void clickPaymentCartButton() {
        paymentCartButton.click();
    }

    public boolean isBillingFormVisible() {
        return billingForm.isDisplayed();
    }

    public boolean isPaymentFormVisible() {
        return paymentForm.isDisplayed();
    }

    public boolean isCompleteOrderButtonVisible() {
        return completeOrderButton.isDisplayed();
    }
}
