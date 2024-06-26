import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;


public class SecureAreaPage {

    private WebDriver driver;

    // Constructor
    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page elements
    private By successMessage = By.id("flash");
    private By failureMessage = By.id("flash");

    // Actions
    public String getSuccessMessage() {
        WebElement successElement = driver.findElement(successMessage);
        return successElement.getText().trim();
    }

    public String getFailureMessage() {
        WebElement successElement = driver.findElement(failureMessage);
        return successElement.getText().trim();
    }
}
