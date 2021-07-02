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

public class FAQPage {
	WebDriver driver;

	public FAQPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'GENERAL')]")
	public WebElement general;
	
	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Frequently Asked Questions')]")
	public WebElement assertGeneral;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'GENERAL')]")
	public WebElement FAQ;
	
	public void clickFAQ() throws InterruptedException {
		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		// Wait until element is clickable
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement FAQ = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'FAQ')]")));
		FAQ.click();
		// changing tabs
		String currentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String actual : handles) {
			if (!actual.equalsIgnoreCase(currentHandle)) {
				// Switch to the opened tab
				driver.switchTo().window(actual);
			}
		}
	}
	
	public void general() {
		general.click();
	}
}
