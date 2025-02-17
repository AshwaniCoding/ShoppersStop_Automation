package com.automation.pages.android;

import com.automation.pages.interfaces.MyAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidMyAccountPage extends AndroidBasePage implements MyAccountPage {

    @FindBy(xpath = "//android.view.View[contains(@content-desc,\"MANAGE YOUR PROFILE\")]")
    WebElement userDetails;

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
        int y1 = driver.manage().window().getSize().getHeight();
//        int y2 = driver.manage().window().getSize().getHeight();
        while (!isDisplayed(logOutButton)) {
            scrollDown();
            System.out.println("isdisplayed>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
        //logOutButton = driver.findElement(By.xpath("//android.view.View[@content-desc=\"LOGOUT\"]"));

        logOutButton.click();
    }
}

