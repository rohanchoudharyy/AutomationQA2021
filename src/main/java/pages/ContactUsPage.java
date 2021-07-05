package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {
	WebDriver driver;

	public ContactUsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//body[1]/section[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[1]/div[3]/ul[1]/li[2]")
	public WebElement phone;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Click Here')]")
	public WebElement query;

	@FindBy(how = How.XPATH, using = "//body/div[2]/div[1]/div[2]/div[1]/div[1]")
	public WebElement frame;

	@FindBy(how = How.XPATH, using = "//body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")
	public WebElement closeFrame;

	@FindBy(how = How.XPATH, using = "//body/section[@id='rh_main']/div[@id='mBWrapper']/div[@id='content']/div[1]/div[1]/iframe[1]")
	public WebElement covidHelp;

	public void contactUsPageCheck() throws InterruptedException {
		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// Wait until element is clickable
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement contactUs = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Contact Us')]")));
		contactUs.click();

		// Switch Tabs
		String currentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String actual : handles) {
			if (!actual.equalsIgnoreCase(currentHandle)) {
				// Switch to the opened tab
				driver.switchTo().window(actual);
			}
		}
	}

	public void support() throws InterruptedException {
		query.click();

		// Switch Tabs
		String currentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String actual : handles) {
			if (!actual.equalsIgnoreCase(currentHandle)) {
				// Switch to the opened tab
				driver.switchTo().window(actual);
			}
		}
		closeFrame.click();
		covidHelp.click();
	}

}
