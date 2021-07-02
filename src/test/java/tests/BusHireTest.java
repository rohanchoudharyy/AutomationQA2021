package tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.BusHirePage;
import pages.CareerPage;

public class BusHireTest extends BaseTest {
	@Test(groups = { "busHire" })
	public void busHire() throws Exception {
		extentTest = extent.startTest("busHire Test");
		BusHirePage bus = new BusHirePage(driver);
		bus.busHire();
		bus.outstation();
		Thread.sleep(500);
		//AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://showcase.hirist.com/v2/rscp-redbusin-1213.html");
	}

}
