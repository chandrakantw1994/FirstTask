package Tests;

import org.testng.annotations.Test;

import Base.FrameWorkBase;
import Pages.AppsPage;
import Pages.DownloadPage;
import junit.framework.Assert;

public class FirstTaskTest extends FrameWorkBase
{
	@Test(priority=1)	
	public static void verifyPointNo1()
	{
		launchBrowser();
		
		boolean v_check = openURL("http://icewarp.co.in");
		
		Assert.assertEquals(true, v_check);
		
	}
	
	
	
	@Test(priority=2)
	public static void verifyPointNo2()
	{
		boolean v_check = DownloadPage.openDownloadPage();
		
		Assert.assertEquals(true, v_check);
		
	}
	
	
	@Test(priority=3)
	public static void verifyPointNo3()
	{
		boolean v_check = DownloadPage.checkDesiredSections();
		
		Assert.assertEquals(true, v_check);
	}
	
	
	
	@Test(priority=4)
	public static void verifyPointNo4()
	{
		boolean v_check = AppsPage.openAppsPage();
		
		Assert.assertEquals(true, v_check);
	}
	
	@Test(priority=5)
	public static void verifyPointNo5()
	{
		boolean v_check = AppsPage.checkDesireditems();
		
		Assert.assertEquals(true, v_check);
	}
	
	
	
	@Test(priority=6)
	public static void verifyPointNo6()
	{
		AppsPage.checkDownloadPageOnEachItem();
	}
	
	
	
	@Test(priority=7)
	public static void verifyPointNo7()
	{
		AppsPage.goBackToInitialPage();
	}
	
	
	
}
