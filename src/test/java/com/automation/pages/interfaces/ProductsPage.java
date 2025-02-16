package com.automation.pages.interfaces;

public interface ProductsPage {
    default void verifySearchResultsAreRelevant(String productName) {
        
    }

<<<<<<< HEAD
    boolean isProductPageDisplayed();

    void clickOnFirstProduct();
=======
    default void chooseFilters() {

    }
>>>>>>> fa25a005d1db2293d205aa05ee48259da8756ff1
}
