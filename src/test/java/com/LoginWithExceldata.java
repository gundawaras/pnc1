package com;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExcelUtility;

public class LoginWithExceldata {
 private WebDriver driver;

	@Test(dataProvider="credentials")
	 public void login(String username, String password) throws InterruptedException {
		  driver.findElement(By.partialLinkText("SignIn")).click();
		  driver.findElement(By.name("userName")).sendKeys(username);
		  driver.findElement(By.name("password")).sendKeys(password);
		  driver.findElement(By.name("Login")).click();
		  driver.findElement(By.partialLinkText("SignOut")).click();
		  Thread.sleep(2000);
		  }
	@DataProvider(name="credentials")
	public Object[] dp() throws IOException {
	return ExcelUtility.read_data_excel();
	}
	
	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.navigate().to("http://10.232.237.143:443/TestMeApp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@AfterMethod
	public void afterMethod(ITestResult testResult) throws IOException
	{ 
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\pdc4-training.pdc4\\Desktop\\achal"+timestamp()+".png"));
		
		
	}
	@AfterTest
	public void afterTest()
	
	{
		
	}
	private String timestamp() {
		// TODO Auto-generated method stub
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		
	}
		  
}
