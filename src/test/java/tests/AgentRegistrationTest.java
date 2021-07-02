package tests;

import org.testng.annotations.Test;
import pages.AgentRegistrationPage;
import util.ExcelDataFetch;

public class AgentRegistrationTest extends BaseTest {
	@Test(groups = { "agent" })
	public void InvalidAgentRegistrationTest() throws Exception {
		AgentRegistrationPage agent = new AgentRegistrationPage(driver);
		ExcelDataFetch excel = new ExcelDataFetch();
		String mob = excel.getCellData("AgentRegistration", "mobile", 2);
		mob = mob.substring(0, mob.length() - 2);
		mob = agent.charRemoveAt(mob, 1);
		extentTest = extent.startTest("AgentRegistrationTest Test");
		
		agent.clickAgentReg();

		agent.AgentRegForm(excel.getCellData("AgentRegistration", "name", 2),
				excel.getCellData("AgentRegistration", "email", 2), mob,
				excel.getCellData("AgentRegistration", "password", 2),
				excel.getCellData("AgentRegistration", "confirmPassword", 2),
				excel.getCellData("AgentRegistration", "companyName", 2),
				excel.getCellData("AgentRegistration", "pan", 2));
	}
}
