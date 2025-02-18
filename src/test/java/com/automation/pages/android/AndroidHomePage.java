package com.automation.pages.android;

import com.automation.pages.interfaces.HomePage;
import com.automation.utils.ConfigReader;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidHomePage extends AndroidBasePage implements HomePage {

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_button\"]")
    WebElement doNotAllowNotificationBtn;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"What are you looking for?\"]")
    WebElement searchBar;

    @FindBy(xpath = "//android.widget.EditText")
    WebElement searchBarInput;

    //Added on 13/2
    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.widget.ImageView[1]")
    WebElement applicationHeader;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,'Hello')]")
    WebElement applicationSubHeading;

    String updatedSearchBar = "//android.widget.ImageView[@text='%s']";

    String suggestion = "//android.view.View[@content-desc='%s']";

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"ACCOUNT, Tab 5 of 5\"]")
    WebElement myAccountElement;

    @FindBy(xpath = "//android.view.View[@content-desc='SKIP']")
    WebElement skipPopUp;

    WebElement suggestedOption;

    @FindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'HOME')]")
    WebElement homeLink;

    @Override
    public void openApplication() {
        doNotAllowNotificationBtn.click();
    }

    @Override
    public boolean isHomePageDisplayed() {
        return homeLink.getAttribute("selected").equals("true");
    }

    @Override
    public void clickOnMyAccountLink() {
        myAccountElement.click();
    }

    @Override
    public void searchForProduct(String productName) {

        if (isDisplayed(homeLink)) {
            homeLink.click();
        }
        searchBar.click();

        System.out.println("Before randoCLicl1");
        randomClick();
        System.out.println("After random click1");
        searchBarInput.click();
        searchBarInput.sendKeys(productName);
    }

    @Override
    public void clickOnSearchBtn() {
        pause(5);
        ((AndroidDriver) driver).executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
        pause(5);
    }

    @Override
    public boolean isUserLoggedOut() {
        return false;
    }

    @Override
    public void clickOnHomePageLink() {
        navigateBack(homeLink);
    }

    @Override
    public void clickOnSearchButton() {
//        while(isDisplayed(suggestedOption)){
//            suggestedOption.click();
//        }

        suggestedOption.click();
        suggestedOption.click();
    }
}
