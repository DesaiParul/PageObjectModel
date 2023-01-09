package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CalendarPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homePage;
	TestUtil testUtil;
	CalendarPage calendarPage;
	public String sheetName = "Calendar";
	
	
	public CalendarPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
	    loginpage = new LoginPage();
	  
	    calendarPage = new CalendarPage();
	   // testUtil.switchToFrame();
		//loginpage.CloseLink();
		//driver.switchTo().defaultContent();
	    homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	    calendarPage = homePage.clickOnCalendarLink();
	    
				
	}
	
	@DataProvider
	public Object[][] getCrmTestData() {
		Object data[][]= TestUtil.getTestData(sheetName);
		return data;
			}
	
	
	@Test(priority = 1)
	public void verifyUsernameTest() {
		Assert.assertTrue(calendarPage.verifyCalendarLabel(), "Calendar Label is missing on Page");
	}
	
	
	@Test(priority = 2, dataProvider="getCrmTestData")
	public void validateCreateNewEvent(String title, String category) {
		homePage.clickOnNewCalendarLink();
		calendarPage.CreateNewEvent(title, category);
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
