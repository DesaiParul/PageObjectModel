package com.crm.qa.pages;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

import io.netty.handler.codec.AsciiHeadersEncoder.NewlineType;

public class HomePage extends TestBase {
	
	//PageFactory : OR
	
	@FindBy(xpath = "//span[@class='user-display']")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//span[contains(text(),'Calendar')]")
	WebElement CalendarPageLink;
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement ContactsPageLink;
	
	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement DeaksPageLink;
	
	@FindBy(xpath = "//span[contains(text(),'Documents')]")
	WebElement DocumentsPageLink;
	
	@FindBy(xpath = "//div[@id='main-nav']//div[3]//button/i")
	WebElement NewContactLink;
	
	@FindBy(xpath = "//div[@id='main-nav']/div[2]/button[1]/i[1]")
	WebElement NewCalendarLink;
	
	
	
	
	
	
	//initializing the page object
		 public HomePage() {
			 PageFactory.initElements(driver, this);
		
		}
		 
	//Actions:
		 
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	public boolean verifyCorrectUsername() {
		return userNameLabel.isDisplayed();
	}
	public ContactsPage clickOnContactsLink() {
		ContactsPageLink.click();
		return new ContactsPage();
	}
	public CalendarPage clickOnCalendarLink() {
		CalendarPageLink.click();
		return new CalendarPage();
	}
	public DealsPage clickOnDealsLink() {
		DeaksPageLink.click();
		return new DealsPage();
	}
	public DocumentsPage clickOnDocumentsLink() {
		DocumentsPageLink.click();
		return new DocumentsPage();
	}
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(ContactsPageLink).build().perform();
		NewContactLink.click();
		
	}

	public void clickOnNewCalendarLink() {
		Actions action = new Actions(driver);
		action.moveToElement(CalendarPageLink).build().perform();
		NewCalendarLink.click();
		
	}
}
