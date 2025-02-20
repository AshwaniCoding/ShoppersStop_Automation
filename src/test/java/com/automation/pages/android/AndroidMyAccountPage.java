package com.automation.pages.android;

import com.automation.pages.interfaces.MyAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidMyAccountPage extends AndroidBasePage implements MyAccountPage {

    @FindBy(xpath = "//android.view.View[contains(@content-desc,\"MANAGE YOUR PROFILE\")]")
    WebElement userDetails;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"LOGIN\"]")
    WebElement loginButton;

    @FindBy(xpath = "//android.view.View[@content-desc=\"LOGOUT\"]")
    WebElement logOutButton;

    @FindBy(xpath = "//android.view.View[@content-desc='YES,LOG OUT']")
    WebElement yesLogoutBtn;

    @FindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'My Profile')]")
    WebElement myProfileLink;

    @Override
    public boolean isUserLoggedIn() {
        pause(3);
        return isDisplayed(userDetails);
    }

    @Override
    public void clickOnLogoutButton() {
        while (!isDisplayed(logOutButton)) {
            scrollPage();
        }
        logOutButton.click();
        yesLogoutBtn.click();
    }

    @Override
    public void clickOnLoginBtn() {
        loginButton.click();
    }

    @Override
    public void clickOnMyProfileLink() {
        myProfileLink.click();
    }
}

