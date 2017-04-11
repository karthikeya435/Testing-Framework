package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Factory.Browserfactory;
import Factory.Dataproviderfactory;
import PageObjects.Homepage;

public class Homepageverification 
{

	public static WebDriver driver;
	public static Homepage p;

	@Test
	public void invokebrowser() 
	{
		driver=Browserfactory.getBrowser("chrome");
		driver.manage().window().maximize();

		p=PageFactory.initElements(driver, Homepage.class);
		String URL=Dataproviderfactory.exceldata().getData("Sheet1", 0, 1);

		driver.get(URL);
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Infor Xtreme Log In"), "Build Restarted");
		//					if(driver.getTitle()=="Not Found")
		//					{
		//						System.out.println("Build is not ready");
		//						Browserfactory.close();
		//					}
	}

	@Test(priority=1,dependsOnMethods={"invokebrowser"})
	public void username()
	{

		if(p.testusername()==true)
		{

			p.enterusername();

		}
		else 
		{
			Browserfactory.close();
			Assert.assertTrue(false, "Username Field does not exist");


		}

	}



	@Test(priority=2,dependsOnMethods={"username"})
	public void pwd()
	{
		if(p.testpwd()==true)
		{
			p.enterpwd();
		}
		else 
		{
			Browserfactory.close();
			Assert.assertTrue(false, "Invalid Password Field");
			//				System.out.println("Password field does not exist");
			//				driver.quit();

		}
	}
	@Test(priority=3,dependsOnMethods={"username","pwd"})
	public void submit()
	{
		if(p.Signin()==true)
		{
			p.btnsubmit();

			String get_title=driver.getTitle().toString();
			if(get_title.contains("Infor Xtreme Home Page"))
			{
				System.out.println("Need to write code");

			}

			else if(get_title.contains("Maintenance Expired"))
			{
				System.out.println("Contact customer support");
			}
			else if(p.Username.equals(null))
			{
				String Email_id_missing=driver.findElement(By.xpath("//*[@id='divError']")).getText();
				System.out.println(Email_id_missing);
			}
			else if(p.pwd.equals(null))
			{
				String Pwd_missing=driver.findElement(By.xpath("//*[@id='divError']")).getText();
				System.out.println(Pwd_missing);
			}
			else if(p.Username==null && p.pwd==null)
			{
				String username_pwd_blank=driver.findElement(By.xpath("//*[@id='divError']")).getText();
				System.out.println(username_pwd_blank);
			}
			else 
			{
				String Invalid_username_pwd=driver.findElement(By.xpath("//*[@id='divError']")).getText();
				System.out.println(Invalid_username_pwd);

			}

		}

		else 
		{
			Browserfactory.close();
			Assert.assertTrue(false, "Invalid SignIn field ");

		}
		Browserfactory.close();
	}

}









