package com.automation.pages.android;

import com.automation.pages.interfaces.MyAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidMyAccountPage extends AndroidBasePage implements MyAccountPage {

    @FindBy(xpath = "//android.view.View[contains(@content-desc,\"MANAGE YOUR PROFILE\")]/android.widget.ImageView[contains(@content-desc,\"Srinivas\")]")
    WebElement userDetails;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"LOGIN\"]")
    WebElement loginButton;

    @FindBy(xpath = "//android.view.View[@content-desc=\"LOGOUT\"]")
    WebElement logOutButton;

    @Override
    public boolean isUserLoggedIn() {
        pause(20000);
        return isDisplayed(userDetails);
    }

    @Override
    public void clickOnLogoutButton() {
//        int x = driver.manage().window().getSize().getWidth()/2;
        int y1=driver.manage().window().getSize().getHeight();
//        int y2 = driver.manage().window().getSize().getHeight();
        while (!isDisplayed(logOutButton) && !(logOutButton.getLocation().getY() <y1)){
            scrollDown();
            logOutButton = driver.findElement(By.xpath("//android.view.View[@content-desc=\"LOGOUT\"]"));
        }
        logOutButton.click();
    }

    @Override
    public void clickOnLoginBtn() {
        loginButton.click();
    }
}
