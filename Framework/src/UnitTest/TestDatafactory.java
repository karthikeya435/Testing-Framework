package UnitTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import Factory.Dataproviderfactory;

public class TestDatafactory {

	@Test
	public static void testdata()
	{
		String chrome_path=Dataproviderfactory.configfile().getchromepath();
		System.out.println(chrome_path);
		Assert.assertEquals(chrome_path, "C:\\Driver\\chromedriver.exe");
		
	}
	@Test
	public static void testiepath()
	{
		String ie_path=Dataproviderfactory.configfile().getiepath();
		System.out.println(ie_path);
		Assert.assertEquals(ie_path, "C:\\Driver\\IEDriverServer.exe");
		
	}
	@Test
	public static void getdata()
	{
		String s=Dataproviderfactory.exceldata().getData("Sheet1", 0, 0);
		System.out.println(s);
	}
}
