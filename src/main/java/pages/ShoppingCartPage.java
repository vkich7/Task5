package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//h1[@class='main-title']")
    private WebElement shoppingCartTitle;

    @FindBy(xpath = "//div[@class=\"empty-cart\"]")
    private WebElement emptyCart;

    @FindBy(xpath = "//button[@class='call-to-action btn btn--large btn--primary']")
    private WebElement goToCheckoutButton;

    @FindBy(xpath = "//button[@class='fake-link']//span[text()='Remove']")
    private List<WebElement> removeButtons;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getShoppingCartTitle() {
        return shoppingCartTitle;
    }

    public boolean isShoppingCartTitleVisible() {
        return shoppingCartTitle.isDisplayed();
    }

    public boolean isCartEmpty()
    {
        return emptyCart.isDisplayed();
    }

    public WebElement getCheckoutButton() {
        return goToCheckoutButton;
    }

    public List<WebElement> getRemoveButtons() {
        return removeButtons;
    }
}
