package com.automation.steps;


import com.automation.pages.android.AndroidHomePage;
import com.automation.pages.android.AndroidProductsPage;
import com.automation.pages.interfaces.HomePage;
import com.automation.pages.interfaces.ProductsPage;
import com.automation.pages.web.WebHomePage;
import com.automation.pages.web.WebProductsPage;

public class BaseSteps {

    HomePage homePage;
    ProductsPage productPage;


    public BaseSteps() {

        if (System.getProperty("platform").equals("web")) {
            homePage = new WebHomePage();
            productPage = new WebProductsPage();
        } else {
            homePage = new AndroidHomePage();
            productPage = new AndroidProductsPage();

        }
    }

}
