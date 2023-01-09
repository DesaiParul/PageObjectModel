package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class DocumentsPage extends TestBase{
	TestUtil testUtil;

	
	
	//PageFactory : OR
	
			@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
			WebElement userNameLabel;
			
			@FindBy(xpath = "//button[contains(text(),'New Folder')]")
			WebElement NewFolderLink;
			
			@FindBy(xpath = "//input[@name='addFolderName']")
			WebElement NewFolderName;
			
			@FindBy(xpath = "//button[@class='ui button']")
			WebElement saveBtnNewFolder;
			
			
			//initializing the page object
			 public DocumentsPage() {
				 PageFactory.initElements(driver, this);
				 
			}
			 
			 
			//Actions:
			 
				public boolean verifyDocumentsLabel() {
					return userNameLabel.isDisplayed();
				}
				public void NewFolderCreated() {
					 NewFolderLink.click();
					
					 NewFolderName.sendKeys("Testing Folder");
					
					 saveBtnNewFolder.click();
					
					  
				}
				
				
				
				
				
				
				
}
