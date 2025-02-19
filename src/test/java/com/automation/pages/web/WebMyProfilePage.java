package com.automation.pages.web;

import com.automation.pages.interfaces.MyProfilePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebMyProfilePage extends WebBasePage implements MyProfilePage {

    @FindBy(xpath = "//div[@class='bg-transparent']//div[text()='My Profile']")
    WebElement myProfileHeadingElement;

    @FindBy(xpath = "//div[text()='Add Address']")
    WebElement addAddressLink;

    @FindBy(xpath = "//div[@role='dialog']//button/p[text()='ADD ADDRESS']")
    WebElement addAddressBtn;

    @FindBy(xpath = "//div[@role='dialog']//div[text()='Add Address']")
    WebElement addAddressSectionHeading;

    @FindBy(xpath = "//div[@role='dialog']//div[text()='Edit Address']")
    WebElement editAddressSectionHeading;

    @FindBy(xpath = "//p[text()='Default']//ancestor::div[contains(@class,'neutral-100')]//div[text()='Edit']")
    WebElement defaultAddressEditLink;

    @FindBy(id = "Name")
    WebElement fullNameInput;

    @FindBy(id = "Mobile No.")
    WebElement mobileInput;

    @FindBy(id = "Pin Code")
    WebElement pinCodeInput;

    @FindBy(id = "Address")
    WebElement fullAddressInput;

    @FindBy(id = "Location Name")
    WebElement locationNameInput;

    @FindBy(xpath = "//button[@role='radio']/following-sibling::label/div/div")
    List<WebElement> radioButtons;

    @FindBy(xpath = "//div[contains(@class,'bg-white md:bg-neutral-100')]/p")
    List<WebElement> addressHolderNamesList;

    @FindBy(xpath = "//div[contains(@class,'bg-white md:bg-neutral-100')]/div/div[contains(@class,'border-neutral-400')]")
    List<WebElement> addressTypeList;

    @FindBy(xpath = "//div[contains(@class,'bg-white md:bg-neutral-100')]//div[text()='Phone: +91 ']")
    List<WebElement> mobileNumberList;

    @FindBy(xpath = "//div[contains(@class,'bg-white md:bg-neutral-100')]//div[contains(@class,'md:w-[88%]')]")
    List<WebElement> fullAddressList;

    @FindBy(xpath = "//div[contains(@class,'bg-white md:bg-neutral-100')]//div[text()='Delete']")
    List<WebElement> deleteBtnList;

    @FindBy(xpath = "//div[@role='dialog']//button/p[text()='Confirm']")
    WebElement confirmBtn;

    @Override
    public boolean isMyProfilePageDisplayed() {
        return isDisplayed(myProfileHeadingElement);
    }

    @Override
    public void clickOnAddAddressLink() {
        addAddressLink.click();
    }

    @Override
    public boolean isAddAddressSectionDisplayed() {
        pause(2);
        return isDisplayed(addAddressSectionHeading);
    }

    @Override
    public void clickOnEditAddressLink() {
        defaultAddressEditLink.click();
    }

    @Override
    public boolean isEditAddressSectionDisplayed() {
        return isDisplayed(editAddressSectionHeading);
    }

    @Override
    public void clickOnAddAddressBtn() {
        addAddressBtn.click();
    }

    @Override
    public void enterAddressDetails() {

        String fullName = ConfigReader.getConfigValue("address.name");
        String mobile = ConfigReader.getConfigValue("address.mobile");
        String pinCode = ConfigReader.getConfigValue("address.pin.code");
        String fullAddress = ConfigReader.getConfigValue("address.full.address");
        String addressType = ConfigReader.getConfigValue("address.type");
        String locationName = ConfigReader.getConfigValue("address.location.name");

        fullNameInput.sendKeys(fullName);
        mobileInput.sendKeys(mobile);
        pinCodeInput.sendKeys(pinCode);
        fullAddressInput.sendKeys(fullAddress);

        scrollToElement(radioButtons.getFirst());
        pause(2);

        if (addressType.equalsIgnoreCase("Work")) {
            radioButtons.get(1).click();
        } else if (addressType.equalsIgnoreCase("Other")) {
            radioButtons.getLast().click();
            locationNameInput.sendKeys(locationName);
        } else {
            radioButtons.getFirst().click();
        }

    }

    @Override
    public boolean isNewAddressAdded() {

        String fullName = ConfigReader.getConfigValue("address.name");
        String mobile = ConfigReader.getConfigValue("address.mobile");
        String pinCode = ConfigReader.getConfigValue("address.pin.code");
        String fullAddress = ConfigReader.getConfigValue("address.full.address");
        String addressType = ConfigReader.getConfigValue("address.type");
        String locationName = ConfigReader.getConfigValue("address.location.name");

        pause(2);

        for (int i = 0; i < addressTypeList.size(); i++) {
            if (addressTypeList.get(i).getText().equalsIgnoreCase(addressType) || addressTypeList.get(i).getText().equalsIgnoreCase(locationName)) {
                if (addressHolderNamesList.get(i).getText().equals(fullName)) {
                    if (mobileNumberList.get(i).getText().contains(mobile)) {
                        if (fullAddressList.get(i).getText().toLowerCase().contains(fullAddress.toLowerCase()) && fullAddressList.get(i).getText().contains(pinCode)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    @Override
    public void clickOnDeleteAddressLink(String name) {

        ConfigReader.setConfigValue("address.count.by.name", String.valueOf(addressCountByName(name)));
        scrollToElement(addressHolderNamesList.getFirst());
        for (int i = 0; i < addressHolderNamesList.size(); i++) {
            if (addressHolderNamesList.get(i).getText().equalsIgnoreCase(name) || addressHolderNamesList.get(i).getText().toLowerCase().contains(name.toLowerCase())) {
                deleteBtnList.get(i).click();
                break;
            }
        }
    }

    @Override
    public void clickOnConfirmBtn() {
        confirmBtn.click();
    }

    @Override
    public boolean isAddressDeleted(String name) {
        return (addressCountByName(name) + 1) == Integer.parseInt(ConfigReader.getConfigValue("address.count.by.name"));
    }

    public int addressCountByName(String name) {
        int count = 0;
        for (WebElement element : addressHolderNamesList) {
            if (element.getText().trim().equalsIgnoreCase(name) || element.getText().trim().toLowerCase().contains(name.toLowerCase())) {
                count = count + 1;
            }
        }
        System.out.println(count);
        return count;
    }
}
