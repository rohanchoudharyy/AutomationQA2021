package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pages.CareerPage;


public class CareerPageTest extends BaseTest {

	//To test the career page fields (Hirist)
	@Test(groups = { "career" })
	public void careerHiristLink() throws Exception {
		CareerPage career = new CareerPage(driver);
		career.careerClick();
		career.getOnboard();
		career.techRole();
		new WebDriverWait(driver, 20).until(ExpectedConditions.urlToBe("https://showcase.hirist.com/v2/rscp-redbusin-1213.html"));
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://showcase.hirist.com/v2/rscp-redbusin-1213.html");
	}

	//To test the career page fields (LinkedIn)
	@Test(groups = { "career" })
	public void careerLinkedIn() throws Exception {
		CareerPage career = new CareerPage(driver);
		career.careerClick();
		career.getOnboard();
		career.linkedIn();
		new WebDriverWait(driver, 20).until(ExpectedConditions.urlToBe("https://www.linkedin.com/company/redbus_2/"));
		Assert.assertTrue(driver.getCurrentUrl().contains("linkedin"));
	}

}
