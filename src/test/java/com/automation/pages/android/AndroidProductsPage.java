package com.automation.pages.android;

import com.automation.pages.interfaces.ProductsPage;
import com.automation.utils.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidProductsPage extends AndroidBasePage implements ProductsPage {
    String filterName;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"FILTER\"]")
    WebElement chooseFilterBtn;

    String filter = "//*[contains(@content-desc,'%s')]";

    @FindBy(xpath = "//*[contains(@content-desc,\"SHOW\")]")
    WebElement showItemsButton;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,\"Watch\")]")
    List<WebElement> productNames;

    @FindBy(xpath = "//android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[@content-desc and @class=\"android.view.View\"]")
    List<WebElement> productNames2;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]//android.widget.FrameLayout/android.view.View//android.view.View/android.view.View[3]//android.view.View[3]/android.view.View/android.view.View/android.view.View[1]/android.view.View")
    WebElement firstProduct;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,'items')]")
    WebElement itemsTextElement;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='SORT ']")
    WebElement sortOption;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,'₹')]")
    List<WebElement> productsList;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"SORT \"]")
    WebElement sortIcon;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Price Low to High\"]")
    WebElement lowToHighSortIcon;

    public void chooseFilters() {
        chooseFilterBtn.click();
        List<String> list = ConfigReader.getPropertyByPartialKey("filter");
        for (String s : list) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            filterName = s.substring(0, s.indexOf('.'));
            WebElement filterToClick = driver.findElement(By.xpath(String.format(filter, filterName)));
            filterToClick.click();
            WebElement filterSubOption = driver.findElement(By.xpath(String.format(filter, ConfigReader.getConfigValue(s))));
            filterSubOption.click();
        }
        showItemsButton.click();

    }

    @Override
    public boolean isSearchResultsAreRelevant(String productName) {
        for (int i = 0; i < 3; i++) {
            for (WebElement we : productNames2) {
                try {
                    Assert.assertTrue(we.getAttribute("content-desc").contains(productName));
                } catch (AssertionError ae) {
                    return false;
                }
            }
        }
        return true;

    }

    @Override
    public void selectLowToHighSort() {
        sortIcon.click();
        lowToHighSortIcon.click();

    }

    @Override
    public void verifySearchResultsAreRelevant(String productName) {
//        Assert.assertEquals(productNames.size(),5);

        for (WebElement we : productNames2) {
            Assert.assertTrue(we.getText().contains(productName));
        }
    }

    @Override
    public boolean isProductPageDisplayed() {
        return isDisplayed(itemsTextElement);
    }

    @Override
    public void clickOnTheFirstProduct() {
        productsList.getFirst().click();
    }


}
