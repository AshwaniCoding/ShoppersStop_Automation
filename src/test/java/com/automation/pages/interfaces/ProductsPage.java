package com.automation.pages.interfaces;

public interface ProductsPage {
    default void verifySearchResultsAreRelevant(String productName) {
        
    }

    boolean isProductPageDisplayed();

    void clickOnTheFirstProduct();

    boolean isSearchResultsAreRelevant(String productName);
}
