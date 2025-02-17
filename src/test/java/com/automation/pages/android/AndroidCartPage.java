package com.automation.pages.android;

import com.automation.pages.interfaces.CartPage;

public class AndroidCartPage extends AndroidBasePage implements CartPage {
    @Override
    public boolean isCartPageDisplayed() {
        return false;
    }

    @Override
    public boolean isProductPresentInCart() {
        return false;
    }

    @Override
    public void removeAllItems() {

    }

    @Override
    public boolean isCartEmpty() {
        return false;
    }
}
