package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CheckoutOverview extends BasePage {

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    List<WebElement> productsName;

    @FindBy(id = "finish")
    WebElement finishButton;

    public CheckoutOverview(WebDriver driver) {
        super(driver);
    }

    public boolean areProductsVisible() {
        for (WebElement e : productsName) {
            if (!e.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public CheckoutComplete clickFinish() {
        finishButton.click();
        return new CheckoutComplete(driver);
    }
}
