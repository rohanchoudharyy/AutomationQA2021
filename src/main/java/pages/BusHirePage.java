package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BusHirePage {
	WebDriver driver;

	public BusHirePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[@id='redBus Bus Hire']")
	public WebElement busHire;
	@FindBy(how = How.XPATH, using = "//body/div[@id='app']/div[1]")
	public WebElement frame;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Outstation')]")
	public WebElement outstation;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Hire a Vehicle')]")
	public WebElement text;
	

	public void busHire() {
		busHire.click();
	}

	public void outstation() {
		driver.switchTo().frame(frame);
		System.out.print("asdfasdfasdf" + text.getText());
		outstation.click();
	}
}
