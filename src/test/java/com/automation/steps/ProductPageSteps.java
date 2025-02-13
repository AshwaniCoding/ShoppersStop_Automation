package com.automation.steps;

import com.automation.pages.android.AndroidProductPage;
import io.cucumber.java.en.And;

public class ProductPageSteps {
    AndroidProductPage androidProductPage = new AndroidProductPage();
    @And("user sets desired filters")
    public void userSetsDesiredFilters() {
        androidProductPage.chooseFilters();
    }
}
