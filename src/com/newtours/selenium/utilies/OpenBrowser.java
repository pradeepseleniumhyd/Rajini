package com.newtours.selenium.utilies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class OpenBrowser 
{
	WebDriver driver;
	
	public WebDriver browserOpen(String browsername)
	{
		try
		{
		
				if(browsername.equalsIgnoreCase("chrome"))
				{
					System.setProperty("webdriver.chrome.driver", "D:\\Rajani\\NewTours\\drivers\\chromedriver.exe");
					  driver = new ChromeDriver();
				}else if(browsername.equalsIgnoreCase("firefox"))
				{
					System.setProperty("webdriver.gecko.driver", "D:\\Rajani\\drivers\\geckodriver.exe");
					  driver = new FirefoxDriver();
				}else if(browsername.equalsIgnoreCase("ie"))
				{
					System.setProperty("webdriver.ie.driver", "D:\\Rajani\\drivers\\IEDriverServer.exe");
					  driver = new InternetExplorerDriver();
				}else
				{
					System.out.println(browsername + " is not valid browser name");
				}
		}catch(Exception e)
		{
			System.out.println("Browser Open method issue " + e.getMessage() );
		}
		
		return driver;
	}

}
