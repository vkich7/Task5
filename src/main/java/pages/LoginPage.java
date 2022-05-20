package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(xpath = "//input[@id='userid']")
    private WebElement loginField;
    @FindBy(xpath = "//button[@id='signin-continue-btn']")
    private WebElement continueButton;
    @FindBy(xpath = "p[@id='errormsg']")
    private WebElement errorMsg;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void setLoginField(String userLogin){
        loginField.sendKeys(userLogin);
    }
    public void clickOnCntinueButton(){
        continueButton.click();
    }
    public boolean isErrorMsgVisible(){
        return errorMsg.isDisplayed();
    }
}
