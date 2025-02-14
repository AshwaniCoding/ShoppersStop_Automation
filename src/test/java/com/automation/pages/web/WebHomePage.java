package com.automation.pages.web;

import com.automation.pages.interfaces.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebHomePage extends WebBasePage implements HomePage {

    @FindBy(xpath = "//span[text()='Featured']")
    WebElement featuredTextElement;

    @FindBy(xpath = "//p[text()='Login']")
    WebElement loginLinkElement;

    @Override
    public void openApplication() {
        driver.get(ConfigReader.getConfigValue("web.url"));
    }

    @Override
    public boolean isHomePageDisplayed() {
        return isDisplayed(featuredTextElement);
    }

    @Override
    public void clickOnMyAccountLink() {
        loginLinkElement.click();
    }
}
