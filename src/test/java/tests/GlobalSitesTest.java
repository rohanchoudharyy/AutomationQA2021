package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.GlobalSites;

public class GlobalSitesTest extends BaseTest {

	@Test(groups = { "global" })
	public void SingaporeSite() throws Exception {
		GlobalSites site = new GlobalSites(driver);
		site.clickSingapore();
		new WebDriverWait(driver, 20).until(ExpectedConditions.urlToBe("https://www.redbus.sg/"));
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://www.redbus.sg/");
	}

	@Test(groups = { "global" })
	public void ColombiaSite() throws Exception {
		GlobalSites site = new GlobalSites(driver);
		site.clickColombia();
		new WebDriverWait(driver, 20).until(ExpectedConditions.urlToBe("https://www.redbus.co/"));
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://www.redbus.co/");
	}

}
