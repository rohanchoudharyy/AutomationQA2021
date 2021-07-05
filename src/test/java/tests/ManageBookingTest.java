package tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.CareerPage;
import pages.ManageBookingMenu;
import util.ExcelDataFetch;

public class ManageBookingTest extends BaseTest {

	//To test the Change travel date feature from Manage booking option in main menu
	@Test(groups = { "manage_booking" })
	public void InvalidchangeTravelDate() throws Exception {
		ExcelDataFetch excel = new ExcelDataFetch();
		ManageBookingMenu manage = new ManageBookingMenu(driver);
		manage.changeTravelDate();
		manage.fillDetails(excel.getCellData("ManageBooking", "ticket", 2),
				excel.getCellData("ManageBooking", "email", 2));
	}

	//To test the Show my ticket feature from Manage booking option in main menu
	@Test(groups = { "manage_booking" })
	public void InvalidShowMyTicket() throws Exception {
		ExcelDataFetch excel = new ExcelDataFetch();
		ManageBookingMenu manage = new ManageBookingMenu(driver);
		manage.showMyTicket();
		manage.fillDetails2(excel.getCellData("ManageBooking", "ticket", 2),
				excel.getCellData("ManageBooking", "email", 2));
	}
	
	//To test the Email/SMS feature from Manage booking option in main menu
	@Test(groups = { "manage_booking" })
	public void InvalidEmailSms() throws Exception {
		ExcelDataFetch excel = new ExcelDataFetch();
		ManageBookingMenu manage = new ManageBookingMenu(driver);
		manage.emailSms();
		manage.fillDetails2(excel.getCellData("ManageBooking", "ticket", 2),
				excel.getCellData("ManageBooking", "email", 2));
	}
	
	//To test the Cancel ticket feature from Manage booking option in main menu
	@Test(groups = { "manage_booking" })
	public void InvalidCancelTicket() throws Exception {
		ManageBookingMenu manage = new ManageBookingMenu(driver);
		manage.cancel();
		AssertJUnit.assertEquals(manage.err.getText(), "Cancel your Ticket");
	}
}
