package tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.CareerPage;
import pages.PrivacyPage;

public class PrivacyLinkTest extends BaseTest {
	@Test(groups = { "privacy" })
	public void privacyLinkTest() throws Exception {
		extentTest = extent.startTest("privacy Test");
		PrivacyPage privacy = new PrivacyPage(driver);
		privacy.clickPrivacy();
		AssertJUnit.assertEquals(privacy.privacyCheck.getText(), "Privacy Policy");
	}

}
