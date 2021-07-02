package tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.FAQPage;

public class FAQTest extends BaseTest {
	@Test(groups = { "faq" })
	public void FaqPageTest() throws Exception {
		extentTest = extent.startTest("ContactUS Test");
		FAQPage faq = new FAQPage(driver);
		faq.clickFAQ();
		faq.general();
		AssertJUnit.assertEquals(faq.assertGeneral.getText(), "Frequently Asked Questions");
		faq.general();
	}
}
