package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import util.ExcelDataFetch;
import util.ScreenShots;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BaseTest {
	
	static WebDriver driver;

	// making logger object to use in all classes to log information about the tests.
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

	@BeforeSuite(groups = { "base","pre" })
	public void setExtent() {
		extent = new ExtentReports(prop.getProperty("report_file"));
	}

	@AfterSuite(groups = { "base","pre" })
	public void endReport() {
		extent.flush();
		extent.close();
	}

	// function to capture screenshot and error description when any test fails
	@AfterMethod(groups = { "base" ,"pre"})
	public void attachScreenShot(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = ScreenShots.takeScreenShot(driver, result.getName());
			screenshotPath=screenshotPath.substring(1);
			System.out.print(screenshotPath);
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
			extentTest.log(LogStatus.FAIL, "ERROR DESCRIPTION : " + result.getThrowable());	
			
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test case passed successfully");
		}
		extent.endTest(extentTest);
	}

	// Function to log test results
	@AfterMethod(groups = { "base","pre" })
	public void Logger(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.info(result.getName() + " TEST CASE FAILED.");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.info(result.getName() + " TEST CASE EXECUTED SUCCESSFULLY.");
		}
	}

	// function to initialize web driver, choose browser and headless mode
	@BeforeMethod(groups = { "base","pre" })
	public static void intializeWebdriver() throws Exception {
		String browser = prop.getProperty("browser");
		String headless = prop.getProperty("headless");

		// Check if parameter passed is firefox
		if (browser.equalsIgnoreCase("firefox")) {
			if (headless.equalsIgnoreCase("yes")) {
				System.setProperty(prop.getProperty("firefoxKey"), prop.getProperty("firefoxValue"));

				FirefoxBinary firefoxBinary = new FirefoxBinary();
				firefoxBinary.addCommandLineOptions("-headless");

				FirefoxOptions options = new FirefoxOptions();
				options.setBinary(firefoxBinary);

				driver = new FirefoxDriver(options);
				driver.manage().timeouts().pageLoadTimeout(timeout,TimeUnit.SECONDS);
				driver.manage().window().maximize();

			} else if (headless.equalsIgnoreCase("no")) {

				System.setProperty(prop.getProperty("firefoxKey"), prop.getProperty("firefoxValue"));
				driver = new FirefoxDriver();
				driver.manage().timeouts().pageLoadTimeout(timeout,TimeUnit.SECONDS);
				driver.manage().window().maximize();
			}
		}

		// Check if parameter passed as 'chrome'
		else if (browser.equalsIgnoreCase("chrome")) {
			if (headless.equalsIgnoreCase("yes")) {
				System.setProperty(prop.getProperty("chromeKey"), prop.getProperty("chromeValue"));
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				options.addArguments("--disable-notifications");
				options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.84 Safari/537.36");
				driver = new ChromeDriver(options);
				driver.manage().timeouts().pageLoadTimeout(timeout,TimeUnit.SECONDS);
				driver.manage().window().maximize();
			} else if (headless.equalsIgnoreCase("no")) {
				System.setProperty(prop.getProperty("chromeKey"), prop.getProperty("chromeValue"));
				//ChromeOptions options = new ChromeOptions();
				//options.addArguments("--disable-dev-shm-usage");
				//driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), options);
				driver = new ChromeDriver();
				driver.manage().timeouts().pageLoadTimeout(timeout,TimeUnit.SECONDS);
				driver.manage().window().maximize();
			}
		}
		// Check if parameter passed as 'Edge'
		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty(prop.getProperty("edgeKey"), prop.getProperty("edgeValue"));
			driver = new EdgeDriver();
			driver.manage().timeouts().pageLoadTimeout(timeout,TimeUnit.SECONDS);
		} else {
			// If no browser passed throw exception
			throw new Exception("PLEASE CHECK THE BROWSER NAME !");
		}
		logger.info("Browser opened successfully.");
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	// function to open browser
	@BeforeMethod(groups = { "base","pre" })
	public static void openBrowser() {
		driver.get(prop.getProperty("url"));
		//driver.manage().window().maximize();
		logger.info("URL opened successfully.");
	}

	// function to close browser
	@AfterMethod(groups = { "base" ,"pre"})
	public static void closeBrowser() {
		//driver.close();
		driver.quit();
		logger.info("Browser closed successfully.");
	}

	}