package com.automation.pages.web;

import com.automation.pages.interfaces.CartPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebCartPage extends WebBasePage implements CartPage {

    @FindBy(xpath = "//div[text()='Price Details']")
    WebElement priceDetailsText;

    @FindBy(xpath = "//div[@class='bg-transparent']//div[@class='w-full']//div[contains(@class,'justify-between')]//div[contains(@class,'text-neutral-900')]")
    List<WebElement> productCompanyNames;

    @FindBy(xpath = "//div[@class='bg-transparent']//div[@class='w-full']//div[contains(@class,'justify-between')]//div[contains(@class,'text-neutral-800')]")
    List<WebElement> productTitles;

    @FindBy(xpath = "//img[@alt='remove product']")
    List<WebElement> removeItemsLink;

    @FindBy(xpath = "//button/p[text()='REMOVE']")
    WebElement removeBtn;

    @FindBy(xpath = "//div[contains(text(),'your bag is empty')]")
    WebElement emptyBagTextElement;

    @Override
    public boolean isCartPageDisplayed() {
        return isDisplayed(priceDetailsText);
    }

    @Override
    public boolean isProductPresentInCart() {

        String productCompanyName = ConfigReader.getConfigValue("product.company");
        String productTitle = ConfigReader.getConfigValue("product.title");

        for (int i = 0; i < productTitles.size(); i++) {
            if (productTitles.get(i).getText().equals(productTitle) && productCompanyNames.get(i).getText().equals(productCompanyName)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void removeAllItems() {
        while (!removeItemsLink.isEmpty()) {
            removeItemsLink.getFirst().click();
            removeBtn.click();
            pause(5);
            removeItemsLink = driver.findElements(By.xpath("//img[@alt='remove product']"));
        }
    }

    @Override
    public boolean isCartEmpty() {
        return emptyBagTextElement.isDisplayed();
    }
}
