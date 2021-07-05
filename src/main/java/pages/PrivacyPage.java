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

public class PrivacyPage {
	WebDriver driver;

	public PrivacyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Privacy Policy')]")
	public WebElement privacyCheck;

	public void clickPrivacy() throws InterruptedException {
		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		// Wait until element is clickable
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement colombia = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Privacy Policy')]")));
		colombia.click();
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
}
