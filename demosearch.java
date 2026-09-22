package testcase1;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demosearch {
	public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.in");
        Thread.sleep(7000);
        String expected = "mobile";
        //by name will be get from inspect in google we will get name=q
        //sendKeys will fill 'Selenium java' in google textbox
        //keys.enter will automatically search in google
        driver.findElement(By.id("twotabsearchtextbox"))
        .sendKeys(expected + Keys.ENTER);
        
        
        String title = driver.getTitle();
        
        if(title.contains(expected)) {
        	System.out.println("PASS");
        }else {
        	System.out.println("FAIL");
        }
        
        driver.quit();
        
    }
}
