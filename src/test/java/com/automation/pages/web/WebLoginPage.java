package com.automation.pages.web;

import com.automation.pages.interfaces.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebLoginPage extends WebBasePage implements LoginPage {

    @FindBy(xpath = "//input[@id='Enter your phone or email ID']")
    WebElement phoneOrEmailInput;

    @FindBy(xpath = "//p[text()='PROCEED']/..")
    WebElement proceedBtn;

    @FindBy(xpath = "//p[contains(text(),'VERIFY OTP')]/..")
    WebElement verifyOtpBtn;

    @FindBy(xpath = "//div[text()='Invalid email or phone number format']")
    WebElement invalidEmailOrPhoneErrorMessage;

    @Override
    public void loginWithPhoneOrEmail(String phoneOrEmail) {
        phoneOrEmailInput.sendKeys(phoneOrEmail);
        if (proceedBtn.isEnabled()) {
            proceedBtn.click();
        }
    }

    @Override
    public void enterOneTimePassword() {
        while (!verifyOtpBtn.isEnabled()) {

        }
        verifyOtpBtn.click();
    }

    @Override
    public boolean isErrorMessageDisplayed() {
        return isDisplayed(invalidEmailOrPhoneErrorMessage);
    }

}
