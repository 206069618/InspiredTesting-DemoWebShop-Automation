package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.DesktopsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderConfirmationPage;
import pages.ProductPage;

public class CheckoutSteps {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final DesktopsPage desktopsPage = new DesktopsPage();
    private final ProductPage productPage = new ProductPage();
    private final CartPage cartPage = new CartPage();
    private final CheckoutPage checkoutPage = new CheckoutPage();
    private final OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage();

    private String capturedOrderNumber;

    @Given("user launches Demo Web Shop")
    public void user_launches_demo_web_shop() {
        homePage.open();
    }

    @And("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        homePage.clickLogin();
        String email = DriverFactory.getConfig().getProperty("email");
        String password = DriverFactory.getConfig().getProperty("password");
        loginPage.login(email, password);
    }

    @When("user navigates to Desktops")
    public void user_navigates_to_desktops() {
        homePage.goToDesktops();
    }

    @And("user selects Build your own cheap computer")
    public void user_selects_build_your_own_cheap_computer() {
        desktopsPage.selectBuildYourOwnCheapComputer();
    }

    @And("user adds the product to cart")
    public void user_adds_the_product_to_cart() {
        productPage.addToCart();
    }

    @And("user accepts terms and proceeds to checkout")
    public void user_accepts_terms_and_proceeds_to_checkout() {
        cartPage.openCart();
        cartPage.acceptTermsAndCheckout();
    }

    @And("user completes billing and shipping details")
    public void user_completes_billing_and_shipping_details() {
        checkoutPage.completeBillingAndShipping();
    }

    @And("user selects Cash On Delivery payment method")
    public void user_selects_cash_on_delivery_payment_method() {
        checkoutPage.selectCashOnDelivery();
    }

    @And("user confirms the order")
    public void user_confirms_the_order() {
        checkoutPage.confirmOrder();
    }

    @Then("order number should be captured")
    public void order_number_should_be_captured() {
        capturedOrderNumber = orderConfirmationPage.getOrderNumber();
        System.out.println("Order Number: " + capturedOrderNumber);
        Assert.assertNotNull(capturedOrderNumber, "Order number was not captured");
        Assert.assertFalse(capturedOrderNumber.isEmpty(), "Order number is empty");
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

