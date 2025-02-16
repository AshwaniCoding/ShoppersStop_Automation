package com.automation.pages.interfaces;

public interface CartPage {
    boolean isCartPageDisplayed();

    boolean isProductPresentInCart();

    void removeAllItems();

    boolean isCartEmpty();
}
