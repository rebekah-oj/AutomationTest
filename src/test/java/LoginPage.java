import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

    private final WebDriver driver;

        // initialize this driver in the Constructor
        public LoginPage(WebDriver driver) {
            this.driver = driver;
        }

        // Page elements
        private By usernameField = By.id("username");
        private By passwordField = By.id("password");
        private By loginButton = By.cssSelector("button.radius");

        // Actions
        public void setUsername(String username) {
            driver.findElement(usernameField).sendKeys(username);
        }

        public void setPassword(String password) {
            driver.findElement(passwordField).sendKeys(password);
        }

        public void clickLogin() {
            driver.findElement(loginButton).click();
        }

}
