package tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.GlobalSites;

public class ContactUsTest extends BaseTest{
	
	@Test(groups = { "contact" })
	public void ContactUsPhone() throws Exception {
		ContactUsPage contact = new ContactUsPage(driver);
		contact.contactUsPageCheck();
		AssertJUnit.assertEquals(contact.phone.getText(), "Ph: +919945600000");
	}
	
	@Test(groups = { "contact" })
	public void ContactUsSupport() throws Exception {
		ContactUsPage contact = new ContactUsPage(driver);
		contact.contactUsPageCheck();
		contact.support();
	}

}
