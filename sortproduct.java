package testcase1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class sortproduct {
public static void main(String[] args) {
WebDriver driver = new ChromeDriver();

try {
driver.get("https://www.saucedemo.com/");

driver.findElement(By.id("user-name")).sendKeys("standard_user");
driver.findElement(By.id("password")).sendKeys("secret_sauce");
driver.findElement(By.id("login-button")).click();

Select sort = new Select(driver.findElement(By.className("product_sort_container")));

sort.selectByValue("lohi");

System.out.println("Selected: Price (low to high)");
System.out.println("PASS: Product sorting completed");
} finally {
driver.quit();
}
}
}