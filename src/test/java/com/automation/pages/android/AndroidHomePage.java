package com.automation.pages.android;

import com.automation.pages.interfaces.HomePage;
import com.automation.utils.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AndroidHomePage extends AndroidBasePage implements HomePage {

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_and_dont_ask_again_button\"]")
    WebElement doNotAllowNotificationBtn;


    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"What are you looking for?\"]")
    WebElement searchBar;

    @FindBy(xpath = "//android.widget.EditText")
    WebElement searchBarInput;

    //Added on 13/2
    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.widget.ImageView[1]")
    WebElement applicationHeader;

    String updatedSearchBar = "//android.widget.ImageView[@text='%s']";

    String suggestion = "//android.view.View[@content-desc='%s']";
        //searchSuggestion

    @FindBy(xpath="//android.widget.ImageView[@content-desc=\"ACCOUNT, Tab 5 of 5\"]")
    WebElement accountTab;

    @FindBy(xpath="//android.widget.Button[@content-desc=\"LOGIN\"]")
    WebElement loginButton;

    @FindBy(xpath = "//android.widget.EditText")
    WebElement usernameInput;

    @FindBy(xpath = "//android.view.View[@content-desc=\"PROCEED\"]")
    WebElement proceedButton;

    @FindBy(xpath = "//android.view.View[@content-desc=\"VERIFY OTP\"]")
    WebElement verifyOtpButton;

    @FindBy(xpath="//android.widget.ImageView[contains(@content-desc, 'Become')]")
    WebElement userDetails;

                //isHomePageDisplayed
    public void isHomePageDisplayed() {
        //Handling uncertainty of notification
        try{
            setImplicitWait(1000);
            doNotAllowNotificationBtn.click();
        }catch (Exception e){
            System.out.println("Notification was not displayed");
        }
        setImplicitWait(60000);

        Assert.assertTrue(applicationHeader.isDisplayed());
        
    }

    public void searchFor(String item) {
        searchBar.click();
        searchBarInput.click();
        searchBarInput.sendKeys(ConfigReader.getConfigValue(item));
        searchBarInput = driver.findElement(By.xpath(String.format(updatedSearchBar,ConfigReader.getConfigValue(item))));
        //searchBarInput.sendKeys(Keys.ENTER);
        //AndroidDriver driver1 = (AndroidDriver)driver;
        //driver1.pressKey(AndroidKeyCode.KEYCODE_ENTER);
        WebElement suggestionToSelect = driver.findElement(By.xpath(String.format(suggestion,ConfigReader.getConfigValue(item))));
        suggestionToSelect.click();
    }

    public void verifyUserIsOnHomePage() {
        Assert.assertTrue(applicationHeader.isDisplayed());
        Assert.assertTrue((searchBar.isDisplayed()));
    }

    public void loginWithUserCredential(String loginCredentials) {
        accountTab.click();
        loginButton.click();
        usernameInput.click();
        usernameInput.sendKeys(ConfigReader.getConfigValue(loginCredentials));
        proceedButton.click();
    }

    public void verifyUserEnteredOtp() {
        wait.until(ExpectedConditions.elementToBeClickable(verifyOtpButton));
        Assert.assertTrue(verifyOtpButton.isEnabled());
        verifyOtpButton.click();
        verifyOtpButton.click();
    }

    public void verifyUserIsOnMyAccountPage() {
        userDetails.isDisplayed();
    }
}
