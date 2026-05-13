package pages;

import utils.CommonUIMethods;

public class DesktopsPage {

    private final CommonUIMethods ui = new CommonUIMethods();

    private final String buildYourOwnCheapComputer = "//h2[@class='product-title']/a[normalize-space()='Build your own cheap computer']";

    public void selectBuildYourOwnCheapComputer() {
        ui.clickElementByXpath(buildYourOwnCheapComputer, "Build your own cheap computer");
    }
}

