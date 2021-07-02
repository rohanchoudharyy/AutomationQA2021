package pages;

import java.text.ParseException;
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

import helper.Calender;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='src']")
	public WebElement from;

	@FindBy(how = How.XPATH, using = "//li[@class=\"selected\"]")
	public WebElement formSuggestion;

	@FindBy(how = How.XPATH, using = "//input[@id='dest']")
	public WebElement dest;

	@FindBy(how = How.XPATH, using = "//input[@id='onward_cal']")
	public WebElement datePicker;

	@FindBy(how = How.XPATH, using = "//button[@id='search_btn']")
	public WebElement search;

	public void enterSourceLocation(String sourceLocation) throws InterruptedException {
		from.sendKeys(sourceLocation);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement formSuggestion = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class=\"selected\"]")));
		formSuggestion.click();
	}

	public void enterDestLocation(String destLocation) throws InterruptedException {
		dest.sendKeys(destLocation);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement formSuggestion = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class=\"selected\"]")));
		formSuggestion.click();
	}

	public void calSelect(String year, String month, String day) throws ParseException {
		Calender.selectDate(datePicker, year, month, day, driver);
	}

	public void clickSearch() throws InterruptedException {
		search.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(500);
	}

	@FindBy(how = How.XPATH, using = "//a[@id='redBus']")
	public WebElement busTicketsButton;

	@FindBy(how = How.XPATH, using = "//input[@id='txtSource']")
	public WebElement fromTextbox;

	@FindBy(how = How.XPATH, using = "//li[@class=\"C120_slist-item C120_suggestion-active\"]")
	public WebElement commonSuggestions;

	@FindBy(how = How.XPATH, using = "//input[@id='txtDestination']")
	public WebElement toTextbox;

	@FindBy(how = How.XPATH, using = "//input[@id='txtOnwardCalendar']")
	public WebElement dateSend;

	@FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[3]/button[1]")
	public WebElement submit;

	public void clickbus() throws InterruptedException {
		busTicketsButton.click();
	}

	public void fromsend(String sourceLocation2) throws InterruptedException {
		fromTextbox.sendKeys(sourceLocation2);
		Thread.sleep(500);
		commonSuggestions.click();
	}

	public void tosend(String dest2) throws InterruptedException {
		toTextbox.sendKeys(dest2);
		Thread.sleep(500);
		commonSuggestions.click();
	}

	public void datesend(String date) throws InterruptedException {
		dateSend.sendKeys(date);
	}

	public void submit() throws InterruptedException {
		submit.click();
		Thread.sleep(500);
	}

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Modify')]")
	public WebElement modifyButton;

	@FindBy(how = How.XPATH, using = "//*[text()='SEARCH']")
	public WebElement submit2;

	@FindBy(how = How.XPATH, using = "//body/section[@id='rh_main']/div[@id='mBWrapper']/div[@id='root']/div[1]/div[1]/section[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[1]/img[1]")
	public WebElement nextMonth;

	@FindBy(how = How.XPATH, using = "//body[1]/section[1]/div[2]/div[1]/div[1]/div[1]/section[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[2]/li[19]/span[1]")
	public WebElement dateSelect;

	@FindBy(how = How.XPATH, using = "//input[@id='src']")
	public WebElement newFrom;

	@FindBy(how = How.XPATH, using = "//li[@class=\"selected\"]")
	public WebElement newFormSuggestion;

	@FindBy(how = How.XPATH, using = "//input[@id='dest']")
	public WebElement newDest;

	public void modifyClick() throws InterruptedException {
		modifyButton.click();
	}

	public void newSourceLocation(String source) throws InterruptedException {
		newFrom.clear();
		newFrom.sendKeys(source);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		newFormSuggestion.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void newDestLocation(String dest) throws InterruptedException {
		newDest.clear();
		newDest.sendKeys(dest);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		formSuggestion.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void calender() throws InterruptedException {
		nextMonth.click();
		dateSelect.click();
	}

	public void modifySubmit() throws InterruptedException {
		submit2.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='smsTXTBOX']")
	public WebElement mobAppLink;
	@FindBy(how = How.XPATH, using = "//input[@id='sendLinkButton']")
	public WebElement mobAppLinkSend;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Invalid Mobile No')]")
	public WebElement errorInvalidMob;
	@FindBy(how = How.XPATH, using = "//div[@id='failure']")
	public WebElement validMobMsg;

	public void sendAppLink(String mob) {
		mobAppLink.sendKeys(mob);
		mobAppLinkSend.click();
	}

	public String charRemoveAt(String str, int p) {
		return str.substring(0, p) + str.substring(p + 1);
	}

	public void fbClick() {
		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		// Wait until element is clickable
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement fb = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='fbicon icon-Facebook']")));
		fb.click();
		String currentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String actual : handles) {
			if (!actual.equalsIgnoreCase(currentHandle)) {
				// Switch to the opened tab
				driver.switchTo().window(actual);
			}
		}
	}

	public void twitterClick() {
		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		// Wait until element is clickable
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement twitter = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='twittericon icon-Twitter']")));
		twitter.click();
		String currentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String actual : handles) {
			if (!actual.equalsIgnoreCase(currentHandle)) {
				// Switch to the opened tab
				driver.switchTo().window(actual);
			}
		}
	}
}
