package tests;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pages.CareerPage;


public class CareerPageTest extends BaseTest {

	@Test(groups = { "career" })
	public void careerHiristLink() throws Exception {
		extentTest = extent.startTest("Career hirist Test");
		CareerPage career = new CareerPage(driver);
		career.careerClick();
		career.getOnboard();
		career.techRole();
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://showcase.hirist.com/v2/rscp-redbusin-1213.html");
	}

	@Test(groups = { "career" })
	public void careerLinkedIn() throws Exception {
		extentTest = extent.startTest("Career linkedin Test");
		CareerPage career = new CareerPage(driver);
		career.careerClick();
		career.getOnboard();
		career.linkedIn();
		Assert.assertTrue(driver.getCurrentUrl().contains("linkedin"));
	}

}
