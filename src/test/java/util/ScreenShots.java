package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import tests.BaseTest;

public class ScreenShots extends BaseTest{

	//To return screenshot path
	public static String takeScreenShot(WebDriver driver, String testCaseName) {
		String screenshotFileName = prop.getProperty("screenshotDir") + testCaseName + "TestFailed.jpg";

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(screenshotFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotFileName;
	}
}
