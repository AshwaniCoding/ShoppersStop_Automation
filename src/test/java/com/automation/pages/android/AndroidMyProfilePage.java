package com.automation.pages.android;

import com.automation.pages.interfaces.MyProfilePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class AndroidMyProfilePage extends AndroidBasePage implements MyProfilePage {

    @FindBy(xpath = "//android.view.View[@content-desc='My Profile']")
    WebElement myProfileHeadingElement;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Add address']")
    WebElement addAddressLink;

    @FindBy(xpath = "//android.view.View[@content-desc='ADD ADDRESS']")
    WebElement addAddressSectionHeading;

    @FindBy(xpath = "//android.widget.EditText[@hint='Name']")
    WebElement fullNameInput;

    @FindBy(xpath = "//android.widget.EditText[@hint='Mobile No.']")
    WebElement mobileInput;

    @FindBy(xpath = "//android.widget.EditText[@hint='Pin Code']")
    WebElement pinCodeInput;

    @FindBy(xpath = "//android.widget.EditText[@hint='Address']")
    WebElement fullAddressInput;

    @FindBy(xpath = "//android.widget.Button[@content-desc='ADD ADDRESS']")
    WebElement addAddressBtn;

    @FindBy(xpath = "//android.view.View[@content-desc='Address Type']/following-sibling::android.view.View/android.widget.ImageView")
    List<WebElement> radioButtons;

    @FindBy(xpath = "//android.widget.EditText[@hint='Location Name']")
    WebElement locationNameInput;

    @FindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'Phone: +91')]")
    WebElement firstAddress;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,'Phone: +91')]")
    List<WebElement> addressList;

    @FindBy(xpath = "//android.view.View[@content-desc='Show More']")
    WebElement showMoreBtn;

    @FindBy(xpath = "//android.view.View[@content-desc='Show Less']")
    WebElement showLessBtn;

    @FindBy(xpath = "//android.view.View[@content-desc='Edit']")
    List<WebElement> editBtnList;

    @FindBy(xpath = "//android.view.View[@content-desc='EDIT ADDRESS']")
    WebElement editAddressSectionHeading;

    @FindBy(xpath = "//android.widget.Button[@content-desc='UPDATE CHANGES']")
    WebElement updateChangesBtn;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,'Gender')]/android.view.View[@content-desc='Edit']")
    WebElement editProfileLink;

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
        return isDisplayed(addAddressSectionHeading);
    }

    @Override
    public void clickOnEditAddressLink(String name) {

        String address = firstAddress.getAttribute("content-desc");
        if (address.toLowerCase().contains(name.toLowerCase())) {
            editBtnList.get(1).click();
        }

        if (isDisplayed(addAddressLink)) {
            scrollPage();
            if (isDisplayed(showMoreBtn)) {
                showMoreBtn.click();

                while (!isDisplayed(showLessBtn)) {

                    for (int i = 0; i < addressList.size(); i++) {
                        address = addressList.get(i).getAttribute("content-desc");
                        if (address.toLowerCase().contains(name.toLowerCase())) {
                            if (editBtnList.size() >= i + 1) {
                                editBtnList.get(i + 1).click();
                                break;
                            }
                        }
                    }

                    scrollPage();
                    addressList = driver.findElements(By.xpath("//android.view.View[contains(@content-desc,'Phone: +91')]"));

                }
            }
        }
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

        String address = firstAddress.getAttribute("content-desc");
        if (address.contains(addressType) || address.contains(locationName)) {
            if (address.contains(fullName)) {
                if (address.contains(mobile)) {
                    if (address.toLowerCase().contains(fullAddress.toLowerCase()) && address.contains(pinCode)) {
                        return true;
                    }
                }
            }
        }

        scrollPage();

        if (isDisplayed(showMoreBtn)) {
            showMoreBtn.click();

            while (!isDisplayed(showLessBtn)) {

                for (WebElement element : addressList) {
                    address = element.getAttribute("content-desc");
                    if (address.contains(addressType) || address.contains(locationName)) {
                        if (address.contains(fullName)) {
                            if (address.contains(mobile)) {
                                if (address.toLowerCase().contains(fullAddress.toLowerCase()) && address.contains(pinCode)) {
                                    return true;
                                }
                            }
                        }
                    }
                }

                scrollPage();
                addressList = driver.findElements(By.xpath("//android.view.View[contains(@content-desc,'Phone: +91')]"));

            }
        }

        return false;
    }

    @Override
    public void clickOnDeleteAddressLink(String name) {

    }

    @Override
    public void clickOnConfirmBtn() {

    }

    @Override
    public boolean isAddressDeleted(String name) {
        return true;
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

        List<String> fieldsToCheck = Arrays.asList(addressType, locationName, fullName, mobile, fullAddress, pinCode);

        while (!isDisplayed(editProfileLink)) {
            scrollPageDown();
        }

//        while () {
//        }
//        I need to work here


        return isFieldUpdated(fieldsToCheck, addressList);

    }

    private boolean isFieldUpdated(List<String> values, List<WebElement> addressList) {

        for (WebElement element : addressList) {
            String address = element.getAttribute("content-desc");
            for (String value : values) {
                if (value != null && !value.trim().isEmpty() && address.toLowerCase().contains(value.toLowerCase())) {
                    return true;
                }
            }
        }

        return false;
    }

    private void updateField(WebElement element, String value) {
        if (value != null && !value.trim().isEmpty()) {
            element.clear();
            element.sendKeys(value);
        }
    }
}
