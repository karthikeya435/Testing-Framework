package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;

import Factory.Browserfactory;
import Factory.Dataproviderfactory;

public class Homepage {



	@FindBy(how = How.XPATH , using="//*[@id='userId']") 
	public WebElement Username;

	@FindBy(how = How.XPATH , using="//*[@id='password']") 
	public WebElement pwd;

	@FindBy(how = How.ID , using="btnSignIn") 
	public WebElement submit;


	//@SuppressWarnings("deprecation")
	public void enterusername()
	{
		Username.clear();
		String Usrname=Dataproviderfactory.exceldata().getData("Sheet1", 1,1);
		
		if(Usrname.contentEquals("t") )
		{
			Browserfactory.close();
			
			Assert.assertFalse (Usrname.contentEquals("t"), "Username field data from excel is empty");
			//Assert.assertFalse(Usrname.contentEquals("No data"), "Username field data from excel is empty");
		}
		else
		{
			Username.sendKeys(Usrname);

		}
	}

	public void enterpwd()
	{
		pwd.clear();
		String Password=Dataproviderfactory.exceldata().getData("Sheet1", 2,1);
		if(Password.contentEquals("No data"))
		{
			Assert.assertTrue(false, "Password field data from excel is empty");

		}
		else
		{
			pwd.sendKeys(Password);

		}
		
	}

	public void btnsubmit()
	{
		submit.click();
	}
	public boolean testusername()
	{
		boolean d=Browserfactory.isEnabled(Username);
		if(d==true)
		{
			return true;	
		}
		else
		{
			return false;

		}

	}
	public boolean testpwd()
	{
		boolean d=Browserfactory.isEnabled(pwd);
		if(d==true)
		{
			return true;	
		}
		else
		{
			return false;
		}
	}
	public boolean Signin()
	{
		boolean d=Browserfactory.isEnabled(submit);
		if(d==true)
		{
			return true;	
		}
		else
		{
			return false;
		}
	}




}