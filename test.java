package praticetesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
	public static void main(String[] args) throws Exception
	{
		WebDriver driver= new ChromeDriver();
		
		try
		{
			driver.get("https://practicetestautomation.com/");
			driver.manage().window().maximize();
			
			driver.findElement(By.id("menu-item-20")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.className("wp-block-paragraph")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.id("username")).sendKeys("student");
			driver.findElement(By.id("password")).sendKeys("Password123");
			driver.findElement(By.id("submit")).click();
			Thread.sleep(2000);
			
			String name = driver.findElement(By.className("post-title")).getText();
			System.out.println("Student:"+name);
			String n1 = driver.findElement(By.tagName("strong")).getText();
			System.out.println(n1);
			if(name.equals("Logged In Successfully")) {
				System.out.println("PASS:Login Successfully");
			}
			else
			{
				System.out.println("FAIL");
			}
		}
		finally {
			driver.quit();
		}
	}
} 