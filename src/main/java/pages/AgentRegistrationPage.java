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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgentRegistrationPage {
	WebDriver driver;

	public AgentRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='fullName']")
	public WebElement nameField;
	
	@FindBy(how = How.XPATH, using = "//input[@name='email']")
	public WebElement emailField;
	
	@FindBy(how = How.XPATH, using = "//input[@name='mobile']")
	public WebElement mobileField;
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Password']")
	public WebElement password;
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Confirm Password']")
	public WebElement confirmPass;
	
	@FindBy(how = How.XPATH, using = "//input[@name='companyName']")
	public WebElement companyName;
	
	@FindBy(how = How.XPATH, using = "//input[@name='panNumber']")
	public WebElement panNumber;
	
	@FindBy(how = How.XPATH, using = "//input[@name='agent' and @value=\"Yes\"]")
	public WebElement radioYes;
	
	@FindBy(how = How.XPATH, using = "//button[@class='sign_up']")
	public WebElement signUp;

	public void clickAgentReg() throws InterruptedException {
		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		// Wait until element is clickable
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement singapore = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Agent Registration')]")));
		singapore.click();
		
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

	public void AgentRegForm(String name, String email, String mob, String pass, String confPass, String company,
			String pan) throws InterruptedException {
		nameField.sendKeys(name);
		emailField.sendKeys(email);
		mobileField.sendKeys(mob);
		password.sendKeys(pass);
		confirmPass.sendKeys(confPass);
		companyName.sendKeys(company);
		panNumber.sendKeys(pan);
		radioYes.click();
		signUp.click();
	}
}
