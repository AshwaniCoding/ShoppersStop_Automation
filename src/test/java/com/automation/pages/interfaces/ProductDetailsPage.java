package com.automation.pages.interfaces;

public interface ProductDetailsPage {
    boolean isProductDetailsPageDisplayed();

    void clickOnAddToCartBtn();

    void clickOnCartLink();

    void clickOnAddToWishlistButton();

    void saveProductName();


    void clickOnWishlistLink();

    void navigateToPreviousPage();

    boolean isProductNameAndPriceDisplayed();

    boolean isProductDetailsAreDisplayed();
}
