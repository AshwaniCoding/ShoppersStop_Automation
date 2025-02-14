package com.automation.pages.web;

import com.automation.pages.interfaces.MyAccountPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebMyAccountPage extends WebBasePage implements MyAccountPage {

    @FindBy(xpath = "//p[contains(text(),'Hello,')]")
    WebElement helloUserTextElement;

    @Override
    public boolean isUserLoggedIn() {
        pause(5);
        return isDisplayed(helloUserTextElement);
    }
}
