package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//img[@class='s-item__image-img']")
    private List<WebElement> goodsListIcons;
    @FindBy(xpath = "//span[@id='srp-ipp-menu']//span[@class='expand-btn__cell']/span/span")
    private WebElement itemsPerPage;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickGoodsListOnProduct(int number) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", goodsListIcons.get(number));
    }
    public int getGoodsListCount()
    {
        return goodsListIcons.size();
    }

}
