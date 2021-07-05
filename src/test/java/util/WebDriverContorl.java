package util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import tests.BaseTest;

public class WebDriverContorl extends BaseTest {
	
	//Function to help initialize web driver according to configurations
	public static void intializeWebdriver() throws Exception {
		String browser = prop.getProperty("browser");
		String headless = prop.getProperty("headless");
		String docker_flag = prop.getProperty("docker");

		// Check if parameter passed is firefox
		if (browser.equalsIgnoreCase("firefox")) {
			if (headless.equalsIgnoreCase("yes")) {
				System.setProperty(prop.getProperty("firefoxKey"), prop.getProperty("firefoxValue"));

				FirefoxBinary firefoxBinary = new FirefoxBinary();
				firefoxBinary.addCommandLineOptions("-headless");

				FirefoxOptions options = new FirefoxOptions();
				options.setBinary(firefoxBinary);

				driver = new FirefoxDriver(options);
				driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
				driver.manage().window().maximize();

			} else if (headless.equalsIgnoreCase("no")) {

				System.setProperty(prop.getProperty("firefoxKey"), prop.getProperty("firefoxValue"));

				if (docker_flag.equalsIgnoreCase("true")) {
					FirefoxOptions options = new FirefoxOptions();
					driver = (new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), options));
				} else if (docker_flag.equalsIgnoreCase("false")) {
					driver = new FirefoxDriver();
				}
				driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
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
				options.addArguments("start-maximized");
				options.addArguments(
						"user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.84 Safari/537.36");
				driver = new ChromeDriver(options);
				driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			} else if (headless.equalsIgnoreCase("no")) {
				System.setProperty(prop.getProperty("chromeKey"), prop.getProperty("chromeValue"));
				if (docker_flag.equalsIgnoreCase("true")) {
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--disable-dev-shm-usage");
					driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), options);
				} else if (docker_flag.equalsIgnoreCase("false")) {
					driver = new ChromeDriver();
				}
				driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			}
		}

		// Check if parameter passed as 'Edge'
		else if (browser.equalsIgnoreCase("edge"))

		{
			System.setProperty(prop.getProperty("edgeKey"), prop.getProperty("edgeValue"));
			driver = new EdgeDriver();
			driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
		} else {
			// If no browser passed throw exception
			throw new Exception("PLEASE CHECK THE BROWSER NAME !");
		}
		logger.info("Browser opened successfully.");
		driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	//Function to help initialize web driver according to configurations (DOCKER)
	public static void initiateDriver(String Port) throws MalformedURLException {
		if (Port.equalsIgnoreCase("9001")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-dev-shm-usage");
			driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), options);
		} else if (Port.equalsIgnoreCase("9002")) {
			FirefoxOptions options = new FirefoxOptions();
			driver = (new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), options));
		}
		driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
}
