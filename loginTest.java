package testcases;

import java.io.InputStream;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



import base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import screens.LoginScreen;
import screens.PreLoginScreen;
public class loginTest extends TestBase {
	
	PreLoginScreen pre_login; 
	LoginScreen loginpage;

	JSONObject loginUsers;
	
	@BeforeTest
	public void init()
	{
		      InputStream datais = null;
			  String dataFileName = "data/loginUsers.json";
			  datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
			  JSONTokener tokener = new JSONTokener(datais);
			  loginUsers = new JSONObject(tokener);
			  
			  
		//appium server get started
		setup();
		pre_login = new PreLoginScreen(driver);
		loginpage = new LoginScreen(driver);
	}
	
	
	@Test(priority=0)
	public void validateUserInterface()
	{
		System.out.println("Login UI start ");
		System.out.println(" ");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		pre_login.clickLoginBTn();
		SoftAssert sa = new SoftAssert();
					
			
			sa.assertTrue(loginpage.UserName(), "the email id text box is not present");
			System.out.println("Email id text box is present");
			
			sa.assertTrue(loginpage.Password(), "the password text box is not present");
			System.out.println("password text box is present");
			
			sa.assertTrue(loginpage.loginBtn(), "the login button is not present");
			System.out.println("Login button is present");
			
			sa.assertTrue(loginpage.Signup(), "the Signup button is not present");
			System.out.println("Signup button is present");
			
			sa.assertTrue(loginpage.ForgotPassword(), "the forgot password is not present");
			System.out.println("forgot password link is present");
			
			sa.assertTrue(loginpage.HaveorgCode(), "the have an org code link is not present");
			System.out.println("Have an organization code link is present");
			
			System.out.println("login UI stop ");
			System.out.println(" ");
	}
	

	@Test(priority=1)
	public void EnterValidUserNameOnly() throws InterruptedException
	{
	
		System.out.println("Started login with invalid user Name ");
		loginpage.EnteruserName(loginUsers.getJSONObject("invalidUser").getString("username"));
		loginpage.Enterpassword(loginUsers.getJSONObject("invalidUser").getString("password"));
		loginpage.clickLoginBTn();
		takeScreenshot();
		Thread.sleep(3000);
		System.out.println("Ended login with invalid user Name ");
		System.out.println(" ");
		driver.navigate().back();

	}



	@Test(priority=2)
	public void EnterValidPassWordOnly()
	{
		System.out.println("Started login with invalid password");
		pre_login.clickLoginBTn();
		loginpage.EnteruserName(loginUsers.getJSONObject("invalidPassword").getString("username"));
		loginpage.Enterpassword(loginUsers.getJSONObject("invalidPassword").getString("password"));
		loginpage.clickLoginBTn();
		takeScreenshot();
		System.out.println("Ended login with invalid password ");
		System.out.println(" ");
		driver.navigate().back();
		
	}
	
	@Test(priority=3)
	public void EnterValidLoginCredentials()
	{
		System.out.println("started login with valid credentials ");
		pre_login.clickLoginBTn();
		loginpage.EnteruserName(loginUsers.getJSONObject("validUser").getString("username"));
		loginpage.Enterpassword(loginUsers.getJSONObject("validUser").getString("password"));
		loginpage.clickLoginBTn();
		System.out.println("Home Screen is Displayed");
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		System.out.println(" ");
		
		
	}

	@AfterTest
	public void quit() 
	{
		Quit();
	}

}
