package com.automation.pages.interfaces;

public interface MyProfilePage {
    boolean isMyProfilePageDisplayed();

    void clickOnAddAddressLink();

    boolean isAddAddressSectionDisplayed();

    void clickOnEditAddressLink(String name);

    boolean isEditAddressSectionDisplayed();

    void clickOnAddAddressBtn();

    void enterAddressDetails();

    boolean isNewAddressAdded();

    void clickOnDeleteAddressLink(String name);

    void clickOnConfirmBtn();

    boolean isAddressDeleted(String name);

    void clickOnUpdateChangesBtn();

    void updateAddressDetails();

    boolean isAddressUpdated();
}
