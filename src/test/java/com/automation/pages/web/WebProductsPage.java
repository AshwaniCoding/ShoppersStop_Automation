package com.automation.pages.web;

import com.automation.pages.interfaces.ProductsPage;
import com.automation.utils.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WebProductsPage extends WebBasePage implements ProductsPage {

    @FindBy(xpath = "//span[contains(text(),'Items')]")
    WebElement itemsTextElement;

    @FindBy(xpath = "//div[@data-item-type='ProdctSCCard']//div[@class='bg-transparent']")
    List<WebElement> productsList;

    @FindBy(xpath = "//div[@data-item-type='ProdctSCCard']//div[@class='bg-transparent']/div[contains(@class,'overflow-hidden')]")
    List<WebElement> productNamesList;

    @FindBy(xpath = "//span/following-sibling::img[@alt='chevron-down']")
    WebElement sortByIcon;

    @FindBy(xpath = "//*[contains(text(),'Price Low to High')]")
    WebElement lowToHighSortIcon;

    @FindBy(xpath = "//*[contains(text(),'Price High to Low')]")
    WebElement highToLowSortIcon;

    @FindBy(xpath = "//div[contains(@class,'text-xs !font-normal !leading-[16px]')]")
    List<WebElement> productPricesList;

    ArrayList<Integer> productPrices = new ArrayList<>();

    String baseFilterXpath = "//button[@type='button' and contains(text(),'%s')]";

    @FindBy(xpath = "//input[@placeholder=\"Search\"]")
    WebElement filterValueSearch;

    String filterValueOption= "//label[contains(@for,'%s')]";


    @FindBy(xpath = "//div[contains(@class,\"lg:text-sm xl:text-base mt-3 line-clamp-1\")]")
    List<WebElement> productsDisplayedList;

    @FindBy(xpath = "//div[contains(@class,'whitespace-nowrap text-base')]")
    WebElement appliedFilter;

    @Override
    public boolean isProductPageDisplayed() {
        return itemsTextElement.isDisplayed();
    }

    @Override
    public void clickOnTheFirstProduct() {
        productsList.getFirst().click();
    }

    @Override
    public boolean isSearchResultsAreRelevant(String productName) {
        int count = 0;
        for (WebElement product : productNamesList) {
            if (product.getText().contains(productName)) {
                count++;
            }
        }
        return count >= 5;
    }

    @Override
    public void selectLowToHighSort() {
        sortByIcon.click();
        pause(2);
        lowToHighSortIcon.click();
        pause(20);
    }

    @Override
    public void isPriceSortedFromLowToHigh() {
        for (WebElement we : productPricesList) {
            int productPrice = Integer.parseInt(we.getText().substring(1));
            System.out.println(productPrice + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            if (productPrices.size() > 0) {
                Assert.assertTrue(productPrice >= productPrices.getLast());
            }
            productPrices.add(productPrice);
            System.out.println(productPrices.getLast() + "++++++++++++++++++++++++++++++++");
        }
//        pause(2);
//        productsList = driver.findElements(By.xpath("//android.view.View[contains(@content-desc,'₹')]"));


    }

    @Override
    public void isPriceSortedFromHighToLow() {
        for (WebElement we : productPricesList) {
            int productPrice = Integer.parseInt(we.getText().substring(1));
            System.out.println(productPrice + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            if (productPrices.size() > 0) {
                Assert.assertTrue(productPrice <= productPrices.getLast());
            }
            productPrices.add(productPrice);
            System.out.println(productPrices.getLast() + "++++++++++++++++++++++++++++++++");
        }
    }

    @Override
    public void selectHighToLowSort() {
        sortByIcon.click();
        pause(2);
        highToLowSortIcon.click();
        pause(20);
    }

    @Override
    public void chooseFilters() {

    }

    @Override
    public void applyFilterByBrandWithValue(String filterBrandName) {
        WebElement brandFilter = driver.findElement(By.xpath(String.format(baseFilterXpath,"Brands")));
        brandFilter.click();
        filterValueSearch.click();
        filterValueSearch.sendKeys(ConfigReader.getConfigValue(filterBrandName));
        WebElement filterValueOptionToClick = driver.findElement(By.xpath(String.format(filterValueOption,ConfigReader.getConfigValue(filterBrandName))));
        filterValueOptionToClick.click();

    }

    @Override
    public boolean isBrandFilterAppliedOnProducts(String filterBrandName) {

        for(WebElement we:productsDisplayedList){
            if(we.getText().contains(filterBrandName)){

            }
            else{
                return false;
            }
        }
        return false;
    }

    @Override
    public void applyFilterByGenderWithValue(String filterGender) {
        WebElement genderFilter = driver.findElement(By.xpath(String.format(baseFilterXpath,"Gender")));
        genderFilter.click();
        WebElement filterValueToClick = driver.findElement(By.xpath(String.format(filterValueOption,ConfigReader.getConfigValue(filterGender))));
        filterValueToClick.click();
    }

    @Override
    public void applyFilterByPriceRange(String priceRange) {
        WebElement priceFilter = driver.findElement(By.xpath(String.format(baseFilterXpath,"Price")));
        priceFilter.click();
        pause(10);
        String lowerEndPrice=priceRange.substring(1,priceRange.indexOf(" ")) + "-";
        WebElement filterValueToClick = driver.findElement(By.xpath(String.format(filterValueOption,lowerEndPrice)));
        filterValueToClick.click();
        pause(10);
    }

    @Override
    public boolean isGenderFilterAppliedOnProducts(String filterGender) {
        for(WebElement we:productsDisplayedList){
            if(we.getText().contains(filterGender)){

            }
            else{
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean isPriceFilterAppliedOnProducts(String priceRange) {
        String lowerEndPrice=priceRange.substring(1,priceRange.indexOf(" ")) + "-";
        return appliedFilter.getText().contains(lowerEndPrice);
    }

}

