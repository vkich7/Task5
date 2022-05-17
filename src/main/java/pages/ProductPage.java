package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//div[@class='add-to-cart__button-wrapper']/button[contains(@class,'add-to-cart__button')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='success-popup__shopping-wrapper']//h3[@class='success-popup__success-message']")
    private WebElement addToCartPopupHeader;

    @FindBy(xpath = "//a[contains(text(),'Continue shopping')]")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//a[contains(text(),'Continue to cart')]")
    private WebElement continueToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
    }

    public boolean isAddToCartPopupVisible() {
        return addToCartPopupHeader.isDisplayed();
    }

    public void isContinueShoppingButtonVisible() {
        continueShoppingButton.isDisplayed();
    }

    public String getAddToCartPopupHeaderText() {
        return addToCartPopupHeader.getText();
    }

    public void isContinueToCartButtonVisible() {
        continueToCartButton.isDisplayed();
    }

    public void clickContinueToCartButton() {
        continueToCartButton.click();
    }

    public WebElement getAddToCartPopupHeader() {
        return addToCartPopupHeader;
    }
}
