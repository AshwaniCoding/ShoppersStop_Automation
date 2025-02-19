package com.automation.pages.android;

import com.automation.pages.interfaces.CartPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidCartPage extends AndroidBasePage implements CartPage {

    @FindBy(xpath = "//android.view.View[@content-desc='My Bag']")
    WebElement myBagTextElement;

    @FindBy(xpath = "//android.view.View[@content-desc='Total MRP']")
    WebElement totalMrpTextElement;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,'₹ ')]")
    List<WebElement> productsInCart;

    @FindBy(xpath = "//android.widget.ScrollView/android.view.View[3]/android.view.View/android.view.View[@content-desc]")
    List<WebElement> itemsInCart;

    @FindBy(xpath = "//android.widget.ScrollView/android.view.View[3]/android.view.View/android.view.View[@content-desc]/android.widget.ImageView[2]")
    WebElement removeItemBtn;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,'bag is empty')]")
    WebElement cartIsEmptyMessage;
    @Override
    public boolean isCartPageDisplayed() {
        return isDisplayed(myBagTextElement);
    }

    @Override
    public boolean isProductPresentInCart() {

        String productCompanyName = ConfigReader.getConfigValue("product.company");
        String productTitle = ConfigReader.getConfigValue("product.title");

        while (!isDisplayed(totalMrpTextElement)) {
            for (WebElement product : productsInCart) {
                if (product.getAttribute("content-desc").contains(productCompanyName) && product.getAttribute("content-desc").contains(productTitle)) {
                    return true;
                }
            }
            scrollPage();
            productsInCart = driver.findElements(By.xpath("//android.view.View[contains(@content-desc,'₹ ')]"));
        }

        return false;
    }

    @Override
    public void removeAllItems() {
        for(WebElement item : itemsInCart){
            removeItemBtn.click();
        }

    }

    @Override
    public boolean isCartEmpty() {
        return isDisplayed(cartIsEmptyMessage);
    }

}
