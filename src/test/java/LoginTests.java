import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginTests {

    // Initialize WebDriver (e.g., ChromeDriver, FirefoxDriver, etc.)
    private WebDriver driver;


    @Before
    public void setUp() {
        // Setup WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }


    /**
     * Test case for successful login with valid credentials.
     * This test navigates to the login page, enters valid credentials,
     * and verifies that the login is successful with the expected success message.
     */

    @Test
    public void LoginWithValidCredentials() {

        // Arrange: Initialize WebDriver and navigate to login page
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        // Create instances of Page Objects
        LoginPage loginPage = new LoginPage(driver);
        SecureAreaPage secureAreaPage = new SecureAreaPage(driver);

        // Act: Perform login using Page Object methods
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.clickLogin();

        // Assert: Verify successful login by checking success message
        String actualMessage = secureAreaPage.getSuccessMessage();
        String expectedMessage = "You logged into a secure area!\n×";
        Assert.assertTrue(actualMessage.contains(expectedMessage), "Actual message: " + actualMessage);

}

    /**
     * Test case to verify error message is displayed when login fails due to invalid credentials.
     * - Navigates to the login page.
     * - Enters invalid username and password.
     * - Clicks on the login button.
     * - Verifies error message displayed.
     */

    @Test
    public void LoginWithInvalidCredentials(){

        // Arrange: Navigate to login page
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        // Create instances of Page Objects
        LoginPage loginPage = new LoginPage(driver);
        SecureAreaPage secureAreaPage = new SecureAreaPage(driver);

        // Act: Perform login using invalid credentials
        loginPage.setUsername("invalidusername");
        loginPage.setPassword("invalidpassword");
        loginPage.clickLogin();

        // Assert: Verify error message is displayed
        String actualErrorMessage = secureAreaPage.getFailureMessage();
        String expectedErrorMessage = "Your username is invalid!\n×";
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage), "Actual error message: " + actualErrorMessage);


    }


    /**
     * Test case to verify error message is displayed when login fails due to incorrect credentials.
     * - Navigates to the login page.
     * - Enters incorrect username and password.
     * - Clicks on the login button.
     * - Verifies error message displayed.
     */

    @Test
    public void errorMessageDisplayedWhenLoginFails() {

        // Arrange: Navigate to login page
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        // Create instances of Page Objects
        LoginPage loginPage = new LoginPage(driver);
        SecureAreaPage secureAreaPage = new SecureAreaPage(driver);

        // Act: Perform login using incorrect credentials
        loginPage.setUsername("invalidusername");
        loginPage.setPassword("invalidpassword");
        loginPage.clickLogin();

        // Assert: Verify error message is displayed
        String actualErrorMessage = secureAreaPage.getFailureMessage();
        String expectedErrorMessage = "Your username is invalid!";
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage), "Actual error message: " + actualErrorMessage);
    }


    @AfterEach
    void teardown() throws InterruptedException {
        // Clean up: Close driver and any associated resources

        Thread.sleep(10000); // 10 seconds in milliseconds

        driver.quit();
    }

}
