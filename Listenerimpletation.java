package CommonUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listenerimpletation implements ITestListener {
	 ExtentSparkReporter reporter;
	 ExtentReports report;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	  String methodName = result.getMethod().getMethodName();
	  Reporter.log(methodName+""+"ex is start",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		String methodName = result.getMethod().getMethodName();
		  Reporter.log(methodName+""+"ex is pass",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		String massege = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		  Reporter.log(methodName+""+"ex is fail"+massege);
		  WebDriverUtil util = new WebDriverUtil();
		  try {
			  util.screenshot(driver, methodName)
		  }
		  
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
		String methodName = result.getMethod().getMethodName();
		  Reporter.log(methodName+""+"ex is skipp",true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
		reporter=new ExtentSparkReporter("./extentreport/report.html");
		 reporter.config().setDocumentTitle("vtigercrm");
		 reporter.config().setTheme(Theme.STANDARD);//to generate report 
		 reporter.config().setReportName("satara");
		 //use extend report class to generate extend report
		 report= new ExtentReports();
		 report.attachReporter(reporter);
		 report.setSystemInfo("OS", "Windows");
		 report.setSystemInfo("Browser", "Chrome");
		 report.setSystemInfo("chromeversion","121");
		 report.setSystemInfo("Author", "satara");
		 
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		
		report.flush();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
