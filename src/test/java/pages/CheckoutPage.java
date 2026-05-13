package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utils.CommonUIMethods;

import java.util.Properties;

public class CheckoutPage {

    private final CommonUIMethods ui = new CommonUIMethods();

    // Billing
    private final By billingAddressSelect = By.xpath("//select[@id='billing-address-select']");
    private final By billingCountryDropdown = By.xpath("//select[@id='BillingNewAddress_CountryId']");
    private final String billingFirstName = "//input[@id='BillingNewAddress_FirstName']";
    private final String billingLastName = "//input[@id='BillingNewAddress_LastName']";
    private final String billingEmail = "//input[@id='BillingNewAddress_Email']";
    private final String billingCity = "//input[@id='BillingNewAddress_City']";
    private final String billingAddress1 = "//input[@id='BillingNewAddress_Address1']";
    private final String billingZip = "//input[@id='BillingNewAddress_ZipPostalCode']";
    private final String billingPhone = "//input[@id='BillingNewAddress_PhoneNumber']";
    private final String billingContinue = "//div[@id='billing-buttons-container']//input[@value='Continue']";

    // Shipping
    private final String shippingContinue = "//div[@id='shipping-buttons-container']//input[@value='Continue']";
    private final String shippingMethodContinue = "//div[@id='shipping-method-buttons-container']//input[@value='Continue']";

    // Payment
    private final String cashOnDeliveryRadio = "//input[@type='radio' and following-sibling::label[contains(.,'Cash On Delivery')]]";
    private final String paymentMethodContinue = "//div[@id='payment-method-buttons-container']//input[@value='Continue']";
    private final String paymentInfoContinue = "//div[@id='payment-info-buttons-container']//input[@value='Continue']";

    // Confirm
    private final String confirmOrderButton = "//div[@id='confirm-order-buttons-container']//input[@value='Confirm']";

    public void completeBillingAndShipping() {
        // If a saved address exists, the form is hidden and we just continue.
        // Otherwise we fill in a new address using values from config.properties.
        boolean hasSavedAddress = !DriverFactory.getDriver().findElements(billingAddressSelect).isEmpty();

        if (!hasSavedAddress) {
            Properties cfg = DriverFactory.getConfig();
            ui.enterTextByXpath(billingFirstName, cfg.getProperty("firstName"), "Billing first name");
            ui.enterTextByXpath(billingLastName, cfg.getProperty("lastName"), "Billing last name");
            ui.enterTextByXpath(billingEmail, cfg.getProperty("email"), "Billing email");
            ui.selectDropdownByVisibleText(billingCountryDropdown, cfg.getProperty("country"), "Billing country");
            ui.enterTextByXpath(billingCity, cfg.getProperty("city"), "Billing city");
            ui.enterTextByXpath(billingAddress1, cfg.getProperty("address1"), "Billing address1");
            ui.enterTextByXpath(billingZip, cfg.getProperty("zip"), "Billing zip");
            ui.enterTextByXpath(billingPhone, cfg.getProperty("phone"), "Billing phone");
        } else {
            // Pick the first saved address (skip the "New Address" option)
            Select select = new Select(DriverFactory.getDriver().findElement(billingAddressSelect));
            select.selectByIndex(0);
            System.out.println("Selected saved billing address");
        }

        ui.clickElementByXpath(billingContinue, "Billing Continue");
        ui.clickElementByXpath(shippingContinue, "Shipping Continue");
        ui.clickElementByXpath(shippingMethodContinue, "Shipping method Continue");
    }

    public void selectCashOnDelivery() {
        ui.clickElementByXpath(cashOnDeliveryRadio, "Cash On Delivery radio");
        ui.clickElementByXpath(paymentMethodContinue, "Payment method Continue");
        ui.clickElementByXpath(paymentInfoContinue, "Payment info Continue");
    }

    public void confirmOrder() {
        ui.clickElementByXpath(confirmOrderButton, "Confirm order button");
    }
}
