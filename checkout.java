package testcase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkout {
public static void main(String[] args) {
WebDriver driver = new ChromeDriver();

try {
driver.get("https://www.saucedemo.com/");
driver.findElement(By.id("user-name")).sendKeys("standard_user");
driver.findElement(By.id("password")).sendKeys("secret_sauce");
driver.findElement(By.id("login-button")).click();

driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

driver.findElement(By.className("shopping_cart_link")).click();

driver.findElement(By.id("checkout")).click();

driver.findElement(By.id("first-name")).sendKeys("MCA");
driver.findElement(By.id("last-name")).sendKeys("Student");
driver.findElement(By.id("postal-code")).sendKeys("380001");

driver.findElement(By.id("continue")).click();

String title = driver.findElement(By.className("title")).getText();

if (title.equals("Checkout: Overview")) {
System.out.println("PASS: Checkout details accepted");
} else {
System.out.println("FAIL: Checkout failed");
}
} finally {
driver.quit();
}
}
}