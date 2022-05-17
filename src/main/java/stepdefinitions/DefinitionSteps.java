package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
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
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
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

    @And("User checks that language switcher is {string}")
    public void checkLanguage(final String language) {
        assertTrue(homePage.getLanguageButtonText().equalsIgnoreCase(language));
    }

    @And("User checks register button visibility")
    public void checkRegisterButtonVisibility() {
        homePage.isRegisterButtonVisible();
    }

    @And("User checks sign in button visibility")
    public void checkSignInButtonVisibility() {
        homePage.isSignInButtonVisible();
    }

    @When("User clicks 'Sign In' button")
    public void clickSignInButton() {
        homePage.clickSignInButton();
    }

    @Then("User checks email and password fields visibility on sign in popup")
    public void checkEmailVisibility() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSignInPopup());
        assertTrue(homePage.isEmailFieldVisible());
        assertTrue(homePage.isPasswordFieldVisible());
    }

    @And("User closes sign in popup")
    public void closeSignInPopup() {
        homePage.clickSignInPopupCloseButton();
    }

    @And("User opens store popup")
    public void openStorePopup() {
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.clickStoreButton();
    }

    @And("User checks that store popup visible")
    public void checkStorePopupVisibility() {
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(homePage.isStorePopupVisible());
    }

    @And("User opens shopping cart")
    public void openShoppingCart() {
        homePage.clickCartButton();
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shoppingCartPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingCartPage.getShoppingCartTitle());
    }

    @When("User clicks language button")
    public void clickLanguageButton() {
        homePage.clickLanguageButton();
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks that current url contains {string} language")
    public void checkCurrentUrl(final String language) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains(language));
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
    public void clickSearchButton() throws InterruptedException {
        //sleep(1500);//потому что баг, вам так делать нельзя!!!
        homePage.clickSearchButton();
    }

    @And("User clicks 'Add to Cart' button on product")
    public void clickAddToCart() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
        productPage.clickAddToCartButton();
    }

    @And("User checks that add to cart popup visible")
    public void checkAddToCartPopupVisibility() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToCartPopupHeader());
        assertTrue(productPage.isAddToCartPopupVisible());
    }

    @And("User checks 'Continue Shopping' button visibility")
    public void checkContinueShoppingButtonVisibility() {
        productPage.isContinueShoppingButtonVisible();
    }

    @And("User checks 'Continue to Cart' button visibility")
    public void checkContinueToCartButtonVisibility() {
        productPage.isContinueToCartButtonVisible();
    }

    @And("User checks that add to cart popup header is {string}")
    public void checkAddToCartPopupHeader(final String expectedText) {
        assertEquals(productPage.getAddToCartPopupHeaderText(), expectedText);
    }

    @And("User clicks 'Continue to Cart' button")
    public void clickContinueToCartButton() {
        productPage.clickContinueToCartButton();
    }

    @And("User clicks 'Checkout' button")
    public void clickCheckoutButton() {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingCartPage.getShoppingCartItem());
        shoppingCartPage.clickCheckoutButton();
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

    @And("User clicks on first product in goods list")
    public void clickWishList() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        itemPage = pageFactoryManager.getItemPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage= pageFactoryManager.getHomePage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickGoodsListOnFirstProduct();
        itemPage.SwitchTab(1);
        itemPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        itemPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        itemPage.clickBuyButton();
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
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        for (int s=0; s<tabs2.size(); ++s)
        {
            driver.switchTo().window(tabs2.get(s)).close();
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
        assertEquals(userGetsItemsPerPage(), userGetsQuantityOfFoundItems());
    }
}
