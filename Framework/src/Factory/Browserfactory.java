package Factory;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import PageObjects.Homepage;

public class Browserfactory {

	static WebDriver driver;
	static boolean value=false;
	//public static Homepage p;
	
	
		
	public static WebDriver getBrowser(String browsername)
	{
		if(driver==null)
		{
			if(browsername.equalsIgnoreCase("firefox"))
			{
				driver=new FirefoxDriver();
			}
			else if(browsername.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", Dataproviderfactory.configfile().getchromepath());
				driver=new ChromeDriver();
			}
			else if(browsername.equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.ie.driver", Dataproviderfactory.configfile().getiepath());
				driver=new InternetExplorerDriver();
			}
		}
		return driver;
	}
	
	public static void close()
	{
		driver.close();

	}
	public static boolean isEnabled(WebElement test)
	{
		try {
			if(test.isDisplayed() && test.isEnabled())
			{
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//driver.close();
			return false;
			
		}
		//driver.close();
		
		return false;
	}


}




