package tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.GlobalSites;

public class ContactUsTest extends BaseTest{
	
	//To test the Contact us page functionality
	@Test(groups = { "contact" })
	public void ContactUsPhone() throws Exception {
		ContactUsPage contact = new ContactUsPage(driver);
		contact.contactUsPageCheck();
		AssertJUnit.assertEquals(contact.phone.getText(), "Ph: +919945600000");
	}
	
	//To test the Support page functionality within the contact page
	@Test(groups = { "contact" })
	public void ContactUsSupport() throws Exception {
		ContactUsPage contact = new ContactUsPage(driver);
		contact.contactUsPageCheck();
		contact.support();
	}

}
