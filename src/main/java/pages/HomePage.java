package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//header[contains(@class, 'global-header global-header--sticky') or @class='page-header']")
    private WebElement header;

    @FindBy(xpath = "//footer")
    private WebElement footer;

    @FindBy(xpath = ".//a[@class='global-header__main-bar__utility-nav__user-cart__link']")
    private WebElement cartIcon;

    @FindBy(xpath = ".//a[contains(@class, 'header-top-bar__input__language')]/span")
    private WebElement languageButton;

    @FindBy(xpath = "//button[contains(@class,'enterprise-account__button_sign-in')]")
    private WebElement signInButton;

    @FindBy(xpath = "//button[contains(@class, 'enterprise-account__button_register')]")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@class='gigya-screen-dialog-main']")
    private WebElement signInPopup;

    @FindBy(xpath = ".//input[@name='username'][@placeholder='Email *']")
    private WebElement emailField;

    @FindBy(xpath = ".//input[@name='password'][contains(@placeholder, '*')]")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='gigya-screen-dialog-close']")
    private WebElement signInPopupCloseButton;

    @FindBy(xpath = "//div[@class='header-store parbase']//span[contains(@class,'global-store__content__section__store-name')]")
    private WebElement storeButton;

    @FindBy(xpath = "//div[@class='global-store__popup-wrapper']//div[@class='store-search']")
    private WebElement storePopup;

    @FindBy(xpath = "//input[@class='gh-tb ui-autocomplete-input']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@id='gh-btn']")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void isHeaderVisible() {
        header.isDisplayed();
    }

    public void isFooterVisible() {
        footer.isDisplayed();
    }

    public void isCartIconVisible() {
        cartIcon.isDisplayed();
    }

    public String getLanguageButtonText() {
        return languageButton.getText();
    }

    public void isSignInButtonVisible() {
        signInButton.isDisplayed();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void isRegisterButtonVisible() {
        registerButton.isDisplayed();
    }

    public boolean isEmailFieldVisible() {
        return emailField.isDisplayed();
    }

    public boolean isPasswordFieldVisible() {
        return passwordField.isDisplayed();
    }

    public WebElement getSignInPopup() {
        return signInPopup;
    }

    public void clickSignInPopupCloseButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", signInPopupCloseButton);
    }

    public void clickStoreButton() {
        storeButton.click();
    }

    public boolean isStorePopupVisible() {
        return storePopup.isDisplayed();
    }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public void clickCartButton() {
        cartIcon.click();
    }

    public void clickLanguageButton() {
        languageButton.click();
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
