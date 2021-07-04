package tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.FAQPage;
import pages.RPoolPage;

public class RPoolAppDownloadTest extends BaseTest{
	@Test(groups = { "rPool" })
	public void androidAppLink() throws Exception {
		RPoolPage pool = new RPoolPage(driver);
		pool.rPoolClick();
		pool.android();
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://play.google.com/store/apps/details?id=in.redbus.android&amp;hl=en");
	}
	@Test(groups = { "rPool" })
	public void iosAppLink() throws Exception {
		RPoolPage pool = new RPoolPage(driver);
		pool.rPoolClick();
		pool.ios();
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://apps.apple.com/in/app/redbus/id733712604");
	}
}
