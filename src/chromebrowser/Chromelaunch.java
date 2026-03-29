package chromebrowser;




import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chromelaunch {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
//		WebElement btn=driver.findElement(By.xpath("//button[@type='submit]"));
//		btn.click();
		WebElement txtsearch=driver.findElement(By.id("twotabsearchtextbox"));
		
		txtsearch.sendKeys("iPhone", Keys.ENTER);
		WebElement lnkiphone=driver.findElement(By.xpath("//Span[contains(text(),'Apple iPhone 15 (128 GB) - Black')]"));
		lnkiphone.click();
		
		String parentWindowId=driver.getWindowHandle();
		System.out.println(parentWindowId);
		
		Set<String>allWindowsId=driver.getWindowHandles();
		System.out.println(allWindowsId);
		
		for(String eachWindowId:allWindowsId) {
			if(!eachWindowId.equals(parentWindowId)) {
				
				driver.switchTo().window(eachWindowId);
				WebElement btnCart=driver.findElement(By.id("add-to-cart-button"));
				
				JavascriptExecutor js=(JavascriptExecutor) driver;
                js.executeScript("arguments[0].click()", btnCart);
				driver.close();
				
			//	git practice
			}
		}
			}
}
	
	

	

