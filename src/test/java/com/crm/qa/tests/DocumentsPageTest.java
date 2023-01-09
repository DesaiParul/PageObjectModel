package com.crm.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DocumentsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DocumentsPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	CalendarPage calendarPage;
	DocumentsPage documentsPage;
	
	
	public DocumentsPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
	    loginpage = new LoginPage();
	    contactsPage = new ContactsPage();
	    calendarPage = new CalendarPage();
	    documentsPage = new DocumentsPage(); 
	   // testUtil.switchToFrame();
		//loginpage.CloseLink();
		//driver.switchTo().defaultContent();
	    homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	    documentsPage = homePage.clickOnDocumentsLink();
				
	}
	
	@Test(priority = 1)
	public void verifyUsernameTest() {
		Assert.assertTrue(documentsPage.verifyDocumentsLabel(), "Contact Label is missing on Page");
	}
	
	@Test(priority = 2)
	public void verifyNewFolderCreated() {
		documentsPage.NewFolderCreated();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
