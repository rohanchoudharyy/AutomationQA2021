package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pages.HomePage;
import util.ExcelDataFetch;

public class HomePageSearchTest extends BaseTest {

	@Test(groups = { "search" })
	public void homePageSearchTest() throws Exception {
		ExcelDataFetch excel = new ExcelDataFetch();
		String year = excel.getCellData("HomePageSearch", "Year", 2);
		year = year.substring(0, year.length() - 2);
		String day = excel.getCellData("HomePageSearch", "Day", 2);
		day = day.substring(0, day.length() - 2);
		
		extentTest = extent.startTest("Search Test");
		HomePage search = new HomePage(driver);
		search.enterSourceLocation(excel.getCellData("HomePageSearch", "SourceLocation", 2));
		search.enterDestLocation(excel.getCellData("HomePageSearch", "Destination", 2));
		search.calSelect(year, excel.getCellData("HomePageSearch", "Month", 2), day);
		search.clickSearch();
		AssertJUnit.assertEquals(driver.getTitle(), "Delhi to Dehradun Bus Tickets Booking, Save upto 25% - redBus");
	}

	@Test(groups = { "search" })
	public void busTicketPageMenuTest() throws Exception {
		ExcelDataFetch excel = new ExcelDataFetch();
		
		extentTest = extent.startTest("Search Test 2");
		HomePage search = new HomePage(driver);
		search.clickbus();
		search.fromsend(excel.getCellData("HomePageSearch", "sourceLocation2", 2));
		search.tosend(excel.getCellData("HomePageSearch", "Destination2", 2));
		search.datesend(excel.getCellData("HomePageSearch", "Date", 2));
		search.submit();
		//WebDriverWait wait = new WebDriverWait(driver, 15);
		//wait.until(webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete"));
		Thread.sleep(500);
		AssertJUnit.assertEquals(driver.getTitle(), "Search Bus Tickets");
	}

	@Test(groups = { "search" })
	public void modifySearch() throws Exception {
		ExcelDataFetch excel = new ExcelDataFetch();
		extentTest = extent.startTest("modifySearch");
		HomePage search = new HomePage(driver);
		search.clickbus();
		search.fromsend(excel.getCellData("HomePageSearch", "sourceLocation2", 2));
		search.tosend(excel.getCellData("HomePageSearch", "Destination2", 2));
		search.datesend(excel.getCellData("HomePageSearch", "Date", 2));
		search.submit();
		search.modifyClick();
		search.newSourceLocation(excel.getCellData("HomePageSearch", "sourceLocation2", 2));
		search.newDestLocation(excel.getCellData("HomePageSearch", "Destination", 2));
		search.modifySubmit();
		AssertJUnit.assertEquals(driver.getTitle(), "Search Bus Tickets");
	}
}
