package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import util.ExcelDataFetch;

public class LoginTest extends BaseTest {
	@Test(groups = { "login" })
	public void ValidLogin() throws Exception {
		// Fetching and altering data from excel
		ExcelDataFetch excel = new ExcelDataFetch();
		HomePage mobLink = new HomePage(driver);
		String mob = excel.getCellData("MobileAppLinkmobile", "mobileValid", 2);
		mob = mob.substring(0, mob.length() - 2);
		mob = mobLink.charRemoveAt(mob, 1);

		LoginPage login = new LoginPage(driver);
		login.clickSignIn();
		login.validSignIn(mob);
	}

	@Test(groups = { "login" })
	public void InvalidLogin() throws Exception {
		// Fetching and altering data from excel
		ExcelDataFetch excel = new ExcelDataFetch();
		String mob = excel.getCellData("MobileAppLinkmobile", "mobileInvalid", 2);
		mob = mob.substring(0, mob.length() - 2);

		LoginPage login = new LoginPage(driver);
		login.clickSignIn();
		login.validSignIn(mob);
	}

}
