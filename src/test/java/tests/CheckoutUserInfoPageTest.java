package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutOverview;
import pages.CheckoutUserInfoPage;
import pages.ProductsPage;

public class CheckoutUserInfoPageTest extends BaseTest {
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutUserInfoPage userInfoPage;

    @Test
    public void insertOrderInformation() {
        productsPage = new ProductsPage(driver);
        productsPage.successfulLogin("standard_user", "secret_sauce");
        productsPage.clickAddToCartButtons();
        cartPage = productsPage.clickOnCartIcon();
        cartPage.isCheckoutButtonVisible();
        userInfoPage = cartPage.clickContinueButton();
        userInfoPage.setFirstName("Johnny");
        userInfoPage.setLastName("Bravo");
        userInfoPage.setPostalCode(435);
        CheckoutOverview checkoutOverview = userInfoPage.clickContinueButton();

        String actualTitle = cartPage.getTitle();
        Assert.assertEquals(actualTitle, "Checkout: Overview");

    }
}

