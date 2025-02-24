package com.automation.steps.ui;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MyProfilePageSteps extends BaseSteps {
    @Then("verify user is on my profile page")
    public void verifyUserIsOnMyProfilePage() {
        Assert.assertTrue(myProfilePage.isMyProfilePageDisplayed());
    }

    @When("user click on add address link")
    public void userClickOnAddAddressLink() {
        myProfilePage.clickOnAddAddressLink();
    }


    @Then("verify user is on add address section")
    public void verifyUserIsOnAddAddressSection() {
        Assert.assertTrue(myProfilePage.isAddAddressSectionDisplayed());
    }

    @Then("verify user is on edit address section")
    public void verifyUserIsOnEditAddressSection() {
        Assert.assertTrue(myProfilePage.isEditAddressSectionDisplayed());
    }

    @When("user enters the new address details")
    public void userEntersTheNewAddressDetails() {
        myProfilePage.enterAddressDetails();
    }

    @And("click on add address button")
    public void clickOnAddAddressButton() {
        myProfilePage.clickOnAddAddressBtn();
    }

    @Then("verify the address is successfully added")
    public void verifyTheAddressIsSuccessfullyAdded() {
        Assert.assertTrue(myProfilePage.isNewAddressAdded());
    }

    @When("user click on the delete link for the specific address {string}")
    public void userClickOnTheDeleteLinkForTheSpecificAddress(String name) {
        myProfilePage.clickOnDeleteAddressLink(ConfigReader.getConfigValue(name));
    }

    @And("click on confirm button")
    public void clickOnConfirmButton() {
        myProfilePage.clickOnConfirmBtn();
    }

    @Then("verify the specific address {string} is successfully deleted")
    public void verifyTheSpecificAddressIsSuccessfullyDeleted(String name) {
        Assert.assertTrue(myProfilePage.isAddressDeleted(ConfigReader.getConfigValue(name)));
    }

    @When("user update the address details")
    public void userUpdateTheAddressDetails() {
        myProfilePage.updateAddressDetails();
    }

    @And("click on the update changes button")
    public void clickOnTheUpdateChangesButton() {
        myProfilePage.clickOnUpdateChangesBtn();
    }

    @Then("verify the address is successfully updated")
    public void verifyTheAddressIsSuccessfullyUpdated() {
        Assert.assertTrue(myProfilePage.isAddressUpdated());
    }

    @When("click on edit address link for the specific address {string}")
    public void clickOnEditAddressLinkForTheSpecificAddress(String name) {
        myProfilePage.clickOnEditAddressLink(ConfigReader.getConfigValue(name));
    }

    @When("user click on edit profile button")
    public void userClickOnEditProfileButton() {
        myProfilePage.clickOnEditProfileBtn();
    }

    @Then("verify user is on edit profile section")
    public void verifyUserIsOnEditProfileSection() {
        Assert.assertTrue(myProfilePage.isEditProfileSectionDisplayed());
    }

    @When("user update name {string} and gender {string}")
    public void userUpdateNameAndGender(String name, String gender) {
        myProfilePage.updateNameAndGender(ConfigReader.getConfigValue(name), ConfigReader.getConfigValue(gender));
    }

    @And("click on update changes button")
    public void clickOnUpdateChangesButton() {
        myProfilePage.clickOnEditProfileUpdateChangesBtn();
    }

    @Then("verify profile is updated with name {string} and gender {string}")
    public void verifyProfileIsUpdatedWithNameAndGender(String name, String gender) {
        Assert.assertTrue(myProfilePage.isProfileUpdated(ConfigReader.getConfigValue(name), ConfigReader.getConfigValue(gender)));
    }
}
