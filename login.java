package praticetesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
		driver.findElement(By.id("username")).sendKeys("student");
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys("Password123");
		Thread.sleep(3000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(3000);
		String url=driver.getCurrentUrl();
		if(url.contains("logged-in-successfully")) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
		
	}
}
