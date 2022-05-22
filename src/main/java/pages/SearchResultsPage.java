package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//img[@class='s-item__image-img']")
    private List<WebElement> goodsListIcons;
    @FindBy(xpath = "//span[@class='prRange' or @class='bold']")
    private List<WebElement> priceList;
    @FindBy(xpath = "//span[@id='srp-ipp-menu']//span[@class='expand-btn__cell']/span/span")
    private WebElement itemsPerPage;
    @FindBy(xpath = "//input[@class='price' and @name='_udlo']")
    private WebElement lowPrice;
    @FindBy(xpath = "//input[@class='price' and @name='_udhi']")
    private WebElement hiPrice;
    @FindBy(xpath = "//input[@id='_nkw']")
    private WebElement keywordInput;
    @FindBy(xpath = "//button[@id='searchBtnLowerLnk']")
    private WebElement searchButton;

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
    public void inputLowPrice(String lp){
        lowPrice.sendKeys(lp);
    }
    public void inputHiPrice(String hp){
        hiPrice.sendKeys(hp);
    }
    public void searchButtonClick(){
        searchButton.click();
    }
    public void inputKeyword(String keyword){
        keywordInput.sendKeys(keyword);
    }
    public List<Float> getPriceListResult() {
        List<Float> prices = new ArrayList<>(10);
        float price = 0;
        int indexOfSymbolTinRangePrice;
        for (WebElement WebEl : priceList) {
            indexOfSymbolTinRangePrice = WebEl.getText().indexOf('t');
            if (indexOfSymbolTinRangePrice == -1) {
                price = Float.parseFloat(WebEl.getText().substring(1));
            } else {
                price = Float.parseFloat(WebEl.getText().substring(1, indexOfSymbolTinRangePrice));
            }
        }
        prices.add(price);
        return prices;
    }
}
