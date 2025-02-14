package com.automation.pages.android;

import com.automation.pages.interfaces.LoginPage;

public class AndroidLoginPage extends AndroidBasePage implements LoginPage {
    @Override
    public void loginWithPhoneOrEmail(String phoneOrEmail) {

    }

    @Override
    public void enterOneTimePassword() {

    }

    @Override
    public boolean isErrorMessageDisplayed() {
        return false;
    }

}
