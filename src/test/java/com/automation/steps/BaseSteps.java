package com.automation.steps;


import com.automation.pages.android.AndroidHomePage;
import com.automation.pages.android.AndroidLoginPage;
import com.automation.pages.android.AndroidMyAccountPage;
import com.automation.pages.android.AndroidProductsPage;
import com.automation.pages.interfaces.HomePage;
import com.automation.pages.interfaces.LoginPage;
import com.automation.pages.interfaces.MyAccountPage;
import com.automation.pages.interfaces.ProductsPage;
import com.automation.pages.web.WebHomePage;
import com.automation.pages.web.WebLoginPage;
import com.automation.pages.web.WebMyAccountPage;
import com.automation.pages.web.WebProductsPage;

public class BaseSteps {

    HomePage homePage;
    LoginPage loginPage;
    ProductsPage productPage;
    MyAccountPage myAccountPage;


    public BaseSteps() {

        if (System.getProperty("platform").equals("web")) {
            homePage = new WebHomePage();
            productPage = new WebProductsPage();
            loginPage = new WebLoginPage();
            myAccountPage = new WebMyAccountPage();
        } else {
            homePage = new AndroidHomePage();
            productPage = new AndroidProductsPage();
            loginPage = new AndroidLoginPage();
            myAccountPage = new AndroidMyAccountPage();
        }
    }

}
