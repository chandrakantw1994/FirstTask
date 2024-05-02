package Pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Base.FrameWorkBase;



//This class is created against the Web Page corresponding to Download 
public class DownloadPage extends FrameWorkBase
{
	
	// This method is used to open Download Page
	// and for Point No.2 - In Primary Menu (on top of the website) go to Product ->Download
	public static boolean openDownloadPage() 
	{
		
		
		driver.findElement(By.xpath("//li[@class='main-menu-item has-submenu']/a")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Download')]")).click();
		
		String v_downloadPageHeader = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='dc-title dc-title-wrapper']")))
				.getText();
		
		if (v_downloadPageHeader.equalsIgnoreCase("Download"))
		{
			System.out.println("Download Page Opened Sucessfully");
			return true;
		}
		else
		{
			System.out.println("Failed to open Download Page");
			return false;
		}
	}
	
	
	// This method is used for checking the required sections on this page
	// and for Point No.3 -  Check it has 3 sections: New installation, Update, Apps.
	public static boolean checkDesiredSections()
	{
		
		List<WebElement> v_sections = driver.findElements(By.xpath("//h3[@class='downloads-main-card-title']"));
		int v_section_count=0;
		for (WebElement we : v_sections)
		{
			String v_section = we.getText();
			if (
					v_section.equalsIgnoreCase("New installation") ||
					v_section.equalsIgnoreCase("Update") ||
					v_section.equals("Apps")
				)
			{
				System.out.println(v_section+" : is present");
				v_section_count++;
			}
			else
			{
				System.out.println(v_section+" : is not present");
			}
		}
		if (v_section_count==3)
			return true;
		else
			return false;
		
	}
}
