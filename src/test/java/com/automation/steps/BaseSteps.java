package com.automation.steps;


import com.automation.pages.android.*;
import com.automation.pages.interfaces.*;
import com.automation.pages.web.*;

public class BaseSteps {

    HomePage homePage;
    LoginPage loginPage;
    ProductsPage productPage;
    MyAccountPage myAccountPage;
    CartPage cartPage;
    WishlistPage wishlistPage;
    ProductDetailsPage productDetailsPage;


    public BaseSteps() {

        if (System.getProperty("platform").equals("web")) {
            homePage = new WebHomePage();
            productPage = new WebProductsPage();
            loginPage = new WebLoginPage();
            myAccountPage = new WebMyAccountPage();
            cartPage = new WebCartPage();
            wishlistPage = new WebWishlistPage();
        } else {
            homePage = new AndroidHomePage();
            productPage = new AndroidProductsPage();
            loginPage = new AndroidLoginPage();
            myAccountPage = new AndroidMyAccountPage();
            cartPage = new AndroidCartPage();
            wishlistPage = new AndroidWishlistPage();
            productDetailsPage = new AndroidProductDetailsPage();
        }
    }

}
