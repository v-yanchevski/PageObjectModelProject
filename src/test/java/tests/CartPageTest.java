package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;

public class CartPageTest extends BaseTest {
    private ProductsPage productsPage;
    private CartPage cartPage;

    @Test
    public void checkIfProductsInCartAreVisible() {
        productsPage = new ProductsPage(driver);
        productsPage.successfulLogin("standard_user", "secret_sauce");
        productsPage.clickAddToCartButtons();
        cartPage = productsPage.clickOnCartIcon();
        cartPage.areNamesVisible();
    }

    @Test
    public void checkIfRemoveButtonsAreVisible() {
        productsPage = new ProductsPage(driver);
        productsPage.successfulLogin("standard_user", "secret_sauce");
        productsPage.clickAddToCartButtons();
        cartPage = productsPage.clickOnCartIcon();
        cartPage.areRemoveButtonsVisible();
    }


    @Test
    public void checkIfCheckoutButtonIsVisible() {
        productsPage = new ProductsPage(driver);
        productsPage.successfulLogin("standard_user", "secret_sauce");
        productsPage.clickAddToCartButtons();
        cartPage = productsPage.clickOnCartIcon();
        cartPage.isCheckoutButtonVisible();
    }

    @Test
    public void goToCheckoutStepOne() {
        productsPage = new ProductsPage(driver);
        productsPage.successfulLogin("standard_user", "secret_sauce");
        productsPage.clickAddToCartButtons();
        cartPage = productsPage.clickOnCartIcon();
        cartPage.isCheckoutButtonVisible();
        cartPage.clickContinueButton();

        String actualTitle = cartPage.getTitle();
        Assert.assertEquals(actualTitle, "Checkout: Your Information", " Not on checkout page");
    }
}


