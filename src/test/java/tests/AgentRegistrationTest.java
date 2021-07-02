package tests;

import java.util.concurrent.TimeUnit;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.AgentRegistrationPage;
import util.ExcelDataFetch;

public class AgentRegistrationTest extends BaseTest {
	@Test(groups = { "agent" })
	public void InvalidAgentRegistrationTest() throws Exception {
		ExcelDataFetch excel = new ExcelDataFetch();
		extentTest = extent.startTest("AgentRegistrationTest Test");
		AgentRegistrationPage agent = new AgentRegistrationPage(driver);
		agent.clickAgentReg();

		agent.AgentRegForm(excel.getCellData("AgentRegistration", "name", 2),
				excel.getCellData("AgentRegistration", "email", 2), excel.getCellData("AgentRegistration", "mobile", 2),
				excel.getCellData("AgentRegistration", "password", 2),
				excel.getCellData("AgentRegistration", "confirmPassword", 2),
				excel.getCellData("AgentRegistration", "companyName", 2),
				excel.getCellData("AgentRegistration", "pan", 2));
	}
}
