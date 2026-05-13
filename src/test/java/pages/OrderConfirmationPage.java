package pages;

import utils.CommonUIMethods;

public class OrderConfirmationPage {

    private final CommonUIMethods ui = new CommonUIMethods();
    private final String orderNumberLabel = "//div[contains(@class,'order-number')]";
    private final String thankYouTitle = "//div[contains(@class,'page-title')]/h1[contains(.,'Thank you')]";

    public String getOrderNumber() {
        ui.waitForElementVisibleByXpath(thankYouTitle, "Thank you title");
        return ui.getTextByXpath(orderNumberLabel, "Order number");
    }
}

