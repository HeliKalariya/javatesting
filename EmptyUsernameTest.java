package testcase1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmptyUsernameTest {
	public static void main(String[] args) throws InterruptedException {
		
		
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
//		driver.findElement(By.id("password"))
//		.sendKeys("secret_sauce");
		Thread.sleep(5000);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(5000);
		String error=driver.findElement(By.cssSelector("[data-test='error']")).getText();
		Thread.sleep(5000);
		if(error.contains("Password is required")) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
		driver.quit();
        
		
	}
}
