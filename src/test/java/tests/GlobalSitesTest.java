package tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.GlobalSites;
import pages.HomePage;
import util.ExcelDataFetch;

public class GlobalSitesTest extends BaseTest {

	@Test(groups = { "global" })
	public void SingaporeSiteTest() throws Exception {
		extentTest = extent.startTest("Singapore Global Site Test");
		GlobalSites site = new GlobalSites(driver);
		site.clickSingapore();
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://www.redbus.sg/");
	}

	@Test(groups = { "global" })
	public void ColombiaSiteTest() throws Exception {
		extentTest = extent.startTest("Colombia Global Site Test");
		GlobalSites site = new GlobalSites(driver);
		site.clickColombia();
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://www.redbus.co/");
	}

}
