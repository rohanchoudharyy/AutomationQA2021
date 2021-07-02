package tests;

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
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/redBus.in/");
	}
	@Test(groups = { "social" })
	public void twitterCheck() throws Exception {
		HomePage social = new HomePage(driver);
		extentTest = extent.startTest("Facebook icon test");
		social.twitterClick();
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://twitter.com/redBus_in");
	}

}
