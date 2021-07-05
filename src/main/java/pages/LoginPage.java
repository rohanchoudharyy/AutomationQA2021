package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='signin-block']")
	public WebElement signIn;

	@FindBy(how = How.XPATH, using = "//li[@id='signInLink']")
	public WebElement signInLink;

	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div[2]/div/div/div[3]/iframe")
	public WebElement signInGoogle;

	@FindBy(how = How.CLASS_NAME, using = "modalIframe")
	public WebElement frame;

	@FindBy(how = How.XPATH, using = "//*[@id=\"mobileNoInp\"]")
	public WebElement mob;

	public void clickSignIn() throws InterruptedException {
		signIn.click();
		signInLink.click();
	}

	public void validSignIn(String mobile) throws InterruptedException {
		driver.switchTo().frame(frame);
		mob.sendKeys(mobile);
	}

	public void invalidSignIn(String mobile) throws InterruptedException {
		driver.switchTo().frame(frame);
		mob.sendKeys(mobile);
	}

	public String charRemoveAt(String str, int p) {
		return str.substring(0, p) + str.substring(p + 1);
	}
}
