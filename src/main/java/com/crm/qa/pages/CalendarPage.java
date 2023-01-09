package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CalendarPage extends TestBase{
	
	//PageFactory
	
	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
	WebElement userNameLabel;
	
	@FindBy(name = "title")
	WebElement titlElement;
	
	
	//initializing the page object
	
	 public CalendarPage() {
		 PageFactory.initElements(driver, this);
	 }
	
	
	
	
	
	//Actions
	public boolean verifyCalendarLabel() {
		return userNameLabel.isDisplayed();
	}
	
	public void CreateNewEvent(String tit, String cat){
		
		titlElement.sendKeys(tit);
		
		
		List<WebElement> optionList =driver.findElements(By.xpath("//div[@class='visible menu transition']"));
		for(WebElement ele:optionList) {
			String currentOption = ele.getText();
			if(currentOption.contains(cat)) {
				ele.click();
				break;
			} 
		}
		
		
		
	}

}
