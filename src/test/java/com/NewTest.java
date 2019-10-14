package com;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.Login;
import utility.DriverFactory;

public class NewTest {
	private WebDriver driver;
	private Login loginPageObject;
	
	/*
	 * public void location() throws InterruptedException { WebElement
	 * aboutus=driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/a/span"));
	 * WebElement
	 * office=driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/ul/li/a/span"));
	 * WebElement location=driver.findElement(By.xpath(
	 * "//*[@id=\"menu3\"]/li[3]/ul/li/ul/li[1]/a/span")); Actions act=new
	 * Actions(driver); act .moveToElement(aboutus) .moveToElement(office)
	 * .moveToElement(location) .click() .build() .perform();
	 */
	/*
	 * Assert.assertEquals(driver.getTitle(), "Home"); String
	 * mainWindow=driver.getWindowHandle();
	 * Set<String>allWindows=driver.getWindowHandles(); for(String
	 * eachwindow:allWindows) { driver.switchTo().window(eachwindow);
	 */
	// }
	/*
	 * Assert.assertEquals(driver.getTitle(), "Contact Us");
	 * driver.switchTo().frame("main_page"); Thread.sleep(1000); WebDriverWait wait
	 * = new WebDriverWait(driver, 200);
	 * wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("demo3")))
	 * ; WebElement address = driver.findElement(By.id("demo3")); String addressText
	 * = address.getText(); System.out.println("Address for chennai is::" +
	 * addressText); driver.switchTo().window(mainWindow);
	 * 
	 * }
	 */
	/*@Test
	public void home_page() throws InterruptedException {
		Login.login("Lalitha", "Password123");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/form/input")));
		driver.findElement(By.xpath("/html/body/div[1]/form/input")).click();
		Thread.sleep(2000);
		Alert a = driver.switchTo().alert();
		a.accept();
		WebElement searchBox = driver.findElement(By.id("myInput"));
		searchBox.sendKeys("Head");
		driver.findElement(By.xpath("/html/body/div[1]/form/input")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[1]")).click();
		WebElement searchBox1 = driver.findElement(By.id("myInput"));
		searchBox1.sendKeys("Travel");
		driver.findElement(By.xpath("/html/body/div[1]/form/input")).click();
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
		List<WebElement> allProduct = driver.findElements(By.xpath("//*[@id=\"cart\"]/tbody/tr"));
		int numberofProduct = allProduct.size();
		List<String> productName = new ArrayList<String>();
		for (int i = 1; i <= numberofProduct; i++) {
			WebElement productElement = driver.findElement(By.xpath("//*[@id=\"cart\"]/tbody/tr["+i+"]/td[1]/div/div/h4"));
			productName.add(productElement.getText());
		}

		List<String> page=new ArrayList<String>();
		page.add("Headphone");
		page.add("Travel 30");
		
		for (int i = 0; i < productName.size(); i++) {
			Login.verify(productName.get(i),page.get(i));
		}
	



	}*/
	@Test
	public void booking_hotel() throws AWTException, InterruptedException
	{Robot r = new Robot();
	r.keyPress(KeyEvent.VK_TAB);
	r.keyRelease(KeyEvent.VK_TAB);
	r.keyPress(KeyEvent.VK_TAB);
	r.keyRelease(KeyEvent.VK_TAB);
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(2000);
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,200)");
		WebElement source= driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceholder1_RadTreeView1\"]/ul/li/ul/li[3]/ul/li[1]/div/div/span"));
		WebElement target= driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceholder1_RadGrid1_ctl00\"]/tbody"));
		Actions act =new Actions (driver);
		act.dragAndDrop(source, target).perform();
		
	}
	/*@BeforeTest
	public void beforeTest() {
		driver = DriverFactory.getDriver("chrome");
		loginPageObject = PageFactory.initElements(driver, Login.class);
		loginPageObject.get();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

	}*/

	@BeforeTest
	public void beforeTest() {
		driver = DriverFactory.getDriver("chrome");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.navigate().to("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
	//driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[4]/div[2]/div/button")).click();
	}
	
	@AfterTest
	public void afterTest() {
		// driver.close();
	}				
  
	
	

}
