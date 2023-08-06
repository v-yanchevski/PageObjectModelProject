//package pages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//import java.util.List;
//
//public class CartPage extends BasePage {
//
//    private final String URL = "https://www.saucedemo.com/inventory.html";
//
//    @FindBy(id = "cart_contents_container")
//    List<WebElement> productsName;
//
//    @FindBy(xpath = "//*[contains(@id, \"remove\")]")
//    List<WebElement> removeButtons;
//
//    @FindBy(id = "checkout")
//    WebElement checkoutButton;
//
//    public CartPage (WebDriver driver){
//        super(driver);
//        PageFactory.initElements(driver,this);
//    }
//
//    public boolean areNamesVisible() {
//        for (WebElement element : productsName) {
//            if (!element.isDisplayed()) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean areRemoveButtonsVisible() {
//        for (WebElement element : removeButtons) {
//            if (!element.isDisplayed()) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean isCheckoutButtonVisible() {
//        {
//            if (!checkoutButton.isDisplayed()) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//
//}
//
