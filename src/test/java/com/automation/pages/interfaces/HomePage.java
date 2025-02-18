package com.automation.pages.interfaces;

public interface HomePage {
    void openApplication();

    boolean isHomePageDisplayed();

    void clickOnMyAccountLink();

    void searchForProduct(String productName);

    void clickOnSearchBtn();

    boolean isUserLoggedOut();

    void clickOnHomePageLink();

    default void clickOnSearchButton() {

    }

}
