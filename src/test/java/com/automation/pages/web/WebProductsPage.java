package com.automation.pages.web;

import com.automation.pages.interfaces.ProductsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebProductsPage extends WebBasePage implements ProductsPage {

    @FindBy(xpath = "//span[contains(text(),'Items')]")
    WebElement itemsTextElement;

    @FindBy(xpath = "//div[@data-item-type='ProdctSCCard']//div[@class='bg-transparent']")
    List<WebElement> productsList;

    @Override
    public boolean isProductPageDisplayed() {
        return itemsTextElement.isDisplayed();
    }

    @Override
    public void clickOnFirstProduct() {
        productsList.getFirst().click();
    }
}
