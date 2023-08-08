package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutOverviewTest extends BaseTest {
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutUserInfoPage userInfoPage;
    private CheckoutOverview checkoutOverview;
    private CheckoutComplete checkoutComplete;

    @Test
    public void finishOrder() {
        productsPage = new ProductsPage(driver);
        productsPage.successfulLogin("standard_user", "secret_sauce");
        productsPage.clickAddToCartButtons();
        cartPage = productsPage.clickOnCartIcon();
        cartPage.isCheckoutButtonVisible();
        userInfoPage = cartPage.clickContinueButton();
        userInfoPage.setFirstName("Johnny");
        userInfoPage.setLastName("Bravo");
        userInfoPage.setPostalCode(435);
        checkoutOverview = userInfoPage.clickContinueButton();
        checkoutComplete = checkoutOverview.clickFinish();
        checkoutComplete.getTittle();

        String actualTittle = checkoutComplete.getTittle();
        Assert.assertEquals(actualTittle, "Checkout: Complete!");
    }
}
