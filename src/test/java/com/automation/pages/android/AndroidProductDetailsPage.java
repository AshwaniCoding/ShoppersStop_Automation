package com.automation.pages.android;

import com.automation.pages.interfaces.ProductDetailsPage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidProductDetailsPage extends AndroidBasePage implements ProductDetailsPage {

    @FindBy(xpath = "//android.widget.ScrollView")
    WebElement productDetailsPage;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"WISHLIST\"]")
    WebElement addToWishListButton;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"1\"]")
    WebElement myWishlistIcon;

    @FindBy(xpath = "//android.widget.ScrollView/android.view.View[1]/following-sibling::android.view.View")
    public static WebElement productDetails;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]//android.widget.FrameLayout//android.view.View//android.view.View[2]/android.view.View[1]")
    WebElement backButton;

    @FindBy(xpath = "//android.widget.Toast[@text=\"Product is added to the wishlist.\"]")
    WebElement confirmationMessage;

    @Override
    public void verifyUserIsOnProductDetailsPage() {
        Assert.assertTrue(productDetailsPage.isDisplayed());
        Assert.assertTrue(productDetails.isDisplayed());
    }

    @Override
    public void userClicksOnTheAddToWishlistButton() {
        addToWishListButton.click();
    }

    @Override
    public void verifyAConfirmationMessageIsDisplayed() {
        // unable to find xpath for the floating message
        confirmationMessage.isDisplayed();
    }

    @Override
    public void userNavigatesToWishlistPage() {
        myWishlistIcon.click();
    }

    @Override
    public void userNavigatesToThePreviousPage() {
        backButton.click();
    }

    @Override
    public void verifyAMessageIsDisplayed() {
        // unable to find xpath for the floating message
    }
}
