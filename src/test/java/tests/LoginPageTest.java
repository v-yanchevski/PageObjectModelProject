package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProductsPage;


public class LoginPageTest extends BaseTest {


    @Test
    public void standardCredentialsLogin() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        ProductsPage productsPage = loginPage.clickLoginBtn();
        String actualTitle = productsPage.getPageTitle();
        Assert.assertEquals(actualTitle, "Swag Labs", "Actual title is " + actualTitle);


    }
}