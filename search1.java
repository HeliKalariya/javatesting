package testcase1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class search1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // Maximize browser
        driver.manage().window().maximize();

        // Open Amazon India
        driver.get("https://www.amazon.in/");

        // Wait for Amazon page to load
        Thread.sleep(7000);

        String expected = "mobile";

        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Current Title: " + driver.getTitle());

        // Find Amazon search box
        driver.findElement(By.id("twotabsearchtextbox"))
              .sendKeys(expected + Keys.ENTER);

        // Wait for search results
        Thread.sleep(7000);

        String title = driver.getTitle();

        System.out.println("Search Result Title: " + title);

        // Verify title
        if (title.toLowerCase().contains(expected.toLowerCase())) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        driver.quit();
    }
}