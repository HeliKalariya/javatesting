package testcase1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class addtocart {
	public static void main(String[] args) throws InterruptedException {

	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.saucedemo.com/");
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	Thread.sleep(5000);
	driver.findElement(By.id("login-button")).click();
	Thread.sleep(5000);
	String url=driver.getCurrentUrl();
	Thread.sleep(5000);
	
	driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	Thread.sleep(5000);
	driver.findElement(By.className("shopping_cart_link")).click();
	Thread.sleep(5000);
	String product=driver.findElement(By.className("inventory_item_name")).getText();
	Thread.sleep(5000);
	if(product.equals("Sauce Labs Backpack")) {
		System.out.println("Product added to cart");
	}
	else {
		System.out.println("Product not found");
	}
	
	driver.quit();

	}
}
