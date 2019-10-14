package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.Login;
import utility.DriverFactory;

@Test
public class Login1 {
	private WebDriver driver;
	private Login loginPageObject;
	
	@Test(priority=1)
	public void Login() throws InterruptedException {
	Login.login();
	
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
