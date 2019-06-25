package com.newtours.selenium.homepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.newtours.selenium.utilies.Commons;

public class TC002 extends Commons
{
	
	@BeforeSuite
	public void loadfiles() throws Exception
	{
		fis = new FileInputStream("D:\\Rajani\\NewTours\\Resources\\config.properties");
		prop = new Properties();
		prop.load(fis);
		fis1 = new FileInputStream("D:\\Rajani\\NewTours\\Resources\\OR.properties");
		or = new Properties();
		or.load(fis1);
		
	}
	
	
	
	@Test
	public void TC00s2()
	{
		try
		{
			driver=browser.browserOpen("chrome");
			navigateURL(driver, prop.getProperty("URL"));
			getTitle(driver, "Welcome: Mercury Tours");
			enterData(driver, or.getProperty("Username"), "Selenium");
			enterData(driver, or.getProperty("Password"), "Selenium WebDriver");
			
		}catch(Exception e)
		{
			System.out.println("TC002 is failed - " + e.getMessage());
		}
	}

}
