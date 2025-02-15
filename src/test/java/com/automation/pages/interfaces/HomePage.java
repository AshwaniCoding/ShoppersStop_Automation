package com.automation.pages.interfaces;

public interface HomePage {
    void openApplication();

    boolean isHomePageDisplayed();

    void clickOnMyAccountLink();

    default void searchForProduct(String productName) {

    }
}
