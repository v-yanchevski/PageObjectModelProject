package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutUserInfoPage extends BasePage{
    @FindBy(xpath = "//span[contains(@class, 'title')]")
    WebElement title;

    public CheckoutUserInfoPage(WebDriver driver) {
        super(driver);
    }
    public String getTitle(){
        return title.getText();
    }
}
