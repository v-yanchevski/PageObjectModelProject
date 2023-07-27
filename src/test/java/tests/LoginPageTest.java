package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        loginPage = new LoginPage(driver);
        loginPage.navigateToURL();
    }

    @Test
    public void pageTitleComparison() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginBtn();

        String expectedTitle = "Swag Labs";
        String actualTitle = loginPage.getPageTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "Actual title is " + actualTitle);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}