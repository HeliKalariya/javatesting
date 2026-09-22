package testcase1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class successfullogin {
	public static void main(String[] args) throws InterruptedException {
		
		String[] users= {
				"locked_out_user",
				"standard_user",
				"problem_user",
				"performance_glitch_user",
				"error_user",
				"visual_user"
		};
		
		
		for (String user:users) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.id("user-name")).sendKeys(user);
		Thread.sleep(5000);
		driver.findElement(By.id("password"))
		.sendKeys("secret_sauce");
		Thread.sleep(5000);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(5000);
		String url=driver.getCurrentUrl();
		Thread.sleep(5000);
		if(url.contains("inventory.html")) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
		driver.quit();
		}
		
	}
}
