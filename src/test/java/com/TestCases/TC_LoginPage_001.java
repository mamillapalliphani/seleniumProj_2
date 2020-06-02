package com.TestCases;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.PageObjects.LoginPage;
import com.Utilites.Reporting;




public class TC_LoginPage_001 extends BaseClass{
		
	@Test
	public static void login() throws IOException {
		test=extent.createTest("TC_LoginPage_001");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("UserName is entered");
		lp.setPassword(password);
		logger.info("Password is entered");
		lp.clickSubmit();
		logger.info("Login button is clicked");
		//System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Facebook – log in or sign up")) {
			Assert.assertTrue(true);
			logger.info("Title is Correct");
			//getScreenshot(driver, "login");
			}else {
				//getScreenshot(driver, "login");
			Assert.assertTrue(false);
			logger.info("Title is worng");
		}
	}
}
