package com.automation.pages.web;

import com.automation.pages.interfaces.MyAccountPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebMyAccountPage extends WebBasePage implements MyAccountPage {

    @FindBy(xpath = "//p[contains(text(),'Hello,')]")
    WebElement helloUserTextElement;

    @FindBy(xpath = "//p[text()='Login']")
    WebElement loginLinkElement;

    @FindBy(xpath = "//div[text()='Logout']")
    WebElement logoutLink;

    @FindBy(xpath = "//p[text()='YES,LOG OUT']")
    WebElement yesLogoutBtn;

    @Override
    public boolean isUserLoggedIn() {
        pause(5);
        return isDisplayed(helloUserTextElement);
    }

    @Override
    public void clickOnLogoutButton() {
        logoutLink.click();
        yesLogoutBtn.click();
    }

    @Override
    public void clickOnLoginBtn() {
        loginLinkElement.click();
    }

}
