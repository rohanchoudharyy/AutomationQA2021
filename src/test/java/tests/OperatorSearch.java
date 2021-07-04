package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.OperatorPage;
import util.ExcelDataFetch;

public class OperatorSearch extends BaseTest {
	@Test(groups = { "search" })
	public void OperatorSearchBus() throws Exception {
		ExcelDataFetch excel = new ExcelDataFetch();
		extentTest = extent.startTest("OperatorSearchBus Test");
		OperatorPage op = new OperatorPage(driver);
		op.SpecificOperatorBooking();
		op.abSuper(excel.getCellData("Operator", "From", 2), excel.getCellData("Operator", "To", 2),
				excel.getCellData("Operator", "Date", 2));
		AssertJUnit.assertEquals(driver.getTitle(), "Search Bus Tickets");
	}
	
	@Test(groups = { "search" })
	public void OperatorSearchBusDifferentName() throws Exception {
		ExcelDataFetch excel = new ExcelDataFetch();
		extentTest = extent.startTest("OperatorSearchBus Test");
		OperatorPage op = new OperatorPage(driver);
		op.SpecificOperatorBooking();
		op.RBTravels(excel.getCellData("Operator", "From", 2), excel.getCellData("Operator", "To", 2),
				excel.getCellData("Operator", "Date", 2));
		Thread.sleep(1000);		
		AssertJUnit.assertEquals(driver.getTitle(), "Search Bus Tickets");
	}
}
