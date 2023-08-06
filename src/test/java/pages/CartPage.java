package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {

    private final String URL = "https://www.saucedemo.com/inventory.html";

    @FindBy(id = "cart_contents_container")
    List<WebElement> productsName;

    @FindBy(xpath = "//*[contains(@id, \"remove\")]")
    List<WebElement> removeButtons;

    @FindBy(id = "checkout")
    WebElement continueButton;
    @FindBy(id = "continue-shopping")
    WebElement productsPageButton;
    @FindBy(xpath = "//span[contains(@class, 'title')]")
    WebElement title;

    public CartPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean areNamesVisible() {
        for (WebElement element : productsName) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean areRemoveButtonsVisible() {
        for (WebElement element : removeButtons) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean isCheckoutButtonVisible() {
        wait.until(ExpectedConditions.visibilityOf(continueButton));
        {
            if (!continueButton.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public CheckoutUserInfoPage clickContinueButton(){
        continueButton.click();
        return new CheckoutUserInfoPage(driver);
    }
    public ProductsPage backOnProductsPage(){
        productsPageButton.click();
        return new ProductsPage(driver);
    }
    public String getTitle(){
        return title.getText();
    }

}

