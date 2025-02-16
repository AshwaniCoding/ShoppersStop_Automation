package com.automation.pages.interfaces;

public interface HomePage {
    void openApplication();

    boolean isHomePageDisplayed();

    void clickOnMyAccountLink();

    void searchForProduct(String productName);

    void clickOnSearchBtn();

    default void clickOnLoginBtn() {
    }

<<<<<<< HEAD
    default boolean isUserLoggedOut() {
        return false;
    }

    boolean isMessageDisplayed(String message);

    void clickOnHomePageLink();
=======
    default void clickOnSearchButton() {

    }
>>>>>>> fa25a005d1db2293d205aa05ee48259da8756ff1
}
