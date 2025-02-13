package com.automation.steps;

import com.automation.pages.android.HomePage;

public class BaseSteps {

    HomePage homePage;

    public BaseSteps() {

        if (System.getProperty("platform").equals("web")) {

        } else {

        }
    }

}
