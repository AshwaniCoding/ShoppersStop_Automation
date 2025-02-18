package com.automation.pages.android;

import com.automation.pages.interfaces.WishlistPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.automation.pages.android.AndroidProductDetailsPage.productDetails;

public class AndroidWishlistPage extends AndroidBasePage  implements WishlistPage {

    String productName="//android.view.View[contains(@content-desc,\"%s\")]";
    //String subString = productDetails.getAttribute("content-desc").substring(0,10);
    WebElement productDetailsName;

    @Override
    public boolean verifyTheProductAppearsInTheWishlist() {
        //productDetailsName = driver.findElement(By.xpath(String.format(productName,subString)));
        return productDetails.isDisplayed();
    }

    @Override
    public boolean verifyTheProductIsRemovedFromTheWishlist() {
        return isDisplayed(productDetails);
    }
}
