package com.TestCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Utilites.ReadConfig;
import com.Utilites.Reporting;

public class BaseClass extends Reporting{
	
	public static ReadConfig readCong=new ReadConfig();
	public static String Baseurl=readCong.getApplicationURL();
	public static String userName=readCong.getUserName();
	public static String password=readCong.getPassword();
	public static String chromeDriver=readCong.getChromeDriver();
	public static String firefoxDriver=readCong.getfirefoxpath();
	public static String ieDriver=readCong.getiepath();
	static WebDriver driver;
	
	public static Logger logger;
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		logger=Logger.getLogger("FaceBook project logger");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",readCong.getChromeDriver());
		driver=new ChromeDriver();
		}
		else if(br.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",readCong.getfirefoxpath());
				driver=new FirefoxDriver();
		}
		else if(br.equals("ie")) {
				System.setProperty("webdriver.ie.driver",readCong.getiepath());
				driver=new InternetExplorerDriver();
		}
		
		driver.get(Baseurl);
		logger.info("URL is opened");
	}

	/*@AfterClass
	public void teardown() {
		driver.close();
	}*/
	
}
