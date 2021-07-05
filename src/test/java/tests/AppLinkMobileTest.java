package tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.AgentRegistrationPage;
import pages.HomePage;
import util.ExcelDataFetch;

public class AppLinkMobileTest extends BaseTest {
	
	//To test the sending app link to mobile feature
	@Test(groups = { "mobLink" })
	public void InvalidMobileAppLink() throws Exception {
		//Fetching and altering data from excel
		ExcelDataFetch excel = new ExcelDataFetch();
		String mob = excel.getCellData("MobileAppLinkmobile", "mobileInvalid", 2);
		mob = mob.substring(0, mob.length() - 2);
		
		HomePage mobLink = new HomePage(driver);
		mobLink.sendAppLink(mob);
		AssertJUnit.assertEquals(mobLink.errorInvalidMob.getText(), "Invalid Mobile No");
	}
	
	//To test the sending app link to mobile feature
	@Test(groups = { "mobLink" })
	public void ValidMobileAppLink() throws Exception {
		//Fetching and altering data from excel
		ExcelDataFetch excel = new ExcelDataFetch();
		HomePage mobLink = new HomePage(driver);
		String mob = excel.getCellData("MobileAppLinkmobile", "mobileValid", 2);
		mob = mob.substring(0, mob.length() - 2);
		mob = mobLink.charRemoveAt(mob, 1);
		
		mobLink.sendAppLink(mob);
		//AssertJUnit.assertEquals(mobLink.validMobMsg.getText(), "Sorry ! please try again. We are facing issues in sending SMS");
	}
}
