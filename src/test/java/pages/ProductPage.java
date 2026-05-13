package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonUIMethods;

import java.util.List;

public class ProductPage {

    private final CommonUIMethods ui = new CommonUIMethods();

    // Locators
    private final String productAttributeRows = "//dl[@id='product-attribute-specs']/dd";
    private final String radioButtonsInRow = ".//input[@type='radio']";
    private final String addToCartButton = "//input[contains(@id,'add-to-cart-button')]";

    // Build your own cheap computer requires HDD and OS to be selected.
    // We loop through each attribute row and click the first radio option
    // if no option is already selected in that row.
    public void configureProduct() {
        List<WebElement> attributeRows = DriverFactory.getDriver()
                .findElements(By.xpath(productAttributeRows));

        for (WebElement row : attributeRows) {
            List<WebElement> radios = row.findElements(By.xpath(radioButtonsInRow));
            if (radios.isEmpty()) continue;

            boolean alreadySelected = false;
            for (WebElement radio : radios) {
                if (radio.isSelected()) {
                    alreadySelected = true;
                    break;
                }
            }
            if (!alreadySelected) {
                radios.get(0).click();
            }
        }
    }

    public void addToCart() {
        configureProduct();
        ui.clickElementByXpath(addToCartButton, "Add to cart button");
    }
}
