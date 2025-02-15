package com.automation.pages.interfaces;

public interface MyAccountPage {

    boolean isUserLoggedIn();

    default void clickOnLogoutButton() {

    }
}
