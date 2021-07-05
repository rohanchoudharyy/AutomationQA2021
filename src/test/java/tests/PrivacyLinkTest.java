package tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.CareerPage;
import pages.PrivacyPage;

public class PrivacyLinkTest extends BaseTest {
	
	//Privacy page test
	@Test(groups = { "privacy" })
	public void privacyLink() throws Exception {
		PrivacyPage privacy = new PrivacyPage(driver);
		privacy.clickPrivacy();
		AssertJUnit.assertEquals(privacy.privacyCheck.getText(), "Privacy Policy");
	}

}
