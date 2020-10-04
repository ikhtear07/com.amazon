package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg {
	
	public static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		
			
		//"user.dir" sets the path up to project location then the extra path needs to be added+ html file+filename +fileextension 
		
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		//this class is used to receive the location of the html file +file name and extension as argument
		// we also use 2 of it's method to set report name and to set report document title name
		ExtentSparkReporter reporter =new ExtentSparkReporter(path);
		reporter.config().setReportName("Zubair's report");// this is to set report's name
		reporter.config().setDocumentTitle("Test Result");// this is to set report's document title
		
		
		extent = new ExtentReports();// creating an object of ExtentReports. 
									//	this will create the report as per configuration set by the earlier classes
		extent.attachReporter(reporter);// with this method report is created as per configuration set earlier
		extent.setSystemInfo("Tester", "Ahmed Zibair");

		return extent;
	}

}
