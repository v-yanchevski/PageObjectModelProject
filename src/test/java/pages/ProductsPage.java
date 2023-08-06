package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    List<WebElement> productsName;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    List<WebElement> productsPrice;

    @FindBy(xpath = "//button[text()='Add to cart']")
    List<WebElement> addToCartButtons;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartButtonIndex0;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement addToCartButtonIndex2;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    WebElement shoppingCarIcon;


    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void clickAddToCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonIndex0)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonIndex2)).click();
    }

    public boolean areNamesVisible() {
        for (WebElement element : productsName) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean arePricesVisible() {
        for (WebElement element : productsPrice) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean areAddToCartVisible() {
        for (WebElement element : addToCartButtons) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public void clickOnShoppingCartIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCarIcon)).click();
    }
    public String getPageTitle() {
        return driver.getTitle();
    }
}
