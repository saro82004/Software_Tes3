import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocatorsDemo {

    public static void main(String[] args) {

        // Chrome settings
        ChromeOptions options = new ChromeOptions();

        // Load page faster
        options.setPageLoadStrategy(org.openqa.selenium.PageLoadStrategy.EAGER);

        // Open Chrome
        WebDriver driver = new ChromeDriver(options);

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

        try {

            // Open website
            driver.get("https://the-internet.herokuapp.com/login");

            driver.manage().window().maximize();

            // 1. ID locator
            WebElement username = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.id("username")
                    )
            );

            username.sendKeys("tomsmith");

            // 2. NAME locator
            WebElement password = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.name("password")
                    )
            );

            password.sendKeys("SuperSecretPassword!");

            // 3. CLASS NAME locator
            WebElement loginButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.className("radius")
                    )
            );

            loginButton.click();

            // 4. CSS SELECTOR
            WebElement message = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector("#flash")
                    )
            );

            System.out.println(
                    "Login Message: " + message.getText()
            );

            // 5. XPATH
            WebElement logout = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//a[@href='/logout']")
                    )
            );

            System.out.println(
                    "Logout Text: " + logout.getText()
            );

            System.out.println("Automation completed successfully.");

        } finally {

            // Close browser
            driver.quit();
        }
    }
}