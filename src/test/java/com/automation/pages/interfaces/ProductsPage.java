package com.automation.pages.interfaces;

public interface ProductsPage {
    default void verifySearchResultsAreRelevant(String productName) {

    }

    boolean isProductPageDisplayed();

    void clickOnFirstProduct();

    default void chooseFilters() {

    }

    boolean isSearchResultsAreRelevant(String productName);
}
