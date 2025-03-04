package com.automation.pages.android;

import com.automation.pages.interfaces.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AndroidLoginPage extends AndroidBasePage implements LoginPage {

    @FindBy(xpath = "//android.widget.EditText")
    WebElement phoneOrEmailInput;

    @FindBy(xpath = "//android.view.View[@content-desc=\"PROCEED\"]")
    WebElement proceedButton;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Please enter a valid phone number\"]")
    WebElement userIdErrorMessage1;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Invalid email or phone number format\"]")
    WebElement userIdErrorMessage2;

    @FindBy(xpath = "//android.view.View[@content-desc=\"VERIFY OTP\"]")
    WebElement verifyOtpButton;

    @Override
    public void loginWithPhoneOrEmail(String phoneOrEmail) {
        phoneOrEmailInput.click();
        phoneOrEmailInput.sendKeys(phoneOrEmail);

        if (proceedButton.getAttribute("clickable").equals("true")) {
            proceedButton.click();
        }
    }

    @Override
    public void enterOneTimePassword() {
        wait.until(ExpectedConditions.attributeToBe(verifyOtpButton, "clickable", "true"));
        while (isDisplayed(verifyOtpButton)) {
            verifyOtpButton.click();
        }
    }

    @Override
    public boolean isErrorMessageDisplayed() {

        return (isDisplayed(userIdErrorMessage1) || isDisplayed(userIdErrorMessage2));
    }

}
