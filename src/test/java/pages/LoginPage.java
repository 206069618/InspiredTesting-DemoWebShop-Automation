package pages;

import utils.CommonUIMethods;

public class LoginPage {

    private final CommonUIMethods ui = new CommonUIMethods();

    private final String emailField = "//input[@id='Email']";
    private final String passwordField = "//input[@id='Password']";
    private final String loginButton = "//input[@value='Log in']";

    public void login(String email, String password) {
        ui.enterTextByXpath(emailField, email, "Email field");
        ui.enterTextByXpath(passwordField, password, "Password field");
        ui.clickElementByXpath(loginButton, "Login button");
    }
}

