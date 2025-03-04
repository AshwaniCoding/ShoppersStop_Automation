package com.automation.steps.ui;


import com.automation.pages.android.*;
import com.automation.pages.interfaces.*;
import com.automation.pages.web.*;

public class BaseSteps {

    HomePage homePage;
    LoginPage loginPage;
    ProductsPage productsPage;
    ProductDetailsPage productDetailsPage;
    MyAccountPage myAccountPage;
    CartPage cartPage;
    WishlistPage wishlistPage;
    MyProfilePage myProfilePage;



    public BaseSteps() {

        if (System.getProperty("platform").equals("web")) {
            homePage = new WebHomePage();
            productsPage = new WebProductsPage();
            loginPage = new WebLoginPage();
            productDetailsPage = new WebProductDetailsPage();
            myAccountPage = new WebMyAccountPage();
            cartPage = new WebCartPage();
            wishlistPage = new WebWishlistPage();
            myProfilePage = new WebMyProfilePage();
        } else {
            homePage = new AndroidHomePage();
            productsPage = new AndroidProductsPage();
            loginPage = new AndroidLoginPage();
            productDetailsPage = new AndroidProductDetailsPage();
            myAccountPage = new AndroidMyAccountPage();
            cartPage = new AndroidCartPage();
            wishlistPage = new AndroidWishlistPage();
            productDetailsPage = new AndroidProductDetailsPage();
            myProfilePage = new AndroidMyProfilePage();
        }
    }

}
