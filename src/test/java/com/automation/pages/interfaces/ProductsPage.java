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

    default void userApplyFilterByBrandWithValue(String filterBrandName) {

    }

    void chooseFilters();

    default void applyFilterByBrandWithValue(String filterBrandName) {

    }

    boolean isBrandFilterAppliedOnProducts(String filterBrandName);

    void applyFilterByGenderWithValue(String filterGender);

    void applyFilterByPriceRange(String priceRange);

    default boolean isGenderFilterAppliedOnProducts(String filterGender) {
        return false;
    }
}
