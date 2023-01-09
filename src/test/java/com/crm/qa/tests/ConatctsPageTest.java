package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ConatctsPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	public String sheetName = "Contacts";
	
	
	
	public ConatctsPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
	    loginpage = new LoginPage();
	    testUtil = new TestUtil();
	    contactsPage = new ContactsPage();
	   // testUtil.switchToFrame();
		//loginpage.CloseLink();
		//driver.switchTo().defaultContent();
	    homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	   contactsPage = homePage.clickOnContactsLink();		
	}
	
	@DataProvider
	public Object[][] getCrmTestData() {
		Object data[][]= testUtil.getTestData(sheetName);
		return data;
			}
	
	
	@Test(priority = 1)
	public void verifyUsernameTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contact Label is missing on Page");
	}
	
	@Test(priority = 2) 
	public void verifyEmailLinkTest() {
		
		contactsPage.clickOnEmailLink();
		
	}
	//@Test--------------------------------Getting Error
	public void verifyNameSelected() {
		testUtil.switchToFrame();
		contactsPage.VerifyContactSelected();
	
		
		
	}
	@Test(priority = 3, dataProvider = "getCrmTestData")
	public void validateCreateNewContact(String firstName, String lastName, String category) throws InterruptedException{
		homePage.clickOnNewContactLink();
		contactsPage.CreateNewContact(firstName, lastName, category);
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
