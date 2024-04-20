package GenericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementationClass implements ITestListener
{
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		test=report.createTest(methodName);
		Reporter.log("execution starts from here",true);
		
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName );
		Reporter.log(methodName+"--->executed successfully" );
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		try {
			String screenshot = WebDriverUtility.getscreenShot(BaseClass.sdriver, methodName);
			
			test.log(Status.FAIL,methodName+"----->failed" );
			test.log(Status.FAIL, result.getThrowable());
			test.addScreenCaptureFromPath(screenshot);
			Reporter.log(methodName+"---->failed");
			
			
		}
		
		 catch (Throwable e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP,methodName+"----->skipped" );
		test.log(Status.SKIP, result.getThrowable());
		
	}

	@Override
	public void onStart(ITestContext context) 
	{
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReport/Reporter.html");
		htmlReport.config().setDocumentTitle("fiducia");
		htmlReport.config().setReportName("Sales&Inventory");
		htmlReport.config().setTheme(Theme.DARK);
		
		report= new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Platform", "windows");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/index.php");
		report.setSystemInfo("ReporterName","Rahul");
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		report.flush();
	}
	
}
