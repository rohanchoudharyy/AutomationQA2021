package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.HomePage;
import util.ExcelDataFetch;

public class SocialMediaTest extends BaseTest {
	
	//To check the fb icon in the footer
	@Test(groups = { "social" })
	public void fbCheck() throws Exception {
		HomePage social = new HomePage(driver);
		social.fbClick();
		Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));
	}

	//To test the twitter icon in the footer
	@Test(groups = { "social" })
	public void twitterCheck() throws Exception {
		HomePage social = new HomePage(driver);
		social.twitterClick();
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://twitter.com/redBus_in");
	}

}
