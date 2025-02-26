package com.automation.pages.android;

import com.automation.pages.interfaces.MyProfilePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

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

//    @FindBy(xpath = "//android.view.View[contains(@content-desc,'Phone: +91')]")
//    List<WebElement> addressList;

    @FindBy(xpath = "//*[contains(@content-desc,'Phone: +91')]")
    List<WebElement> addressList;

    @FindBy(xpath = "//android.view.View[@content-desc='Show More']")
    WebElement showMoreBtn;

    @FindBy(xpath = "//android.view.View[@content-desc='Show Less']")
    WebElement showLessBtn;

//    @FindBy(xpath = "//android.view.View[@content-desc='Edit']")
//    List<WebElement> editBtnList;

    @FindBy(xpath = "//*[contains(@content-desc,'Phone: +91')]//android.view.View[@content-desc='Edit']")
    List<WebElement> editBtnList;

    @FindBy(xpath = "//android.view.View[@content-desc='EDIT ADDRESS']")
    WebElement editAddressSectionHeading;

    @FindBy(xpath = "//android.widget.Button[@content-desc='UPDATE CHANGES']")
    WebElement updateChangesBtn;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,'Gender')]/android.view.View[@content-desc='Edit']")
    WebElement editProfileLink;

    @FindBy(xpath = "//*[contains(@content-desc,'Phone: +91')]//android.view.View[@content-desc='Delete']")
    List<WebElement> deleteBtnList;

    @FindBy(xpath = "//android.view.View[@content-desc='CONFIRM']")
    WebElement confirmBtn;

    @FindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'My Profile')]")
    WebElement myProfileLink;

    @FindBy(xpath = "//android.view.View[@content-desc='Become a First Citizen Club Member']")
    WebElement becomeClubMemberTextElement;

    @FindBy(xpath = "//android.view.View[@content-desc='Gender']/following-sibling::android.widget.ImageView")
    List<WebElement> genderRadioBtnList;

    @FindBy(xpath = "//android.view.View[@content-desc='UPDATE CHANGES']")
    WebElement editProfileUpdateChangesBtn;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,'Mobile :')]")
    WebElement profileDetails;


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

        while (true) {

            for (int i = 0; i < editBtnList.size(); i++) {
                String address = addressList.get(i).getAttribute("content-desc");
                if (address.contains(name) && isDisplayed(editBtnList.get(i))) {
                    System.out.println(">>>Before click");
                    editBtnList.get(i).click();
                    System.out.println(">>>After click");
                    return;
                }
            }
            scrollPage();
            if (isDisplayed(showMoreBtn)) {
                showMoreBtn.click();
            }
            addressList = driver.findElements(By.xpath("//*[contains(@content-desc,'Phone: +91')]"));
            editBtnList = driver.findElements(By.xpath("//*[contains(@content-desc,'Phone: +91')]//android.view.View[@content-desc='Edit']"));

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

        fullNameInput.click();
        fullNameInput.sendKeys(fullName);
        mobileInput.click();
        mobileInput.sendKeys(mobile);
        pinCodeInput.click();
        pinCodeInput.sendKeys(pinCode);
        fullAddressInput.click();
        fullAddressInput.sendKeys(fullAddress);

        clickOnKeyboardDoneBtn();

        if (addressType.equalsIgnoreCase("Work")) {
            radioButtons.get(1).click();
        } else if (addressType.equalsIgnoreCase("Other")) {
            radioButtons.getLast().click();
            locationNameInput.click();
            locationNameInput.sendKeys(locationName);
            clickOnKeyboardDoneBtn();
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
        addressList = driver.findElements(By.xpath("//android.view.View[contains(@content-desc,'Phone: +91')]"));

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

        ConfigReader.setConfigValue("address.count.by.name", String.valueOf(addressCountByName(name)));

        while (true) {

            for (int i = 0; i < deleteBtnList.size(); i++) {
                String address = addressList.get(i).getAttribute("content-desc");
                if (address.contains(name) && isDisplayed(deleteBtnList.get(i))) {
                    deleteBtnList.get(i).click();
                    return;
                }
            }
            scrollPage();
            if (isDisplayed(showMoreBtn)) {
                showMoreBtn.click();
            }
            addressList = driver.findElements(By.xpath("//*[contains(@content-desc,'Phone: +91')]"));
            editBtnList = driver.findElements(By.xpath("//*[contains(@content-desc,'Phone: +91')]//android.view.View[@content-desc='Edit']"));

        }

    }

    @Override
    public void clickOnConfirmBtn() {
        confirmBtn.click();
    }


    @Override
    public boolean isAddressDeleted(String name) {

        // As app is not loading and taking too much time for loading after deleting
        navigateBack(myProfileLink);
        myProfileLink.click();

        int count = addressCountByName(name);
        return (count + 1) == Integer.parseInt(ConfigReader.getConfigValue("address.count.by.name"));
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
        clickOnKeyboardDoneBtn();

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

        // Just to update it well
        navigateBack(myProfileLink);
        myProfileLink.click();

        scrollPage();
        addressList = driver.findElements(By.xpath("//*[contains(@content-desc,'Phone: +91')]"));

        if (isFieldUpdated(fieldsToCheck, addressList)) {
            return true;
        }

        if (isDisplayed(showMoreBtn)) {
            showMoreBtn.click();

            while (!isDisplayed(showLessBtn)) {

                if (isFieldUpdated(fieldsToCheck, addressList)) {
                    return true;
                }

                scrollPage();
                addressList = driver.findElements(By.xpath("//android.view.View[contains(@content-desc,'Phone: +91')]"));
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
        editProfileUpdateChangesBtn.click();
    }


    @Override
    public void updateNameAndGender(String name, String gender) {

        if (gender != null && !gender.isEmpty()) {
            if (gender.equalsIgnoreCase("Female")) {
                genderRadioBtnList.get(1).click();
            } else if (gender.equalsIgnoreCase("Other")) {
                genderRadioBtnList.get(2).click();
            } else {
                genderRadioBtnList.getFirst().click();
            }
        }

        updateField(fullNameInput, name);
        clickOnKeyboardDoneBtn();

    }


    @Override
    public boolean isEditProfileSectionDisplayed() {
        return isDisplayed(becomeClubMemberTextElement) && isDisplayed(editProfileUpdateChangesBtn);
    }


    @Override
    public boolean isProfileUpdated(String name, String gender) {

        String details = profileDetails.getAttribute("content-desc").replace("\n", " ").toLowerCase();
        System.out.println(details);
        System.out.println(details.contains(name.toLowerCase()));
        if (details.contains(name.toLowerCase())) {
            return true;
        }
        System.out.println(details.contains(gender.toLowerCase()));

        return details.contains(gender.toLowerCase());
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


    private int addressCountByName(String name) {
        int count = 0;

        Set<String> processedAddresses = new HashSet<>();
        List<WebElement> previousAddressList;

        do {

            addressList = driver.findElements(By.xpath("//*[contains(@content-desc,'Phone: +91')]"));

            for (WebElement element : addressList) {
                String address = element.getAttribute("content-desc").trim().toLowerCase();
                if (address.contains(name.toLowerCase()) && !processedAddresses.contains(address)) {
                    count++;
                    processedAddresses.add(address);
                }
            }

            previousAddressList = new ArrayList<>(addressList);

            scrollPage();

            if (isDisplayed(showMoreBtn)) {
                showMoreBtn.click();
            }


        } while (!addressList.equals(previousAddressList));

        while (!isDisplayed(editProfileLink)) {
            scrollPageDown();
        }

        return count;
    }


    private void updateField(WebElement element, String value) {
        if (value != null && !value.trim().isEmpty()) {
            element.click();
            element.clear();
            element.sendKeys(value);
        }
    }
}
