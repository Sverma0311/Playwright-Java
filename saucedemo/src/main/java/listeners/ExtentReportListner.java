package listeners;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportListner implements ITestListener {
	private static final String OUTPUT_FOLDER = "./build/";
	private static final String FILE_NAME = "automationReport.html";
	private static ExtentReports extent = init();
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	private static ExtentReports extentReports;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub		
		String methodName = result.getMethod().getMethodName();
		String qualifieldName = result.getMethod().getQualifiedName();
		int last = qualifieldName.indexOf(".");
		int mid = qualifieldName.substring(0,last).lastIndexOf(".");
		String className = qualifieldName.substring(mid+1, last);
		System.out.println(methodName+" started!");
		ExtentTest extentTest = extent.createTest(methodName, result.getMethod().getDescription());
		extentTest.assignCategory(result.getTestContext().getSuite().getName());
		extentTest.assignCategory(className);
		test.set(extentTest);
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName()+" passed!");
		test.get().pass("Test Passed");
		test.get().log(Status.PASS, "Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName()+" Failed");
		test.get().fail("Test Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName()+" Skipped");
		test.get().fail("Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName()+" Failed with timeout");
		test.get().fail("Test Failed with time out");
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub		
		System.out.println("Test suite started");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test suite completed");
	}

		
	private static ExtentReports init() {
		Path path = Paths.get(OUTPUT_FOLDER);
		if(!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		extentReports = new ExtentReports();
		ExtentSparkReporter reporter = new ExtentSparkReporter(OUTPUT_FOLDER+FILE_NAME); 
		reporter.config().setReportName("Automation test reports");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("system", "window");
		extentReports.setSystemInfo("Build#", "1.1");
		extentReports.flush();
		
		return extentReports;
	}
		
}
