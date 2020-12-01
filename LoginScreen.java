package screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen extends ScreenBase{
	
	@AndroidFindBy(xpath = "//*[contains(@text,'Email')]")
	public WebElement UserName;

	@AndroidFindBy(xpath = "//*[contains(@text,'Password')]")
	public WebElement Password;

	@AndroidFindBy(xpath = "//*[contains(@text,'Login')]")
	public WebElement loginBtn;
	
	@AndroidFindBy(xpath = "//*[contains(@text,'Sign up')]")
	public WebElement Signup;
	
	@AndroidFindBy(xpath = "//*[contains(@text,' Have an Organization Code? ')]")
	public WebElement HaveorgCode;
	
	@AndroidFindBy(xpath = "//*[contains(@text,'Forgot Password?')]")
	public WebElement ForgotPassword;
	
	@AndroidFindBy(xpath = "//*[contains(@text,'Please enter Email')]")
	public WebElement Errormsg1;
	
	@AndroidFindBy(xpath = "//*[contains(@text,'Please enter Password')]")
	public WebElement Errormsg2;
	
	@AndroidFindBy(xpath = "//*[contains(@text,'Incorrect username or password.')]")
	public WebElement Errormsg3;
	
	@AndroidFindBy(xpath = "//*[contains(@text,'User does not exist.')]")
	public WebElement Errormsg4;
	
//	@AndroidFindBy(xpath = "//*[contains(@text,'Done')]")
//	public WebElement DoneBtn;
	
	

	public LoginScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	public boolean UserName()
	{												
		return UserName.isDisplayed();						
	}

	public boolean Password()
	{												
		return Password.isDisplayed();						
	}

	public boolean loginBtn()
	{												
		return loginBtn.isDisplayed();						
	}

	public boolean Signup()
	{												
		return Signup.isDisplayed();						
	}

	public boolean HaveorgCode()
	{												
		return HaveorgCode.isDisplayed();						
	}

	public boolean ForgotPassword()
	{												
		return ForgotPassword.isDisplayed();						
	}

	
	
	  //Log in as an user 
	  public void login(String emailID,String pwd) throws InterruptedException 
	  {
		  UserName.sendKeys(emailID);
		  Password.sendKeys(pwd);
		  Thread.sleep(3000);
		  loginBtn.click(); 
		  validateSuccessfulLogin();
	  }

	  //Validate Successful login to the page
	  public void validateSuccessfulLogin()
	  {
		  if(UserName.getSize()!=null)
		  {
			  System.out.println("The user "+((WebElement) UserName.getSize()).getText()+" Logged in successfully");
		  }
		  else if(Errormsg1.getSize()!=null)
		  {
			  System.out.println(( Errormsg1).getSize());
		  }
		  else if(Errormsg2.getSize()!=null)
		  {
			  System.out.println(( Errormsg2).getSize());
		  }
		  else if(Errormsg3.getSize()!=null)
		  {
			  System.out.println(Errormsg3.getSize());
		  }
		  else if(Errormsg4.getSize()!=null)
		  {
			  System.out.println(Errormsg4.getSize());
		  }
		  else
		  {
			  System.out.println("Error in logging to the application");
		  }
		  
	  }
	 
	
//	  
//	  //Test have an org code
//	  public void orgCode()
//	  {
//		  HaveorgCode.click();
//		  Thread.sleep(5000);
//		  if(enterOrgCodeText.isDisplayed()==true)
//		  {
//			  System.out.println(enterOrgCodeText.getText());
//		  }
//		  else
//		  {
//			  Assert.fail("Enter organization popup is not displayed");
//		  }
//	  }
//	  
//	  //Test forgot password 
//	  public void forgotPassword()
//	  {
//		  ForgotPassword.click();
//		  
//		  if(forgotPasswordPopup.size()>0)
//		  {
//			  System.out.println("Forgot password popup is displayed");
//		  }
//		  else
//		  {
//			  Assert.fail("Forgot password popup is not displayed");
//		  }
//	  }
//	  
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public LoginScreen EnteruserName(String username)
	{
		UserName.sendKeys(username);
		return this;
	}

	public LoginScreen clearEnteruserName()
	{
		UserName.clear();
		return this;
	}

	public LoginScreen Enterpassword(String password)
	{
		Password.sendKeys(password);
		return this;
	}
	

	public LoginScreen clearEnterpassword()
	{
		Password.clear();
		return this;
	}

	public LoginScreen clickLoginBTn()
	{
		loginBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
//	public HomeScreen clickDoneBtn()
//	{
////		DoneBtn.click();
//		return new HomeScreen(driver);
//	}
}
