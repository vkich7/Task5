package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public ShoppingCartPage getShoppingCartPage() {
        return new ShoppingCartPage(driver);
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public CheckoutPage getCheckoutPage() {
        return new CheckoutPage(driver);
    }

    public ItemPage getItemPage() {return new ItemPage(driver);}
    public LoginPage getLoginPage() {return new LoginPage(driver);}
}
