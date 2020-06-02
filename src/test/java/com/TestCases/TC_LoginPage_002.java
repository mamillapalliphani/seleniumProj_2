package com.TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PageObjects.LoginPage;
import com.Utilites.XLUtlities;

public class TC_LoginPage_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void logindata(String userName,String password) throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		 lp.setUserName( userName);
		 lp.setPassword(password);
		 lp.clickSubmit();
		 Thread.sleep(10000);
		 lp.clickDropDown();
		 lp.clickLogoutbtn();
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws Exception{
		String path= System.getProperty("user.dir")+"/src/test/java/com/TestData/TC_2.xlsx";
		
		int rownum=XLUtlities.getRowCount(path,"Sheet1");
		int colcount=XLUtlities.getCellCount(path,"sheet1", rownum);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++) {
				
				logindata[i-1][j]=XLUtlities.getCellData(path, "sheet1", i, j);
			}
		}
		return logindata;
		
	}
}
