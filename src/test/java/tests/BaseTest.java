package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.setBinary("PATH_TO_chrome.exe");
        System.setProperty("webdriver.chrome.driver", "PATH_TO_chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");

        driver.get("https://www.saucedemo.com/");
    }


    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
