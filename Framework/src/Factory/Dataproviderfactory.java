package Factory;

import DataProvider.Readconfig;
import DataProvider.Readexceldata;

public class Dataproviderfactory {
	
	static Readconfig config;
	static Readexceldata excelvalue;

	public static Readconfig configfile()
	{
		if(config==null)
		{
			config=new Readconfig();
		}
		return config;
	}
	public static Readexceldata exceldata()
	{
		if(excelvalue==null)
		{
			excelvalue=new Readexceldata();
		}
		return excelvalue;
	}
	
	
	
	
}
