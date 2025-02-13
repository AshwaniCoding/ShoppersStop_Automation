package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidProductPage extends BasePage {
    String filterName;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"FILTER\"]")
    WebElement chooseFilterBtn;

    String filter = "//*[contains(@content-desc,'%s')]";

    @FindBy(xpath = "//*[contains(@content-desc,\"SHOW\")]")
    WebElement showItemsButton;

    public void chooseFilters() {
        chooseFilterBtn.click();
        List<String> list = ConfigReader.getPropertyByPartialKey("filter");
        for(String s: list){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            filterName = s.substring(0,s.indexOf('.'));
            WebElement filterToClick = driver.findElement(By.xpath(String.format(filter, filterName)));
            filterToClick.click();
            WebElement filterSubOption = driver.findElement(By.xpath(String.format(filter,ConfigReader.getConfigValue(s))));
            filterSubOption.click();
        }
        showItemsButton.click();

    }
}
