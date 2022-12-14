package com.crm.qa.pages;

import java.util.List;
import java.util.Locale.Category;

import org.checkerframework.checker.signature.qual.BinaryNameWithoutPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase {
	
	TestUtil testUtil;
	public String sheetName = "Contacts";
	//PageFactory : OR
	
		@FindBy(xpath = "//div[@id='dashboard-toolbar']/div[1]")
		WebElement userNameLabel;
		
		@FindBy(name = "first_name")
		WebElement firstName;
		
		@FindBy(name = "last_name")
		WebElement lastName;
		
		
				
		@FindBy(xpath = "//button[@class='ui linkedin button']")
		WebElement saveBtn;
		
		@FindBy(name = "category")
		WebElement dropDown;
		
		
		@FindBy(xpath = "//th[contains(text(),'Email')]")
		WebElement EmailLink;
		
		
		@FindBy(xpath = "//tr[@class='warning']//label")
		WebElement ContactSelect;
		
		//initializing the page object
		 public ContactsPage() {
			 PageFactory.initElements(driver, this);
			 
		
		}
		 
		//Actions:
		 
			public boolean verifyContactsLabel() {
				return userNameLabel.isDisplayed();
			}
			
			public void clickOnEmailLink() {
				EmailLink.click();
				
			}
			public void VerifyContactSelected() {
				ContactSelect.click();
			}

			public void CreateNewContact(String fName, String lName, String cat) throws InterruptedException{
				Thread.sleep(2000);
				firstName.sendKeys(fName);
				Thread.sleep(2000);
				lastName.sendKeys(lName);
				
			List<WebElement> optionList =driver.findElements(By.xpath("//div[@class='visible menu transition']"));
				for(WebElement ele:optionList) {
					String currentOption = ele.getText();
					if(currentOption.contains(cat)) {
						ele.click();
						break;
					} 
				}
				saveBtn.click();
				
			}

/*
 * Thread.sleep(2000);
				dropDown.click();
				
				Thread.sleep(2000);
				
				
				//driver.switchToFrame("intercom-borderless-frame");
				//testUtil.switchToFrame1();
				
				//driver.switchTo().defaultContent();
				Thread.sleep(5000);
				Select select = new Select(driver.findElement(By.xpath("//div[@class='visible menu transition']/div[1]/span")));
				select.selectByVisibleText(cat);
	*/
	
	
	
	

}
