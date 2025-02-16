package com.automation.pages.web;

import com.automation.pages.interfaces.ProductDetailsPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebProductDetailsPage extends WebBasePage implements ProductDetailsPage {

    @FindBy(xpath = "//h1/div[contains(@class,'select-text')]")
    WebElement productName;

    @FindBy(xpath = "//h1/div/div[contains(@class,'select-text')]")
    WebElement productCompanyName;

    @FindBy(xpath = "//p[text()='Add to bag']")
    WebElement addToBagBtn;

    @FindBy(xpath = "//button[text()='Product Details']")
    WebElement productDetailsBtn;

    @FindBy(xpath = "//p[text()='WISHLIST']")
    WebElement wishlistBtn;

    @FindBy(xpath = "//div[@role='dialog']//button/img[@alt='cross']")
    WebElement closeBtn;

    @FindBy(xpath = "//img[@alt='shopping-cart']")
    WebElement cartLink;


    @Override
    public boolean isProductDetailsPageDisplayed() {
        pause(2);
        switchToNewTab();
        return productDetailsBtn.isDisplayed();
    }

    @Override
    public void clickOnAddToCartBtn() {
        addToBagBtn.click();
    }

    @Override
    public void clickOnCartLink() {
        pause(5);
        if (isDisplayed(closeBtn)) {
            closeBtn.click();
        }
        cartLink.click();
    }

    @Override
    public void saveProductName() {
        ConfigReader.setConfigValue("product.company", productCompanyName.getText());
        ConfigReader.setConfigValue("product.title", productName.getText());
    }

}
