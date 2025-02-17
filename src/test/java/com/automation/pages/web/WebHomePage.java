package com.automation.pages.web;

import com.automation.pages.interfaces.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebHomePage extends WebBasePage implements HomePage {

    @FindBy(xpath = "//span[text()='Featured']")
    WebElement featuredTextElement;

    @FindBy(xpath = "//p[text()='Login']")
    WebElement loginLinkElement;

    @FindBy(xpath = "//p[contains(text(),'Hello,')]")
    WebElement helloUserTextElement;

    @FindBy(xpath = "//div[text()='My Profile']")
    WebElement myProfileLink;

    @FindBy(xpath = "//input[@placeholder='What are you looking for?']")
    WebElement searchInput;

    @FindBy(xpath = "//a[@href='/home']")
    WebElement homePageLink;

    String XPATH_MESSAGE = "//div[text()='%s']";

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
        if (!isDisplayed(loginLinkElement)) {
            moveToElement(helloUserTextElement);
            myProfileLink.click();
        }
    }

    @Override
    public void searchForProduct(String productName) {
        searchInput.click();
        searchInput.sendKeys(productName);
    }

    @Override
    public void clickOnSearchBtn() {
        searchInput.sendKeys(Keys.ENTER);
    }

    @Override
    public void clickOnLoginBtn() {
        loginLinkElement.click();
    }

    @Override
    public boolean isUserLoggedOut() {
        return isDisplayed(loginLinkElement);
    }

    @Override
    public boolean isMessageDisplayed(String message) {
        WebElement element = driver.findElement(By.xpath(String.format(XPATH_MESSAGE, message)));
        return isDisplayed(element);
    }

    @Override
    public void clickOnHomePageLink() {
        homePageLink.click();
    }


}
