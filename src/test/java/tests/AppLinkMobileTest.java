package tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.AgentRegistrationPage;
import pages.HomePage;
import util.ExcelDataFetch;

public class AppLinkMobileTest extends BaseTest {
	@Test(groups = { "mobLink" })
	public void InvalidMobileAppLink() throws Exception {
		//Fetching and altering data from excel
		ExcelDataFetch excel = new ExcelDataFetch();
		String mob = excel.getCellData("MobileAppLinkmobile", "mobileInvalid", 2);
		mob = mob.substring(0, mob.length() - 2);
		
		extentTest = extent.startTest("Invalid Mobile app link Test");
		HomePage mobLink = new HomePage(driver);
		mobLink.sendAppLink(mob);
		AssertJUnit.assertEquals(mobLink.errorInvalidMob.getText(), "Invalid Mobile No");
	}

	@Test(groups = { "mobLink" })
	public void ValidMobileAppLink() throws Exception {
		//Fetching and altering data from excel
		ExcelDataFetch excel = new ExcelDataFetch();
		HomePage mobLink = new HomePage(driver);
		String mob = excel.getCellData("MobileAppLinkmobile", "mobileValid", 2);
		mob = mob.substring(0, mob.length() - 2);
		mob = mobLink.charRemoveAt(mob, 1);
		
		extentTest = extent.startTest("Valid Mobile app link Test");
		mobLink.sendAppLink(mob);
		AssertJUnit.assertEquals(mobLink.validMobMsg.getText(), "");
	}
}