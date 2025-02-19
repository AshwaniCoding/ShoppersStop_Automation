package com.automation.pages.android;

import com.automation.pages.interfaces.MyProfilePage;

public class AndroidMyProfilePage extends AndroidBasePage implements MyProfilePage {
    @Override
    public boolean isMyProfilePageDisplayed() {
        return false;
    }

    @Override
    public void clickOnAddAddressLink() {

    }

    @Override
    public boolean isAddAddressSectionDisplayed() {
        return true;
    }

    @Override
    public void clickOnEditAddressLink() {

    }

    @Override
    public boolean isEditAddressSectionDisplayed() {
        return false;
    }

    @Override
    public void clickOnAddAddressBtn() {

    }

    @Override
    public void enterAddressDetails() {

    }

    @Override
    public boolean isNewAddressAdded() {
        return true;
    }

    @Override
    public void clickOnDeleteAddressLink(String name) {

    }

    @Override
    public void clickOnConfirmBtn() {

    }

    @Override
    public boolean isAddressDeleted(String name) {
        return false;
    }
}
