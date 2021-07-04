package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.HomePage;
import util.ExcelDataFetch;

public class SocialMediaTest extends BaseTest {
	@Test(groups = { "social" })
	public void fbCheck() throws Exception {
		HomePage social = new HomePage(driver);
		extentTest = extent.startTest("Facebook icon test");
		social.fbClick();
		//WebDriverWait wait = new WebDriverWait(driver, 15);
		//wait.until(webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete"));
		Thread.sleep(500);
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/redBus.in/");
	}
	@Test(groups = { "social" })
	public void twitterCheck() throws Exception {
		HomePage social = new HomePage(driver);
		extentTest = extent.startTest("twitter icon test");
		social.twitterClick();
		//WebDriverWait wait = new WebDriverWait(driver, 15);
		//wait.until(webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete"));
		Thread.sleep(500);
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://twitter.com/redBus_in");
	}

}
