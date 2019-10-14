package com;

import org.testng.annotations.Test;

import PageObject.Login;
import utility.DriverFactory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

@Test (priority=1)
public class LoginMultiple {
	private Login loginPageObject;
	
	private WebDriver driver;
	@Test(dataProvider="dp")
  public void f(String username, String password) throws InterruptedException {
	  
	
	  Login.username.sendKeys(username);
	  Login.password.sendKeys(password);
	  Login.login_button.click();
	 // Login.logout.click();
	 // Thread.sleep(2000);
	 // Login.login.click();
	  driver.findElement(By.xpath("/html/body/main/div/div/div/div[1]/button/h4")).click();
  }
	@Test(priority=2)
	public void admin_login() throws AWTException, InterruptedException {
		Select add_category=new Select(driver.findElement(By.id("categorydropid")));
		add_category.selectByVisibleText("Electronics");
		
		driver.findElement(By.id("prodid")).sendKeys("Earphone");
		driver.findElement(By.id("priceid")).sendKeys("20");
		driver.findElement(By.id("quantityid")).sendKeys("20");

		driver.findElement(By.id("brandid")).sendKeys("121");

		driver.findElement(By.id("description")).sendKeys("yooo");
		String product_image="C:\\Users\\pdc4-training.pdc4\\Downloads\\earphone.jpg";
		StringSelection sel=new StringSelection(product_image);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, sel);
        Thread.sleep(2000);
		WebElement Browse_button = driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[8]/div/div/div/div/div/div[1]/span/div/div"));
		Browse_button.click();
		Robot robot=new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[10]/div/input[1]")).click();
	

	}

  @DataProvider
  public String[][] dp() {
    return new String[][] {
      //new String[] { "Lalitha", "Password123" },
      new String[] { "admin", "Password456" },
    };
  }
  @BeforeTest
  public void beforeTest() {
	  driver=DriverFactory.getDriver("chrome");
		 loginPageObject=PageFactory.initElements(driver,  Login.class);
		 loginPageObject.get();  
  }
  

  @AfterTest
  public void afterTest() {
	  System.out.println("in after test");
  }

}
