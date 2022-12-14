package com.crm.qa.tests;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;



public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homePage;
	TestUtil testUtil;
	
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
	    loginpage = new LoginPage();
	   
		
	}
	
	@Test(priority = 1 )
	public void LoginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM with Free calling and auto dialing features");
	}
	
	@Test(priority = 2 )
	public void crmLogoImageTest() {
		boolean Logo = loginpage.validateCRMLogo();
		Assert.assertTrue(Logo);
	}
	
		
	@Test(priority = 3)
	public void login() throws InterruptedException {
		//testUtil.switchToFrame();
		loginpage.CloseLink();
		//driver.switchTo().defaultContent();
		 
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
