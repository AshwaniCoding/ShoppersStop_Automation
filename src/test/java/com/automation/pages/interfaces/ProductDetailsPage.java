package com.automation.pages.interfaces;

public interface ProductDetailsPage {
    boolean isProductDetailsPageDisplayed();

    void clickOnAddToCartBtn();

    void clickOnCartLink();

    default void clickOnAddToWishlistButton() {

    }

    void saveProductName();


    default void clickOnWishlistLink() {

    }

    default void navigateToPreviousPage() {

    }

}
