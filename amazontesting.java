package praticetesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class amazontesting {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.in/");
        Thread.sleep(5000);

        // Login
        driver.findElement(By.id("nav-link-accountList")).click();
        Thread.sleep(3000);

        // Enter phone number
        driver.findElement(By.id("ap_email_login"))
                .sendKeys("9054907220");

        driver.findElement(By.id("continue")).click();
        Thread.sleep(5000);

        // Enter OTP manually
        System.out.println("Enter OTP manually...");

        // Wait for Amazon homepage after login
        WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(60)
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("twotabsearchtextbox")
                )
        );

        // Search laptop
        driver.findElement(By.id("twotabsearchtextbox"))
                .sendKeys("laptop");

        driver.findElement(By.id("nav-search-submit-button"))
                .click();

        Thread.sleep(5000);

        // Click FIRST product
        driver.findElement(
                By.cssSelector("div[data-component-type='s-search-result'] h2 a")
        ).click();

        Thread.sleep(5000);

        // Add to cart
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("add-to-cart-button")
                )
        ).click();

        Thread.sleep(5000);

        System.out.println("Product added to cart");

        driver.quit();
    }
}