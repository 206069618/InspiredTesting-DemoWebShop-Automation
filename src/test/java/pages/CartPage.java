package pages;

import utils.CommonUIMethods;

public class CartPage {

    private final CommonUIMethods ui = new CommonUIMethods();

    private final String cartLink = "//a[@class='ico-cart']";
    private final String termsCheckbox = "//input[@id='termsofservice']";
    private final String checkoutButton = "//button[@id='checkout']";

    public void openCart() {
        ui.clickElementByXpath(cartLink, "Cart link");
    }

    public void acceptTermsAndCheckout() {
        ui.clickElementByXpath(termsCheckbox, "Terms and Conditions checkbox");
        ui.clickElementByXpath(checkoutButton, "Checkout button");
    }
}

