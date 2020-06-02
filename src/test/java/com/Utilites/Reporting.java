package com.Utilites;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.TestCases.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//Listener class used to generate Extent reports

public class Reporting
{
	public WebDriver driver;
	public ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
		
	@BeforeTest
	public void setExtent() {
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myReport.html");
		htmlreporter.config().setDocumentTitle("SeleniumProj");
		htmlreporter.config().setReportName("Phani");
		htmlreporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("TesterName", "Phani");
		extent.setSystemInfo("Browser","chrome");
	}
	
	
	/*@Test
	public void demo() {
		test=extent.createTest("Demo Method");
		Assert.assertTrue(true);
	}*/
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		if(result.getStatus()== ITestResult.FAILURE){
		test.log(Status.FAIL,"TEST CASE FAILED IS " + result.getName());
		test.log(Status.FAIL,"TEST CASE FAILED IS " + result.getThrowable());
	String screenshotPath = BaseClass.getScreenshot(driver,result.getName());
	test.addScreenCaptureFromPath(screenshotPath);
	}	
		else if (result.getStatus() == ITestResult.SKIP){
			test.log(Status.SKIP,"Test case SKIPPED IS "+ result.getName());
		}
		else if(result.getStatus() == ITestResult.SUCCESS){
			test.log(Status.PASS,"Test Cases PASSED IS" + result.getName());
		}	
}
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		String dateName =new SimpleDateFormat().format(new Date());
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);

		//after execution, you could see a folder "FailedTestsScreenshots" under src folder destination
		String destination = System.getProperty("user.dir")+"/Screenshots/"+ screenshotName + dateName+".png";
		File finalDestination =new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	
	@AfterTest
	public void endReport() {
		extent.flush();
	}
}