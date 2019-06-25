package com.newtours.selenium.utilies;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Commons 
{
	public WebDriver driver;
	public OpenBrowser browser = new OpenBrowser();
	public FileInputStream fis,fis1;
	public Properties prop,or;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	
	public void enterData(WebDriver driver,ExtentTest test, String Xpathvalue, String Value)
	{
		try
		{
		driver.findElement(By.xpath(Xpathvalue)).sendKeys(Value);
		Reporter.log(Value + " is entered");
		test.log(LogStatus.PASS, Value + " is entered");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			test.log(LogStatus.FAIL, Value + " is not entered" + e.getMessage());

		}
		
	}
	
	public void click(WebDriver driver,String xpathvalue)
	{
		try
		{
			driver.findElement(By.xpath(xpathvalue)).click();
			Reporter.log(xpathvalue + " is clicked");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public void navigateURL(WebDriver driver,ExtentTest test,String url)
	{
		try
		{
			driver.get(url);
			test.log(LogStatus.PASS, url + " is entered");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			test.log(LogStatus.FAIL, url + " is not entered "  + e.getMessage());

		}
	}
	
	public void currentURL(WebDriver driver,String ExpectedURL)
	{
		try
		{
			String currenturl = driver.getCurrentUrl();
			System.out.println(currenturl);
			
			if(currenturl.equalsIgnoreCase(ExpectedURL))
			{
				System.out.println(currenturl + " is matched");
			}else
			{
				System.out.println(currenturl + " is not matched");
			}
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public void getTitle(WebDriver driver,String Expectedtitle)
	{
		try
		{
			String title = driver.getTitle();
			System.out.println(title);
			
			if(title.equalsIgnoreCase(Expectedtitle))
			{
				System.out.println(title + " is matched");
				Reporter.log(title + " is matched");
			}else
			{
				System.out.println(title + " is not matched");
				Reporter.log(title + " is not matched");
			}
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
}
