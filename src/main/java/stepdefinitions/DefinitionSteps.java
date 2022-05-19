package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.ArrayList;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 40;

    WebDriver driver;
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    CheckoutPage checkoutPage;
    ItemPage itemPage;
    PageFactoryManager pageFactoryManager;


    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks header visibility")
    public void checkHeaderVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.isHeaderVisible();
    }

    @And("User checks search field visibility")
    public void checkSearchVisibility() {
        homePage.isSearchFieldVisible();
    }

    @And("User checks footer visibility")
    public void checkFooterVisibility() {
        homePage.isFooterVisible();
    }

    @And("User checks cart visibility")
    public void checkCartVisibility() {
        homePage.isCartIconVisible();
    }

    @And("User checks cart icon visibility")
    public void userChecksCartIconVisibility() {
        homePage.isCartIconVisible();
    }

    @And("User checks categories button visibility")
    public void userChecksCategoriesButtonVisibility() {
        homePage.isCategoriesButtonVisible();
    }
    @And("User checks register button visibility")
    public void checkRegisterButtonVisibility() {
        homePage.isRegisterButtonVisible();
    }

    @And("User checks sign in button visibility")
    public void checkSignInButtonVisibility() {
        homePage.isSignInButtonVisible();
    }

    @When("User clicks 'Register' button")
    public void clickRegisterButton() {
        homePage.clickRegisterButton();
    }

    @And("User checks captcha popup visibility")
    public void userChecksCaptchaPopupVisibility() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getCaptchaDialog());
        assertTrue(homePage.getCaptchaDialog().isDisplayed());
    }

    @Then("User checks email and password fields visibility on register popup")
    public void checkEmailVisibility() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getRegisterPopup());
        assertTrue(homePage.isRegisterButtonVisible());
        assertTrue(homePage.isEmailAndPasswordFieldVisible());
    }

    @And("User closes sign in popup")
    public void closeSignInPopup() {
        homePage.clickSignInPopupCloseButton();
    }

    @And("User clicks store button")
    public void clickStoreButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.clickStoreButton();
    }

    @And("User checks that store button opens Home page")
    public void checkStorePopupVisibility() {
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains("ebay.com"));
    }

    @And("User opens shopping cart")
    public void openShoppingCart() {
        homePage.clickCartButton();
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shoppingCartPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingCartPage.getShoppingCartTitle());
    }

    @And("User checks that cart is empty")
    public void checkCurrentUrl() {
        shoppingCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(shoppingCartPage.isCartEmpty());
    }

    @And("User checks that shopping cart title visible")
    public void checkShoppingCartTitleVisibility() {
        assertTrue(shoppingCartPage.isShoppingCartTitleVisible());
    }

    @And("User makes search by keyword {string}")
    public void enterKeywordToSearchField(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks search button")
    public void clickSearchButton() {
        homePage.clickSearchButton();
    }

    @And("User clicks Category list")
    public void userClicksCategoryList() {
        homePage.clickCategoriesButton();
    }

    @And("User checks {string} from list")
    public void userChecksCategoryFromList(final String selectedCategory) {
        homePage.selectCategoryFromList(selectedCategory);
    }

    @And("User clicks 'Add to Cart' button on product")
    public void clickAddToCart() {
        productPage=pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
        productPage.clickAddToCartButton();
    }

    @And("User checks that add to cart popup visible")
    public void checkAddToCartPopupVisibility() {
        shoppingCartPage=pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shoppingCartPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingCartPage.getShoppingCartTitle());
        assertTrue(shoppingCartPage.isShoppingCartTitleVisible());
    }

    @And("User checks 'Buy It Now' button visibility")
    public void checkBuyItNowButtonVisibility() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(productPage.isBuyItNowButtonVisible());
    }

    @And("User checks that add to cart popup header contains {string}")
    public void checkAddToCartPopupHeader(final String expectedText) {
        shoppingCartPage=pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT*2);
        shoppingCartPage.waitForAjaxToComplete(DEFAULT_TIMEOUT*2);
        assertTrue(shoppingCartPage.getShoppingCartTitle().getText().contains(expectedText));
    }

    @And("User switches to product list tab")
    public void SwitchToProductListTab() {
        ArrayList<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1)).close();
        productPage.SwitchTab(0);
    }

    @And("User checks 'Checkout' button visibility")
    public void clickCheckoutButton() {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingCartPage.getCheckoutButton());
        assertTrue(shoppingCartPage.getCheckoutButton().isDisplayed());
    }

    @And("User clicks payment cart button")
    public void clickPaymentCartButton() {
        checkoutPage = pageFactoryManager.getCheckoutPage();
        checkoutPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        checkoutPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        checkoutPage.clickPaymentCartButton();
    }

    @And("User checks payment form visibility")
    public void checkPaymentFormVisibility() {
        assertTrue(checkoutPage.isPaymentFormVisible());
    }

    @And("User checks billing form visibility")
    public void checkBillingFormVisibility() {
        assertTrue(checkoutPage.isBillingFormVisible());
    }

    @And("User checks 'Complete Order' button visibility")
    public void checkCompleteOrderButtonVisibility() {
        assertTrue(checkoutPage.isCompleteOrderButtonVisible());
    }

    @And("User clicks on {int} product in goods list")
    public void clickOnProduct(final int productNum) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        itemPage = pageFactoryManager.getItemPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage= pageFactoryManager.getHomePage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickGoodsListOnProduct(productNum);
        itemPage.SwitchTab(1);
    }

    @And("User checks that amount of products in cart is {string}")
    public void checkAmountOfProductsInWishList(final String expectedAmount) {
        itemPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        itemPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        itemPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, itemPage.getCartIconAmount());
        assertEquals(expectedAmount, itemPage.getAmountOfProductsInCart());
    }

    @After
    public void tearDown() {
        ArrayList<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
        for (int s=0; s<browserTabs.size(); ++s)
        {
            driver.switchTo().window(browserTabs.get(s)).close();
        }
        //driver.close();
    }

    @And("User gets quantity of found items")
    public int userGetsQuantityOfFoundItems() {
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        return searchResultsPage.getGoodsListCount();
    }

    @And("User gets items per page")
    public int userGetsItemsPerPage() {
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        return searchResultsPage.getGoodsListCount();
    }

    @Then("User checks that quantity of found items equals items per page")
    public void userChecksThatQuantityOfFoundItemsEqualsItemsPerPage() {
        searchResultsPage=pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertEquals(userGetsItemsPerPage(), userGetsQuantityOfFoundItems());
    }

    @And("User clicks on 'Add to cart' button")
    public void userClicksOnBuyButton() {
            itemPage.clickAddToCartButton();
    }

    @And("User removes item from cart")
    public void userRemovesItemFromCart() {
        shoppingCartPage=pageFactoryManager.getShoppingCartPage();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",
                shoppingCartPage.getRemoveButtons().get(0));

    }
}
