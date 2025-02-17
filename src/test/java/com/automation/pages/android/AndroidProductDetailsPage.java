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

    @Override
    public boolean isProductDetailsPageDisplayed() {
        return productDetailsPage.isDisplayed();
    }

    @Override
    public void clickOnAddToCartBtn() {

    }

    @Override
    public void clickOnCartLink() {

    }

    @Override
    public void clickOnAddToWishlistButton() {
        addToWishListButton.click();
    }

    @Override
    public void saveProductName() {

    }

    @Override
    public void clickOnWishlistLink() {
        myWishlistIcon.click();
    }

    @Override
    public void navigateToPreviousPage() {
        driver.navigate().back();
    }

}
