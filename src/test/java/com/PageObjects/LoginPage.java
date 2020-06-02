package com.PageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver rdriver){
		
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
		
	@FindBy(name="email")
	WebElement txtUser;
	
	@FindBy(name="pass")
	WebElement txtPass;
	
	@FindBy(id="loginbutton")
	WebElement submitbtn;
	
	@FindBy(id="userNavigationLabel")
	WebElement dropdown;
	
	@FindBy(id="u_1f_5")
	WebElement logoutbtn;
	
	public void setUserName(String userName) {
		txtUser.sendKeys(userName);
	}
	
	public void setPassword(String userPass) {
		txtPass.sendKeys(userPass);
	}
	
	public void clickSubmit() {
		submitbtn.click();		
	}
	
	public void clickDropDown() {
		dropdown.click();
	}

	public void clickLogoutbtn() {
		logoutbtn.click();		
	}
	
}
