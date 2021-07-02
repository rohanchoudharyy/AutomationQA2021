package tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.CareerPage;
import pages.ManageBookingMenu;
import util.ExcelDataFetch;

public class ManageBookingTest extends BaseTest {

	@Test(groups = { "manage_booking" })
	public void InvalidchangeTravelDate() throws Exception {
		ExcelDataFetch excel = new ExcelDataFetch();
		extentTest = extent.startTest("manage_booking Test");
		ManageBookingMenu manage = new ManageBookingMenu(driver);
		manage.changeTravelDate();
		manage.fillDetails(excel.getCellData("ManageBooking", "ticket", 2),
				excel.getCellData("ManageBooking", "email", 2));
	}

	@Test(groups = { "manage_booking" })
	public void InvalidShowMyTicket() throws Exception {
		ExcelDataFetch excel = new ExcelDataFetch();
		extentTest = extent.startTest("ShowMyTicket Test");
		ManageBookingMenu manage = new ManageBookingMenu(driver);
		manage.showMyTicket();
		manage.fillDetails2(excel.getCellData("ManageBooking", "ticket", 2),
				excel.getCellData("ManageBooking", "email", 2));
	}
	@Test(groups = { "manage_booking" })
	public void InvalidEmailSms() throws Exception {
		ExcelDataFetch excel = new ExcelDataFetch();
		extentTest = extent.startTest("ShowMyTicket Test");
		ManageBookingMenu manage = new ManageBookingMenu(driver);
		manage.emailSms();
		manage.fillDetails2(excel.getCellData("ManageBooking", "ticket", 2),
				excel.getCellData("ManageBooking", "email", 2));
	}
	@Test(groups = { "manage_booking" })
	public void InvalidCancelTicket() throws Exception {
		extentTest = extent.startTest("cancelTicket Test");
		ManageBookingMenu manage = new ManageBookingMenu(driver);
		manage.cancel();
		AssertJUnit.assertEquals(manage.err.getText(), "Cancel your Ticket");
	}
}
