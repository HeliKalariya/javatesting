package praticetesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Prestashop {

    public static void main(String[] args) throws InterruptedException {

        // 1. Launch Chrome
        WebDriver driver = new ChromeDriver();

        try {

            driver.manage().window().maximize();

            // Open PrestaShop Demo
            driver.get("https://demo.prestashop.com/");

            Thread.sleep(8000);


            // 2. Validate Page Title and URL
            String title = driver.getTitle();
            String url = driver.getCurrentUrl();

            System.out.println("Title: " + title);
            System.out.println("URL: " + url);

            if (title.contains("PrestaShop")
                    && url.contains("demo.prestashop.com")) {

                System.out.println("Title and URL are correct");

            } else {

                System.out.println("Title or URL is wrong");
            }


            // Switch to PrestaShop iframe
            driver.switchTo().frame("framelive");

            Thread.sleep(3000);


            // 3 & 4. Navigate to a product and select it
            WebElement product = driver.findElement(
                    By.cssSelector(".product-miniature a")
            );

            // Scroll product to center
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block:'center'});",
                    product
            );

            Thread.sleep(1000);

            // Click product
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    product
            );

            System.out.println("Product selected successfully.");

            Thread.sleep(4000);


            // 5. Add product to shopping cart
            WebElement addToCart = driver.findElement(
                    By.xpath("//button[contains(.,'Add to cart')]")
            );

            // Scroll Add to Cart button into view
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block:'center'});",
                    addToCart
            );

            Thread.sleep(1500);

            // Click Add to Cart
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    addToCart
            );

            System.out.println("Add to Cart clicked.");

            Thread.sleep(3000);


            // 6. Verify product is added successfully
            String message = driver.findElement(
                    By.cssSelector(".modal-title")
            ).getText();

            System.out.println("Message: " + message);


            // 7. Display PASS / FAIL
            if (message.toLowerCase().contains("successfully added")) {

                System.out.println("--------------------------------");
                System.out.println("TEST RESULT: PASS");
                System.out.println("Product added successfully.");
                System.out.println("--------------------------------");

            } else {

                System.out.println("--------------------------------");
                System.out.println("TEST RESULT: FAIL");
                System.out.println("--------------------------------");
            }


        } catch (Exception e) {

            System.out.println("--------------------------------");
            System.out.println("TEST RESULT: FAIL");
            System.out.println("--------------------------------");

            System.out.println("Error: " + e.getMessage());


        } finally {

            // 8. Close browser
            driver.quit();

            System.out.println("Browser closed.");
        }
    }
}