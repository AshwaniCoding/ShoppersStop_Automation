package com.automation.pages.interfaces;

public interface HomePage {
    void openApplication();

    boolean isHomePageDisplayed();

    void clickOnMyAccountLink();

    void searchForProduct(String productName);

    void clickOnSearchBtn();

    default void clickOnLoginBtn() {
    }

    boolean isUserLoggedOut();

    boolean isMessageDisplayed(String message);

    void clickOnHomePageLink();

    default void clickOnSearchButton() {

    }

}
