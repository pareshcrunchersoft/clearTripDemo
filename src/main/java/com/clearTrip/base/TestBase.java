package com.clearTrip.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	
	public  TestBase() {
		// TODO Auto-generated constructor stub
		try {
			 fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/clearTrip/config/config.properties");
			 prop = new Properties();
			 prop.load(fis);
		} catch (FileNotFoundException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch( IOException e)
		{
			e.printStackTrace();
			
		}
		
				
	}
	
	
	public static void init()
	{
		if(prop.getProperty("browser").equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
	}
	
	/*public static void main(String args[])
	{
		//System.out.println("UD==>"+System.getProperty("user.dir"));
		TestBase tb= new TestBase();
		tb.init();
	}*/

}
