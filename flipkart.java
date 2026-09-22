package praticetesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class flipkart {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(60)
        );

        Thread.sleep(5000);

        // =========================
        // LOGIN
        // =========================

        // Phone number
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("div.mcO4kT input")
                )
        ).sendKeys("9054907220");

        System.out.println("Phone number entered");

        // Continue
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(.,'CONTINUE') or contains(.,'Continue')]")
                )
        ).click();

        System.out.println("Continue clicked");

        // OTP manually
        System.out.println("Enter OTP manually...");

        // Wait until login is completed
        Thread.sleep(10000);

        System.out.println("Login successful");

        // =========================
        // CLOSE LOGIN POPUP
        // =========================

        try {
            driver.findElement(
                    By.cssSelector("div.mcO4kT button[aria-label='Close']")
            ).click();

            System.out.println("Popup closed");

        } catch (Exception e) {
            System.out.println("Close button not found");
        }

        Thread.sleep(2000);

        // =========================
        // SEARCH LAPTOP
        // =========================

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("input[name='q']")
                )
        ).sendKeys("laptop");

        driver.findElement(
                By.cssSelector(
                        "button[aria-label='Search for Products, Brands and More']"
                )
        ).click();

        Thread.sleep(5000);

        // =========================
        // FIRST PRODUCT
        // =========================

        driver.findElement(
                By.cssSelector("a[href*='/p/']")
        ).click();

        Thread.sleep(5000);

        // =========================
        // ADD TO CART
        // =========================

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(.,'Add to cart')]")
                )
        ).click();

        Thread.sleep(5000);

        System.out.println("Product added to cart");

        driver.quit();
    }
}