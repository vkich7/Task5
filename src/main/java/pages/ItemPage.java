package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BasePage{
    @FindBy(xpath = "//a[@id='isCartBtn_btn']")
    private WebElement buyButton;
    @FindBy(xpath = "//a[@class='gh-eb-li-a gh-rvi-menu' and @title='My eBay']")
    private WebElement cart;
    @FindBy(xpath = "//i[@id='gh-cart-n']")
    private WebElement cartIconAmount;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public void clickBuyButton() {
        buyButton.click();
    }

    public String getAmountOfProductsInCart() {
        return cartIconAmount.getText();
    }
    public WebElement getCartIconAmount(){
        return cartIconAmount;
    }
}
