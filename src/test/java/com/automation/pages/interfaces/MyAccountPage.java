package com.automation.pages.interfaces;

public interface MyAccountPage {

    boolean isUserLoggedIn();

    void clickOnLogoutButton();

    void clickOnLoginBtn();

    default void clickOnMyProfileLink(){}
}
