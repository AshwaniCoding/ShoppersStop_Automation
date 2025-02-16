package com.automation.pages.interfaces;

public interface HomePage {
    void openApplication();

    boolean isHomePageDisplayed();

    void clickOnMyAccountLink();

    void searchForProduct(String productName);

    void clickOnSearchBtn();

    default void clickOnLoginBtn() {
    }

    default boolean isUserLoggedOut() {
        return false;
    }

    boolean isMessageDisplayed(String message);

    void clickOnHomePageLink();
}
