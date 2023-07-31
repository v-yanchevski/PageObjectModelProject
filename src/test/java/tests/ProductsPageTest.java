package tests;

import data_providers.StandardUserCredentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProductsPage;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ProductsPageTest {
    private WebDriver driver;
    private ProductsPage productsPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        productsPage = new ProductsPage(driver);
        productsPage.navigateToURL();
    }

    @Test(dependsOnMethods = "standardCredentialsLogin")
    public void checkIfNamesAreVisible() {
        boolean areNamesVisible = productsPage.areNamesVisible();
        Assert.assertTrue(areNamesVisible);
    }


    @Test(dependsOnMethods = "standardCredentialsLogin")
    public void checkIfPricesAreVisible() {
        boolean arePricesVisible = productsPage.arePricesVisible();
        Assert.assertTrue(arePricesVisible);
    }

    @Test(dependsOnMethods = "standardCredentialsLogin")
    public void checkIfAddToCartIsVisible() {
        boolean areButtonsVisible = productsPage.areAddToCartVisible();
        Assert.assertTrue(areButtonsVisible);

    }


    @Test(dataProvider = "standard credentials", dataProviderClass = StandardUserCredentials.class)
    public void addToCart(String userName, String password) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToURL();
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        loginPage.clickLoginBtn();
        productsPage = new ProductsPage(driver);
        productsPage.clickAddToCartButton();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

