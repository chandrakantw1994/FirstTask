package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Base.FrameWorkBase;



// This class is created against Web page corresponding to Apps
public class AppsPage extends FrameWorkBase
{
	public static List<WebElement> v_items;
	
	
	
	// This method is used to open Apps page.
	// for Point No.4 - Go to Apps.
	public static boolean openAppsPage()
	{
		
		driver.findElement(By.xpath("//h3[contains(text(),'Apps')]//ancestor::div[@class='downloads-main-responsive']//following-sibling::a")).click();
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'IceWarp Mobile')]"))).isDisplayed())
		{
			System.out.println("Apps Page opened Successfully");
			return true;
		}
		else
		{
			System.out.println("Failed to open Apps page");
			return false;
		}
	}
	
	
	
	
	// This method is used for checking the required items on this page.
	/* for
	 * Point No.5 - Check, that following items are present on the page: IceWarp
	 * Mobile, IceChat Mobile, Authenticator, Desktop Client, IceWarp Desktop Suite,
	 * Outlook Sync, FileSync, ChatGPT, Remote Management Console, Microsoft
	 * Exchange Migration Tool.
	 */
	public static boolean checkDesireditems()
	{
		v_items = driver.findElements(By.xpath("//div[@class='download-box-app-left-title']"));
		int v_item_count=0;
		for (WebElement we1 : v_items )
		{
			
			String v_item = we1.getText();
			if (
					v_item.equalsIgnoreCase("IceWarp Mobile") ||
					v_item.equalsIgnoreCase("IceChat Mobile") ||
					v_item.equalsIgnoreCase("Authenticator") ||
					v_item.equalsIgnoreCase("Desktop Client") ||
					v_item.equalsIgnoreCase("IceWarp Desktop Suite") ||
					v_item.equalsIgnoreCase("Outlook Sync") ||
					v_item.equalsIgnoreCase("FileSync") ||
					v_item.equalsIgnoreCase("ChatGPT") ||
					v_item.equalsIgnoreCase("Remote Management Console") ||
					v_item.equalsIgnoreCase("Microsoft Exchange Migration Tool")
				)
			{
				System.out.println(v_item+" : is Present ");
				v_item_count++;
			}
			else 
			{
				System.out.println(v_item+" : is not present");
				
			}
		}
		if (v_item_count == 10)
			return true;
		else
			return false;
	}
	
	
	
	
	
	
	// This method i used to verify availability of Download icons/options corresponding to each items on this page
	/* for
	 * Point No.6 - Check, that each item has at least one download page.  In case,
	 * some item does not, raise exception, that tells which item does not have
	 * download page.
	 */
	public static void checkDownloadPageOnEachItem()
	{
		
		
		for (WebElement we1 : v_items )
		{
			String v_item = we1.getText();
			try
			{
				if (driver.findElement(By.xpath("//div[contains(text(),'"+v_item+"')]//parent::div[@class='download-box-app-left-top']//following-sibling::div/div/a")).isDisplayed())
				{
					System.out.println("Atleast one Download option is available for item:"+v_item);
				}
				
				
			}
			catch(Exception e)
			{
				System.out.println("No Download option available for item:  "+v_item);
				continue;	
			}
		}
	}
	
	
	
	
	// This method takes you back to initial Page.
	// Point No.7 - Go back to initial Page
	public static void goBackToInitialPage()
	{
			driver.findElement(By.xpath("//a[@class='main-menu-logo']")).click();
	}
}
