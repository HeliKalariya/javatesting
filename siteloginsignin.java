package praticetesting;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class siteloginsignin {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Open website
        driver.get("https://www.demoblaze.com/");

        // 1. Validate page title
        String title = driver.getTitle();

        System.out.println("Page Title: " + title);

        if (title.equals("STORE")) {
            System.out.println("PASS: Page title is correct");
        } else {
            System.out.println("FAIL: Page title is incorrect");
        }

        // 2. Click Sign Up
        driver.findElement(By.id("signin2")).click();

        Thread.sleep(1000);

        // Unique username
        String username = "heli" + System.currentTimeMillis();
        String password = "Test123";

        // Enter username
        driver.findElement(By.id("sign-username"))
                .sendKeys(username);

        // Enter password
        driver.findElement(By.id("sign-password"))
                .sendKeys(password);

        // Click Sign Up button
        driver.findElement(
                By.cssSelector("#signInModal .btn-primary")
        ).click();

        Thread.sleep(1000);

        // Handle alert
        Alert alert = driver.switchTo().alert();

        System.out.println("Sign Up Message: " + alert.getText());

        alert.accept();

        // 3. Click Log In
        driver.findElement(By.id("login2")).click();

        Thread.sleep(1000);

        // Enter username
        driver.findElement(By.id("loginusername"))
                .sendKeys(username);

        // Enter password
        driver.findElement(By.id("loginpassword"))
                .sendKeys(password);

        // Click Log In button
        driver.findElement(
                By.cssSelector("#logInModal .btn-primary")
        ).click();

        Thread.sleep(2000);

        // 4. Verify Welcome username
        String welcome = driver.findElement(
                By.id("nameofuser")
        ).getText();

        System.out.println("Welcome Message: " + welcome);

        if (welcome.contains(username)) {
            System.out.println("PASS: Login successful");
        } else {
            System.out.println("FAIL: Login unsuccessful");
        }

        // 5. Close browser
        driver.quit();
    }
}