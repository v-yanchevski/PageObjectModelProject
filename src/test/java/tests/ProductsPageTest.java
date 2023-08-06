package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;

public class ProductsPageTest extends BaseTest {
    private ProductsPage productsPage;
    @Test
    public void checkIfNamesAreVisible() {
        productsPage = new ProductsPage(driver);
        productsPage.successfulLogin("standard_user", "secret_sauce");
        productsPage.areNamesVisible();
    }

    @Test
    public void checkIfPricesAreVisible() {
        productsPage = new ProductsPage(driver);
        productsPage.successfulLogin("standard_user", "secret_sauce");
        productsPage.arePricesVisible();
    }

@Test
    public void checkIfAddToCartButtonsAreVisible() {
    productsPage = new ProductsPage(driver);
    productsPage.successfulLogin("standard_user", "secret_sauce");
    productsPage.areAddToCartVisible();
}

@Test
    public void checkIfProductsAreAddedToCart(){
    productsPage = new ProductsPage(driver);
    productsPage.successfulLogin("standard_user", "secret_sauce");
    productsPage.clickAddToCartButtons();
    productsPage.isProductAddedToTheCart();
}

@Test
public void goToUserInformationPage(){
    productsPage = new ProductsPage(driver);
    productsPage.successfulLogin("standard_user", "secret_sauce");
    productsPage.clickAddToCartButtons();
    CartPage cartPage = productsPage.clickOnCartIcon();
    String actualTitle = cartPage.getTitle();
    Assert.assertEquals(actualTitle, "Your Cart", "Not on the cart page");
}

}
