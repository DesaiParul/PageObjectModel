package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
	    loginpage = new LoginPage();
	    contactsPage = new ContactsPage();
	   // testUtil.switchToFrame();
		loginpage.CloseLink();
		//driver.switchTo().defaultContent();
	    homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	    
				
	}
	//Testcases should be separated or independent to each other
	//Before each test cases -- launch the browser
	//@test -- execute the test cases
	//After each test cases -- quit the browser
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "HomePage Title not matched");
	}
	@Test
	public void verifyUsernameTest() {
		Assert.assertTrue(homePage.verifyCorrectUsername());
	}
	@Test
	public void verifyContactsLinkTest(){
		contactsPage = homePage.clickOnContactsLink();
	
	}
	
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
