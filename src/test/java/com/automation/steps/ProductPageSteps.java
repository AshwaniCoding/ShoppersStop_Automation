package com.automation.steps;

import com.automation.pages.android.AndroidProductsPage;
import io.cucumber.java.en.And;

public class ProductPageSteps {
    AndroidProductsPage androidProductsPage = new AndroidProductsPage();
    @And("user sets desired filters")
    public void userSetsDesiredFilters() {
        androidProductsPage.chooseFilters();
    }
}
