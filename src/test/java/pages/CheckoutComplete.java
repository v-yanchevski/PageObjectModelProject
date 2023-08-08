package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutComplete extends BasePage {
    @FindBy(css = "span[class='title']")
    WebElement tittle;

    public CheckoutComplete(WebDriver driver) {
        super(driver);
    }

    public String getTittle() {
        return tittle.getText();
    }
}
