package com.automation.pages.android;

import com.automation.pages.interfaces.WishlistPage;
import com.automation.utils.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidWishlistPage extends AndroidBasePage  implements WishlistPage {

    String productName="//*[contains(@content-desc,\"%s\")]";
    //String subString = productDetails.getAttribute("content-desc").substring(0,10);
    WebElement productDetailsName;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,'no wish-listed items')]")
    WebElement wishlistIsEmptyMessage;

    @Override
    public boolean verifyTheProductAppearsInTheWishlist() {

        return isDisplayed(String.format(productName, ConfigReader.getConfigValue("product.title")));
    }

    @Override
    public boolean verifyTheProductIsRemovedFromTheWishlist() {
        return isDisplayed(wishlistIsEmptyMessage);
    }
}
