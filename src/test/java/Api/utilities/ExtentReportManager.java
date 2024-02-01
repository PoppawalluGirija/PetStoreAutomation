package Api.utilities;

import java.text.SimpleDateFormat;

import org.apache.poi.hpsf.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	
	public ExtentSparkReporter sparkReporter;//represents UI reports
	public ExtentReports extent;//common details like names ,data
	public ExtentTest test;//reports entries of test wether passed or failed
	
	String repName;
	
	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp  this will maintain the history of report
		repName="Test-Report-"+timeStamp+".html";
		
		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);//specify location of the report//.represents current project
		
		sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject");//Title of report
		sparkReporter.config().setReportName("Pet Store Users API");//name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application","Pet Store Users API" );
		extent.setSystemInfo("Operating System",System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Girija");
		
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, "Test Passed");
	}
	
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, "Test Skipped");
		test.log(Status.FAIL, result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();//without flush reports will not be generated
	}
	

}
