package tests;

import data_providers.LockedOutUser;
import data_providers.StandardUserCredentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
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

    @Test(priority = 1, dataProvider = "standard credentials", dataProviderClass = StandardUserCredentials.class)
    public void standardCredentialsLogin(String userName, String password) {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        loginPage.clickLoginBtn();

        String actualTitle = loginPage.getPageTitle();

        Assert.assertEquals(actualTitle, "Swag Labs", "Actual title is " + actualTitle);
    }

    @Test(priority = 2, dataProvider = "locked user", dataProviderClass = LockedOutUser.class)
    public void lockedUserLogin(String userName, String password) {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        loginPage.clickLoginBtn();

        String actualError = loginPage.getErrorMessages();
        Assert.assertEquals(actualError, "Epic sadface: Sorry, this user has been locked out.", "Actual error is " + actualError);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
