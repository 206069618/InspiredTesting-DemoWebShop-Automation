package pages;

import factory.DriverFactory;
import utils.CommonUIMethods;

public class HomePage {

    private final CommonUIMethods ui = new CommonUIMethods();

    private final String loginLink = "//a[normalize-space()='Log in']";
    private final String computersMenu = "//ul[contains(@class,'top-menu')]/li/a[normalize-space()='Computers']";
    private final String desktopsLink = "//ul[contains(@class,'top-menu')]//a[normalize-space()='Desktops']";

    public void open() {
        String url = DriverFactory.getConfig().getProperty("baseUrl");
        DriverFactory.getDriver().get(url);
        System.out.println("Opened: " + url);
    }

    public void clickLogin() {
        ui.clickElementByXpath(loginLink, "Login link");
    }

    public void goToDesktops() {
        ui.hoverByXpath(computersMenu, "Computers menu");
        ui.clickElementByXpath(desktopsLink, "Desktops sub-menu");
    }
}

