package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//header[@id='gh']")
    private WebElement header;

    @FindBy(xpath = "//footer[@id='glbfooter']")
    private WebElement footer;

    @FindBy(xpath = "//a[@class='gh-eb-li-a gh-rvi-menu' and contains(@aria-label,\"cart\")]")
    private WebElement cartIcon;

    @FindBy(xpath = "//span[@id='gh-ug']/a[contains(text(), 'Sign in')]")
    private WebElement signInButton;

    @FindBy(xpath = "//span[@id='gh-ug-flex']/a[contains(text(), 'register')]")
    private WebElement registerButton;

    @FindBy(xpath = "//h1[contains(text(), 'Create an account')]")
    private WebElement registerPopup;

    @FindBy(xpath = "//div[@class='target-icaptcha-slot']")
    private WebElement captchaDialog;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='gigya-screen-dialog-close']")
    private WebElement signInPopupCloseButton;

    @FindBy(xpath = "//button[@title='Ship to']")
    private WebElement shipToButton;

    @FindBy(xpath = "//a[@id='gh-la']")
    private WebElement storeButton;

    @FindBy(xpath = "//input[@class='gh-tb ui-autocomplete-input']")
    private WebElement searchField;

    @FindBy(xpath = "//select[@id='gh-cat']")
    private WebElement categoriesButton;

    @FindBy(xpath = "//select[@id='gh-cat']")
    private List<WebElement> selectAllCategories;

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

    public void isCategoriesButtonVisible() {
        categoriesButton.isDisplayed();
    }

    public boolean isSignInButtonVisible() {
        return registerButton.isDisplayed();
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public boolean isRegisterButtonVisible() {
        return registerButton.isDisplayed();
    }

    public WebElement getRegisterPopup() {
        return registerPopup;
    }

    public WebElement getCaptchaDialog() {
        return captchaDialog;
    }

    public boolean isEmailAndPasswordFieldVisible() {
        return emailField.isDisplayed() && passwordField.isDisplayed();
    }
    public void clickSignInPopupCloseButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", signInPopupCloseButton);
    }

    public void clickStoreButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", storeButton);
    }

    public boolean isStorePopupVisible() {
        return storeButton.isDisplayed();
    }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public void clickCartButton() {
        cartIcon.click();
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }
    public void selectCategoryFromList(final String category ){
        Select selectObject = new Select(categoriesButton);
        selectObject.selectByIndex(4);
       //selectObject.selectByVisibleText(category);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
    public void clickSigninButton() {
        signInButton.click();
    }
    public void clickCategoriesButton() {
        categoriesButton.click();
    }
    public List<WebElement> getCategories(){
        return selectAllCategories;
    }
}
