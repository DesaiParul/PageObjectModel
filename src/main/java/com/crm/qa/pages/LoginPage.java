package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

import net.bytebuddy.asm.Advice.This;

public class LoginPage extends TestBase {
	
	//PageFactory: OR(Object Repository)
	
	@FindBy(xpath = "//span[contains(text(),'Log In')]")
	WebElement loginlink;
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement loginbtn;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signUpbtn;
	
	@FindBy(xpath = "//div[@class='rd-navbar-panel']")
	WebElement crmlogo;
	
	@FindBy(xpath = "//div[@aria-label='Dismiss']")
	WebElement cancelBtn;
	
	
	//initializing the page object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo() {
		return crmlogo.isDisplayed(); 
	}
	
	public void CloseLink() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> adElement = driver.findElements(By.xpath("//div[@id='intercom-container-body']"));
		
		if(adElement.size()!=0) {
			cancelBtn.click();
		}
		
		
	}
	public HomePage login(String un, String pwd) {
		
		loginlink.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		

		
		return new HomePage();
		
	}
	
	}
