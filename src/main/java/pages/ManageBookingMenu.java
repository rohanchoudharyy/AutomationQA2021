package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ManageBookingMenu {
	WebDriver driver;

	public ManageBookingMenu(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Manage Booking')]")
	public WebElement manageBooking;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Change Travel Date')]")
	public WebElement changeTravelDate;

	@FindBy(how = How.XPATH, using = "//input[@id='searchTicket']")
	public WebElement ticketNo;

	@FindBy(how = How.XPATH, using = "//input[@id='searchEmail']")
	public WebElement email;

	@FindBy(how = How.XPATH, using = "//input[@id='ticketSearch']")
	public WebElement submit;

	public void changeTravelDate() {
		manageBooking.click();
		changeTravelDate.click();
	}

	public void fillDetails(String ticket, String mail) {
		ticketNo.sendKeys(ticket);
		email.sendKeys(mail);
		submit.click();
	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Show My Ticket')]")
	public WebElement ShowMyTicket;

	@FindBy(how = How.XPATH, using = "//input[@id='searchTicketTIN']")
	public WebElement ticketnumber;

	@FindBy(how = How.XPATH, using = "//input[@id='searchTicketEmail']")
	public WebElement mail;

	@FindBy(how = How.XPATH, using = "//input[@id='ticketSearch']")
	public WebElement submit2;

	public void showMyTicket() {
		manageBooking.click();
		ShowMyTicket.click();
	}

	public void fillDetails2(String ticket, String email) {
		ticketnumber.sendKeys(ticket);
		mail.sendKeys(email);
		submit.click();
	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Email/SMS')]")
	public WebElement emailSms;

	public void emailSms() {
		manageBooking.click();
		emailSms.click();
	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Cancel')]")
	public WebElement cancelTicket;
	@FindBy(how = How.CLASS_NAME, using = "//input[@name='tin']")
	public WebElement ticketNumber;
	@FindBy(how = How.XPATH, using = "//body/section[@id='rh_main']/div[@id='mBWrapper']/div[@id='root']/div[1]/div[2]/div[1]/div[2]/input[1]")
	public WebElement emailRelated;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Select Passengers')]")
	public WebElement selectpassenger;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Cancel your Ticket')]")
	public WebElement err;

	public void cancel() {
		manageBooking.click();
		cancelTicket.click();
	}

	public void fillDetailsCancel(String ticket, String email) {
		ticketNumber.sendKeys(ticket);
		emailRelated.sendKeys(email);
		selectpassenger.click();
	}

}
