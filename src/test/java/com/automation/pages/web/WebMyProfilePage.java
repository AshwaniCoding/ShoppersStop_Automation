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

    @FindBy(xpath = "//div[contains(@class,'bg-white md:bg-neutral-100')]//div[text()='Edit']")
    List<WebElement> editBtnList;

    @FindBy(xpath = "//div[@role='dialog']//button/p[text()='Confirm']")
    WebElement confirmBtn;

    @FindBy(xpath = "//div[@role='dialog']//button/p[text()='UPDATE CHANGES']")
    WebElement updateChangesBtn;

    @FindBy(xpath = "//div[text()='Mobile No :']/../../following-sibling::div[text()='Edit']")
    WebElement editProfileLink;

    @FindBy(xpath = "//div[@role='dialog']//div[text()='Edit Profile']")
    WebElement editProfileSectionHeading;

    @FindBy(xpath = "//div[@role='dialog']//button/p[text()='update changes']")
    WebElement editProfileUpdateChangesBtn;

    @FindBy(xpath = "//div[@class='bg-transparent flex flex-col']/div")
    WebElement profileFullName;

    @FindBy(xpath = "//div[text()='Gender :']/following-sibling::div")
    WebElement profileGender;

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
    public void clickOnEditAddressLink(String name) {
        scrollToElement(addressHolderNamesList.getFirst());
        for (int i = 0; i < addressHolderNamesList.size(); i++) {
            if (addressHolderNamesList.get(i).getText().equalsIgnoreCase(name) || addressHolderNamesList.get(i).getText().toLowerCase().contains(name.toLowerCase())) {
                editBtnList.get(i).click();
                break;
            }
        }
    }

    @Override
    public boolean isEditAddressSectionDisplayed() {
        pause(2);
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
        pause(2);
        if (isDisplayed(addressHolderNamesList.getFirst())) {
            return (addressCountByName(name) + 1) == Integer.parseInt(ConfigReader.getConfigValue("address.count.by.name"));
        }
        return false;
    }

    @Override
    public void clickOnUpdateChangesBtn() {
        updateChangesBtn.click();
    }

    @Override
    public void updateAddressDetails() {

        String fullName = ConfigReader.getConfigValue("address.update.name");
        String mobile = ConfigReader.getConfigValue("address.update.mobile");
        String pinCode = ConfigReader.getConfigValue("address.update.pin.code");
        String fullAddress = ConfigReader.getConfigValue("address.update.full.address");
        String addressType = ConfigReader.getConfigValue("address.update.type");
        String locationName = ConfigReader.getConfigValue("address.update.location.name");

        updateField(fullNameInput, fullName);
        updateField(mobileInput, mobile);
        updateField(pinCodeInput, pinCode);
        updateField(fullAddressInput, fullAddress);

        scrollToElement(radioButtons.getFirst());
        pause(2);

        if (addressType != null && !addressType.isEmpty()) {
            if (addressType.equalsIgnoreCase("Work")) {
                radioButtons.get(1).click();
            } else if (addressType.equalsIgnoreCase("Other")) {
                radioButtons.getLast().click();
                updateField(locationNameInput, locationName);
            } else {
                radioButtons.getFirst().click();
            }
        }

    }

    @Override
    public boolean isAddressUpdated() {

        String fullName = ConfigReader.getConfigValue("address.update.name");
        String mobile = ConfigReader.getConfigValue("address.update.mobile");
        String pinCode = ConfigReader.getConfigValue("address.update.pin.code");
        String fullAddress = ConfigReader.getConfigValue("address.update.full.address");
        String addressType = ConfigReader.getConfigValue("address.update.type");
        String locationName = ConfigReader.getConfigValue("address.update.location.name");

        pause(2);

        for (int i = 0; i < addressTypeList.size(); i++) {

            boolean addressMatches = isFieldUpdated(addressType, addressTypeList.get(i));

            if (isFieldUpdated(locationName, addressTypeList.get(i))) {
                addressMatches = true;
            }

            if (isFieldUpdated(fullName, addressHolderNamesList.get(i))) {
                addressMatches = true;
            }

            if (isFieldUpdated(mobile, mobileNumberList.get(i))) {
                addressMatches = true;
            }

            if (isFieldUpdated(fullAddress, fullAddressList.get(i))) {
                addressMatches = true;
            }

            if (isFieldUpdated(pinCode, fullAddressList.get(i))) {
                addressMatches = true;
            }

            if (addressMatches) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void clickOnEditProfileBtn() {
        editProfileLink.click();
    }

    @Override
    public void clickOnEditProfileUpdateChangesBtn() {
        pause(2);
        editProfileUpdateChangesBtn.click();
    }

    @Override
    public void updateNameAndGender(String name, String gender) {

        updateField(fullNameInput, name);

        if (gender != null && !gender.isEmpty()) {
            if (gender.equalsIgnoreCase("Female")) {
                radioButtons.get(1).click();
            } else if (gender.equalsIgnoreCase("Other")) {
                radioButtons.getLast().click();
            } else {
                radioButtons.getFirst().click();
            }
        }

    }

    @Override
    public boolean isEditProfileSectionDisplayed() {
        pause(3);
        return isDisplayed(editProfileSectionHeading);
    }

    @Override
    public boolean isProfileUpdated(String name, String gender) {

        pause(5);

        if (profileFullName.getText().equalsIgnoreCase(name)) {
            return true;
        }

        return profileGender.getText().equalsIgnoreCase(name);
    }

    private boolean isFieldUpdated(String value, WebElement element) {
        return value != null && !value.trim().isEmpty() && element.getText().equalsIgnoreCase(value);
    }

    private int addressCountByName(String name) {
        int count = 0;
        for (WebElement element : addressHolderNamesList) {
            if (element.getText().trim().equalsIgnoreCase(name) || element.getText().trim().toLowerCase().contains(name.toLowerCase())) {
                count = count + 1;
            }
        }
        return count;
    }

    private void updateField(WebElement element, String value) {
        if (value != null && !value.trim().isEmpty()) {
            element.clear();
            element.sendKeys(value);
        }
    }


}
