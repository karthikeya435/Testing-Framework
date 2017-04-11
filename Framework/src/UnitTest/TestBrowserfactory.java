package UnitTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Factory.Browserfactory;

public class TestBrowserfactory 
{
	public static WebDriver driver;
	@Test
	public static void testfirefox()
	{
		driver=Browserfactory.getBrowser("firefox");
		Browserfactory.close();
	}
	@Test
	public static void testchrome()
	{
		driver=Browserfactory.getBrowser("chrome");
		Browserfactory.close();
	}
	@Test
	public static void testie()
	{
		driver=Browserfactory.getBrowser("IE");
		Browserfactory.close();
	
	}
	
}

