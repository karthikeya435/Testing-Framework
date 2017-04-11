package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Readconfig {

	Properties pro;
	
	public Readconfig()
	{
		try {

			File src=new File("./Config/config.properties");

			FileInputStream fis=new FileInputStream(src);
			
			pro=new Properties();
			
			pro.load(fis);
			//System.out.println("File loaded");
		} 
		catch (FileNotFoundException e) {

		System.out.println("File not found");
		} catch (IOException e) {

			System.out.println("IO Exception found");
		}
	}
	public String getiepath()
	{
		
		String ie_path=pro.getProperty("IEpath");
		
		return ie_path;
		
	}
	public String getchromepath()
	{
		String chrome_path=pro.getProperty("chromepath");
		
		return chrome_path;
	}
	
	public void getdata()
	{
		Readconfig rc=new Readconfig();
		System.out.println(rc.getiepath());
	}
}

