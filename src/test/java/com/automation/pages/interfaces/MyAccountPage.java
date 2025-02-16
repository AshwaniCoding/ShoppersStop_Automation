package com.automation.pages.interfaces;

public interface MyAccountPage {

    boolean isUserLoggedIn();

    void clickOnLogoutButton();

    default void clickOnLoginBtn() {
    }
}
