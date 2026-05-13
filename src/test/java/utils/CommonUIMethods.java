package utils;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonUIMethods {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public CommonUIMethods() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickElementByXpath(String xpathVariable, String description) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVariable)));
        element.click();
        System.out.println("Clicked on: " + description);
    }

    public void enterTextByXpath(String xpathVariable, String value, String description) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVariable)));
        element.clear();
        element.sendKeys(value);
        System.out.println("Entered text in: " + description);
    }

    public String getTextByXpath(String xpathVariable, String description) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVariable)));
        String text = element.getText();
        System.out.println("Got text from: " + description + " -> " + text);
        return text;
    }

    public void waitForElementVisibleByXpath(String xpathVariable, String description) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVariable)));
        System.out.println("Visible: " + description);
    }

    public void selectDropdownByVisibleText(By locator, String text, String description) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        new Select(element).selectByVisibleText(text);
        System.out.println("Selected '" + text + "' from: " + description);
    }

    public void hoverByXpath(String xpathVariable, String description) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVariable)));
        new Actions(driver).moveToElement(element).perform();
        System.out.println("Hovered on: " + description);
    }
}

