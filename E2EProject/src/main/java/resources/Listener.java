package Resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listener extends Base implements ITestListener {

	ExtentTest test;// this is the where Extent report will be assigned on just like webdriver
	ExtentReports extent=ExtentReporterNg.getReportObject();//we are calling ExtentReporterNG class and it's methodgetReportObject method 
														//which is static class so object creation is not necessary however we need assign it again in ExtentReports class 
	
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>(); //this is the class we need when we execute the test parallelly
																// It secure that once it a class is starting to execute it ensures that it get executed so you have metntion the "ExtenTest" as type whose class it is going to execute
	
	public void onTestStart(ITestResult result) {
		
		test=extent.createTest(result.getMethod().getMethodName());
		
		extentTest.set(test);// now using Thread local you are passing al the classes of test that it was going to produce report on to Thread Class 
	}

	public void onTestSuccess(ITestResult result) {
		//ExtentTest has a classes like .log which can give status like when test is passed as well as adding any comment
		//test.log(Status.PASS, "Test Passed");
		
		extentTest.get().log(Status.PASS, "Test Passed");// when you execute test parallelly instead of using test.log(Status.PASS, "Test Passed"); you use this one from ThreadLocal class
	
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getName().toString().trim();
		try {
			testUtil.captureScreenshot(methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		//test.fail(result.getThrowable());
		extentTest.get().fail(result.getThrowable());// when you execute test parallelly instead of using test.fail(result.getThrowable()); you use this one from ThreadLocal class
	
	// if you want add screenshot on failure from your in extentReport you have to add the following lines ThreadLocal's method
		extentTest.get().addScreenCaptureFromPath(testUtil.mailscreenshotpath, result.getMethod().getMethodName());
	
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {

	extent.flush();
	}
	
	
}
