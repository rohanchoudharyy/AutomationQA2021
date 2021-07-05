package pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OperatorPage {
	WebDriver driver;

	public OperatorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'All Operators >')]")
	public WebElement allOp;

	@FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[1]/article[2]/div[1]/ul[1]/li[1]/a[1]")
	public WebElement abSuper;

	@FindBy(how = How.XPATH, using = "//input[@id='txtSource']")
	public WebElement from;
	@FindBy(how = How.XPATH, using = "//input[@id='txtDestination']")
	public WebElement to;
	@FindBy(how = How.XPATH, using = "//input[@id='txtOnwardCalendar']")
	public WebElement date;
	@FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[1]/div[1]/div[3]/button[1]")
	public WebElement searchBus;
	@FindBy(how = How.XPATH, using = "//li[@class=\"C120_slist-item C120_suggestion-active\"]")
	public WebElement suggestion;

	public void SpecificOperatorBooking() throws InterruptedException {
		allOp.click();
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

	public void abSuper(String fromE, String toE, String dateE) throws InterruptedException {
		abSuper.click();
		from.sendKeys(fromE);
		Thread.sleep(500);
		suggestion.click();

		to.sendKeys(toE);
		Thread.sleep(500);
		suggestion.click();

		date.sendKeys(dateE);
		searchBus.click();
	}

	@FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[1]/article[1]/div[2]/ul[1]/li[19]/a[1]")
	public WebElement S;
	@FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[1]/article[2]/div[1]/ul[1]/li[1]/a[1]")
	public WebElement SBT;

	public void RBTravels(String fromE, String toE, String dateE) throws InterruptedException {
		S.click();
		SBT.click();

		from.sendKeys(fromE);
		Thread.sleep(500);
		suggestion.click();

		to.sendKeys(toE);
		Thread.sleep(500);
		suggestion.click();

		date.sendKeys(dateE);
		searchBus.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("Bus"));
	}

}
