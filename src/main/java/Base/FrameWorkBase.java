package Base;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameWorkBase 
{
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public static void main(String[] args) 
	{
		//.......
	}
	
	public static void launchBrowser()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chandrakant.W\\eclipse-workspace\\Icewarp\\BrowserDrivers\\chromedriver.exe");
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver,30);
		
	}
	
	public static boolean openURL(String url)
	{
		//Point No.1 -  Navigate to website mentioned above ie. icewarp.co.in
		driver.get(url);
		
		//To accept the Cookie pop-up displayed.
		driver.findElement(By.xpath("//a[@class='cookies-button cookies-button-accept js-cookie-continue']")).click();
				
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='main-menu-logo']"))).isDisplayed());
		{	
			System.out.println("Website opened Succesfully");
			return true;
		}
		
	}
}
