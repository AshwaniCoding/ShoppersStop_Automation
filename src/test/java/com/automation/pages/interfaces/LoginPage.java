package com.automation.pages.interfaces;

public interface LoginPage {
    void loginWithPhoneOrEmail(String phoneOrEmail);

    void enterOneTimePassword();

    boolean isErrorMessageDisplayed();

}
