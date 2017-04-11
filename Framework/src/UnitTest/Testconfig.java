package UnitTest;

import org.testng.annotations.Test;

import DataProvider.Readconfig;

public class Testconfig {
	
	@Test
	public void readconfig()
	{
		Readconfig rc=new Readconfig();
		String IE_path=rc.getiepath();
		System.out.println(IE_path);
		String C_path=rc.getchromepath();
		System.out.println(C_path);
		
	}
	
	
}
