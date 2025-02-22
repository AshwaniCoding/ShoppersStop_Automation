package com.automation.pages.interfaces;

public interface ProductsPage {
    default void verifySearchResultsAreRelevant(String productName) {
        
    }

    boolean isProductPageDisplayed();

    void clickOnTheFirstProduct();

    boolean isSearchResultsAreRelevant(String productName);

    void selectLowToHighSort();

    void isPriceSortedFromLowToHigh();

    void isPriceSortedFromHighToLow();

    void selectHighToLowSort();
}
