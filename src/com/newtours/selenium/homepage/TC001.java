package com.newtours.selenium.homepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.newtours.selenium.utilies.Commons;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class TC001 extends Commons
{
	
	@BeforeSuite
	public void loadfiles() throws Exception
	{
		extent = new ExtentReports("D:\\Rajani\\NewTours\\NewTours.html", true);
			
		fis = new FileInputStream("D:\\Rajani\\NewTours\\Resources\\config.properties");
		prop = new Properties();
		prop.load(fis);
		fis1 = new FileInputStream("D:\\Rajani\\NewTours\\Resources\\OR.properties");
		or = new Properties();
		or.load(fis1);
		
		
	}
	
	
	
	@Test
	public void TC001()
	{
		try
		{
			FileInputStream fis = new FileInputStream("D:\\Rajani\\NewTours\\Testdata\\NewTours.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("TestData");
			for(int i = 0; i<= sheet.getLastRowNum(); i++)
			{
				if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("TC001") && sheet.getRow(i).getCell(2).getStringCellValue().equalsIgnoreCase("Yes"))
				{
					test = extent.startTest("NewTours Login", "Validate New Tours Login Functionality");
					driver=browser.browserOpen("chrome");
					navigateURL(driver,test, sheet.getRow(i).getCell(5).getStringCellValue());
					getTitle(driver, "Welcome: Mercury Tours");
					enterData(driver,test, or.getProperty("Username"), "Selenium");
					enterData(driver,test, or.getProperty("Password"), "Selenium WebDriver");
					test.log(LogStatus.PASS, "New Tours Login Functionality");
					test.log(LogStatus.FAIL, "New Tours Login Functionality");
					test.log(LogStatus.INFO, "New Tours Login Functionality");
					test.log(LogStatus.WARNING, "New Tours Login Functionality");
					test.log(LogStatus.PASS, "New Tours Login Functionality");

				}
				if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("TC001") && sheet.getRow(i).getCell(2).getStringCellValue().equalsIgnoreCase("No"))
				{
					throw new SkipException("TC001 runmode mentioned as No");
				}
			}
			
			
		}catch(Exception e)
		{
			System.out.println("TC001 is failed - " + e.getMessage());
		}finally
		{
			extent.endTest(test);
			extent.flush();
		}
	}

}
