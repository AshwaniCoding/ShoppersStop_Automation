package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.utils.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_and_dont_ask_again_button\"]")
    WebElement dontAllowBtn;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"What are you looking for?\"]")
    WebElement searchBar;

    @FindBy(xpath = "//android.widget.EditText")
    WebElement searchBar1;

    String updatedSearchBar = "//android.widget.ImageView[@text='%s']";

    String suggestion = "//android.view.View[@content-desc='%s']";

    public void clickOnDontAllow() {
        try{
            setImplicitWait(1000);
            dontAllowBtn.click();
        }catch (Exception e){
            System.out.println("Notification was not displayed");
        }
        setImplicitWait(60000);
    }

    public void searchFor(String item) {
        searchBar.click();
        searchBar1.click();
        searchBar1.sendKeys(ConfigReader.getConfigValue(item));
        searchBar1= driver.findElement(By.xpath(String.format(updatedSearchBar,ConfigReader.getConfigValue(item))));
        //searchBar1.sendKeys(Keys.ENTER);
        //AndroidDriver driver1 = (AndroidDriver)driver;
        //driver1.pressKey(AndroidKeyCode.KEYCODE_ENTER);
        WebElement suggestionToSelect = driver.findElement(By.xpath(String.format(suggestion,ConfigReader.getConfigValue(item))));
        suggestionToSelect.click();
    }
}
