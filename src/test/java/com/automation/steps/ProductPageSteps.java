package com.automation.steps;

import com.automation.pages.android.ProductPage;
import io.cucumber.java.en.And;

public class ProductPageSteps {
    ProductPage productPage = new ProductPage();
    @And("user sets desired filters")
    public void userSetsDesiredFilters() {
        productPage.chooseFilters();
    }
}
