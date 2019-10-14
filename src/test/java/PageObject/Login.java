package PageObject;



import java.awt.Window;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.NewTest;

public class Login extends LoadableComponent<Login> {
	
	public static WebDriver driver;
	

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "userName")
	public static WebElement username;
	@FindBy(how = How.NAME, using = "password")
	public static WebElement password;
	@FindBy(how = How.NAME, using = "Login")
	public static WebElement login_button;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "SignIn")
	public static WebElement login;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "SignOut")
	public static WebElement logout;

	@Override
	protected void load() {
		// TODO Auto-generated method stub
      driver.manage().window().maximize();
      driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
     String url=driver.getCurrentUrl();
     Assert.assertTrue(url.endsWith("login.htm"));
	}
	
	public static void login() {
		Login.username.sendKeys("Lalitha");
		Login.password.sendKeys("Password123");
		Login.login_button.click();
		WebElement user=driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul"));
		String userValue=user.getText();
		Assert.assertTrue(userValue.contains("Hi, Lalitha"));
		Login.logout.click();
	}
	public static void login(String username,String Password) {
		Login.username.sendKeys(username);
		Login.password.sendKeys(Password);
		Login.login_button.click();
		/*WebElement user=driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul"));
		String userValue=user.getText();
		Assert.assertTrue(userValue.contains("Lalitha"));
		Login.logout.click();*/
	}
	

	public static void verify(String actual,String page) {
		Assert.assertEquals(actual, page);
		
		
		
		
		
	}
}
