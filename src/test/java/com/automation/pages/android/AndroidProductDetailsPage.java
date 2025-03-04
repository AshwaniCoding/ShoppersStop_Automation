package com.automation.pages.android;

import com.automation.pages.interfaces.ProductDetailsPage;
import com.automation.utils.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidProductDetailsPage extends AndroidBasePage implements ProductDetailsPage {

    @FindBy(xpath = "//*[@content-desc='WISHLIST']")
    WebElement addToWishListButton;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"1\"]")
    WebElement myWishlistIcon;

    @FindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView[3]")
    WebElement updatedWishlistIcon;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='ADD TO BAG']")
    WebElement addToBagBtn;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"What are you looking for?\"]/preceding-sibling::android.widget.ImageView[4]")
    WebElement cartLink;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,'added to bag')]/android.widget.ImageView[1]")
    WebElement closeBtn;

    @FindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'HOME')]")
    WebElement homeLink;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,'MRP')]/preceding-sibling::android.view.View[@content-desc]")
    List<WebElement> productCompanyAndTitle;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='PRODUCT DETAILS']")
    WebElement productDetails;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,'₹')]")
    WebElement productPrice;

    @FindBy(xpath = "//android.view.View[@content-desc='Similar Products']")
    WebElement similarProductsTab;

    @Override
    public boolean isProductDetailsPageDisplayed() {
        return isDisplayed(addToBagBtn) && isDisplayed(addToWishListButton);
    }

    @Override
    public void clickOnAddToCartBtn() {
        addToBagBtn.click();
    }

    @Override
    public void clickOnCartLink() {
        if (isDisplayed(closeBtn)) {
            closeBtn.click();
        }

        navigateBack(homeLink);

        if (isDisplayed(homeLink)) {
            homeLink.click();
        }
        cartLink.click();
    }

    @Override
    public void clickOnAddToWishlistButton() {
        addToWishListButton.click();
    }

    @Override
    public void saveProductName() {
        ConfigReader.setConfigValue("product.company", productCompanyAndTitle.getFirst().getText());
        ConfigReader.setConfigValue("product.title", productCompanyAndTitle.getLast().getText());
    }

    @Override
    public void clickOnWishlistLink() {
        myWishlistIcon.click();
    }

    @Override
    public void navigateToPreviousPage() {
        driver.navigate().back();
    }

    @Override
    public boolean isProductNameAndPriceDisplayed() {
        pause(2);
        return isDisplayed(productCompanyAndTitle.getFirst()) && isDisplayed(productCompanyAndTitle.getLast()) && isDisplayed(productPrice);
    }

    @Override
    public boolean isProductDetailsAreDisplayed() {
        while (!isDisplayed(similarProductsTab)) {
            if (isDisplayed(productDetails)) {
                return true;
            }
            scrollPage();
        }
        return false;
    }

}
