package com.automation.pages.web;

import com.automation.pages.interfaces.ProductsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WebProductsPage extends WebBasePage implements ProductsPage {

    @FindBy(xpath = "//span[contains(text(),'Items')]")
    WebElement itemsTextElement;

    @FindBy(xpath = "//div[@data-item-type='ProdctSCCard']//div[@class='bg-transparent']")
    List<WebElement> productsList;

    @FindBy(xpath = "//div[@data-item-type='ProdctSCCard']//div[@class='bg-transparent']/div[contains(@class,'overflow-hidden')]")
    List<WebElement> productNamesList;

    @FindBy(xpath = "//span/following-sibling::img[@alt='chevron-down']")
    WebElement sortByIcon;

    @FindBy(xpath = "//*[contains(text(),'Price Low to High')]")
    WebElement lowToHighSortIcon;

    @FindBy(xpath = "//*[contains(text(),'Price High to Low')]")
    WebElement highToLowSortIcon;

    @FindBy(xpath = "//div[contains(@class,'text-xs !font-normal !leading-[16px]')]")
    List<WebElement> productPricesList;

    ArrayList<Integer> productPrices = new ArrayList<>();

    @Override
    public boolean isProductPageDisplayed() {
        return itemsTextElement.isDisplayed();
    }

    @Override
    public void clickOnTheFirstProduct() {
        productsList.getFirst().click();
    }

    @Override
    public boolean isSearchResultsAreRelevant(String productName) {
        int count = 0;
        for (WebElement product : productNamesList) {
            if (product.getText().contains(productName)) {
                count++;
            }
        }
        return count >= 5;
    }

    @Override
    public void selectLowToHighSort() {
        sortByIcon.click();
        pause(2);
        lowToHighSortIcon.click();
        pause(20);
    }

    @Override
    public void isPriceSortedFromLowToHigh() {
        for (WebElement we : productPricesList) {
            int productPrice = Integer.parseInt(we.getText().substring(1));
            System.out.println(productPrice + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            if (productPrices.size() > 0) {
                Assert.assertTrue(productPrice >= productPrices.getLast());
            }
            productPrices.add(productPrice);
            System.out.println(productPrices.getLast() + "++++++++++++++++++++++++++++++++");
        }
//        pause(2);
//        productsList = driver.findElements(By.xpath("//android.view.View[contains(@content-desc,'₹')]"));


    }

    @Override
    public void isPriceSortedFromHighToLow() {
        for (WebElement we : productPricesList) {
            int productPrice = Integer.parseInt(we.getText().substring(1));
            System.out.println(productPrice + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            if (productPrices.size() > 0) {
                Assert.assertTrue(productPrice <= productPrices.getLast());
            }
            productPrices.add(productPrice);
            System.out.println(productPrices.getLast() + "++++++++++++++++++++++++++++++++");
        }
    }

    @Override
    public void selectHighToLowSort() {
        sortByIcon.click();
        pause(2);
        highToLowSortIcon.click();
        pause(20);
    }
}

