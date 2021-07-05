package tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.FAQPage;

public class FAQTest extends BaseTest {
	
	//Test the FAQ page
	@Test(groups = { "faq" })
	public void FaqPage() throws Exception {
		FAQPage faq = new FAQPage(driver);
		faq.clickFAQ();
		faq.general();
		AssertJUnit.assertEquals(faq.assertGeneral.getText(), "Frequently Asked Questions");
		faq.general();
	}
}
