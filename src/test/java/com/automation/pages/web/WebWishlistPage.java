package com.automation.pages.web;

import com.automation.pages.interfaces.WishlistPage;
import com.automation.utils.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebWishlistPage extends WebBasePage implements WishlistPage {


    @FindBy(xpath = "//div[contains(text(),'no wish-listed items')]")
    WebElement emptyWishListMessage;

    String baseXpath = "//*[contains(text(),'%s')]";

    @Override
    public void verifyTheProductAppearsInTheWishlist() {
        //isDisplayed(WebProductDetailsPage.productName);
        WebElement productInWishListDetails = driver.findElement(By.xpath(String.format(baseXpath, ConfigReader.getConfigValue("product.title"))));
        Assert.assertTrue(isDisplayed(productInWishListDetails));
    }

    @Override
    public void verifyTheProductIsRemovedFromTheWishlist() {
        //isDisplayed(emptyWishListMessage);
        Assert.assertTrue(isDisplayed(emptyWishListMessage));
    }
}
