package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import util.ScreenShots;
import util.WebDriverContorl;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BaseTest {

	public static WebDriver driver;

	// making logger object to use in all classes to log information about the
	// tests.
	public static Logger logger = Logger.getLogger(BaseTest.class.getName());

	// objects for generating reports
	public static ExtentReports extent; // set path where report would be generated
	public static ExtentTest extentTest;

	// Reading the config.properties and log4j.properties file
	static File file = new File(".\\Resources\\config.properties");
	static FileInputStream fis = null;

	public static String LOG_FILE = ".\\Resources\\log4j.properties";
	static FileInputStream logfile = null;

	public static Properties prop = new Properties();

	static {
		try {
			fis = new FileInputStream(file);
			logfile = new FileInputStream(LOG_FILE);
			PropertyConfigurator.configure(logfile);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fis);
			prop.load(logfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int timeout = Integer.parseInt(prop.getProperty("timeout"));

	@BeforeSuite(groups = { "base", "pre" })
	public void setExtent() {
		extent = new ExtentReports(prop.getProperty("report_file"));
	}

	@AfterSuite(groups = { "base", "pre" })
	public void endReport() {
		extent.flush();
		// extent.close();
	}

	// function to capture screenshot and error description when any test fails
	@AfterMethod(groups = { "base", "pre" })
	public void attachScreenShot(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = ScreenShots.takeScreenShot(driver, result.getName());
			screenshotPath = screenshotPath.substring(1);
			System.out.print(screenshotPath);
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
			extentTest.log(LogStatus.FAIL, "ERROR DESCRIPTION : " + result.getThrowable());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test case passed successfully");
		}
		extent.endTest(extentTest);
	}

	// Function to log test results
	@AfterMethod(groups = { "base", "pre" })
	public void Logger(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.info(result.getName() + " TEST CASE FAILED.");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.info(result.getName() + " TEST CASE EXECUTED SUCCESSFULLY.");
		}
	}

	// function to initialize web driver, choose browser and headless mode
	@BeforeMethod(groups = { "base", "pre" })
	public static void initWebDriver() throws Exception {
		WebDriverContorl.intializeWebdriver();
	}

	// function to open browser
	@BeforeMethod(groups = { "base", "pre" })
	public static void openBrowser() {
		driver.get(prop.getProperty("url"));
		logger.info("URL opened successfully.");
	}

	// function to close browser
	@AfterMethod(groups = { "base", "pre" })
	public static void closeBrowser() {
		// driver.close();
		driver.quit();
		logger.info("Browser closed successfully.");
	}
	
	//Method to start extent report before each Test and give it the same name as the method name.
	@BeforeMethod
	public void startTest(Method method) 
	{
		extentTest=extent.startTest(method.getName()+" TEST");
	}

}