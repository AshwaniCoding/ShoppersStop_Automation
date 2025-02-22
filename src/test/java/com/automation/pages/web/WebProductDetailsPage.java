package com.automation.pages.web;

import com.automation.pages.interfaces.ProductDetailsPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebProductDetailsPage extends WebBasePage implements ProductDetailsPage {

    @FindBy(xpath = "//h1/div[contains(@class,'select-text')]")
    WebElement productName;

    @FindBy(xpath = "//h1/div/div[contains(@class,'select-text')]")
    WebElement productCompanyName;

    @FindBy(xpath = "//div[text()='₹']")
    List<WebElement> productPrice;

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

    @FindBy(xpath = "//button[contains(@class,'inline-flex')]")
    WebElement addToWishlistLink;

    @FindBy(xpath = "//img[@alt='pdp_wishlist_add']/following-sibling::p[contains(@class,'action-text')]")
    WebElement updatedAddToWishlist;

    @FindBy(xpath = "//img[@alt='wish-list']")
    WebElement wishlistPageLink;

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
    public void clickOnAddToWishlistButton() {
        if (isDisplayed(addToWishlistLink)) {
            addToWishlistLink.click();
        } else {
            updatedAddToWishlist.click();
        }
    }

    @Override
    public void saveProductName() {
        ConfigReader.setConfigValue("product.company", productCompanyName.getText());
        ConfigReader.setConfigValue("0", productName.getText());
    }

    @Override
    public void clickOnWishlistLink() {
        wishlistPageLink.click();
    }

    @Override
    public void navigateToPreviousPage() {
        driver.navigate().back();
    }

    @Override
    public boolean isProductNameAndPriceDisplayed() {
        return isDisplayed(productName) && isDisplayed(productCompanyName) && isDisplayed(productPrice.getFirst());
    }

    @Override
    public boolean isProductDetailsAreDisplayed() {
        return isDisplayed(productDetailsBtn);
    }


}
