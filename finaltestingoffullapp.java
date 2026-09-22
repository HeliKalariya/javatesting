package testcase1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class finaltestingoffullapp {
	public static void main(String[] args) throws InterruptedException {
	//to avoid the pop up on chrome
	ChromeOptions options=new ChromeOptions();
	
	options.setExperimentalOption("prefs", 
			java.util.Map.of(
					"credentials_enable_service",false,
					"profile.password_manager_leak_detection",false
			)
	);
		
	WebDriver driver=new ChromeDriver(options);
	
	driver.get("https://www.saucedemo.com/");
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	Thread.sleep(5000);
	driver.findElement(By.id("login-button")).click();
	Thread.sleep(5000);
	String url=driver.getCurrentUrl();
	Thread.sleep(5000);
	//add to cart
	driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	Thread.sleep(5000);
	driver.findElement(By.className("shopping_cart_link")).click();
	Thread.sleep(5000);
	driver.findElement(By.className("inventory_item_name")).getText();
	Thread.sleep(5000);
	
	//open cart
	driver.findElement(By.id("shopping_cart_container")).click();
	Thread.sleep(5000);
	
	//check url
	System.out.println("Current url : "+ driver.getCurrentUrl());
	
	//click checkout
	driver.findElement(By.id("checkout")).click();
	Thread.sleep(5000);
	//fill info
	driver.findElement(By.id("first-name")).sendKeys("Heli");
	Thread.sleep(5000);
	driver.findElement(By.id("last-name")).sendKeys("Kalariya");
	Thread.sleep(5000);
	driver.findElement(By.id("postal-code")).sendKeys("360311");
	Thread.sleep(5000);
	
	driver.findElement(By.id("continue")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("finish")).click();
	Thread.sleep(2000);
	String message=driver.findElement(By.className("complete-header")).getText();
	
	if(message.equals("Thank you for your order!")) {
		System.out.println("Ordered Placed");
	}
	else {
		System.out.println("Ordered not placed");
	}
	
	
	
	driver.quit();

	}
}
