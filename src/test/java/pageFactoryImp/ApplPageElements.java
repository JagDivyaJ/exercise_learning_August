package pageFactoryImp;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplPageElements {

	WebDriver driver;

	public ApplPageElements(WebDriver ddriver) {

		driver = ddriver;

		PageFactory.initElements(ddriver, this);

	}

	@FindBy(css = "input#Email")

	WebElement txt_email;

	@FindBy(css = "input#Password")

	WebElement txt_Pass;

	@FindBy(tagName = "button")

	WebElement btn_Login;
	
	@FindBy(how = How.XPATH, using="html[1]/body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/a[1]/p[1]/i[1]") 
	WebElement customers_menu;
	
	//@FindBy(how = How.XPATH, using="//p[text()[normalize-space()='Customers']]") 
	@FindBy(how = How.XPATH, using="//p[text()=' Customers']")
	WebElement customers;
	
	@FindBy(css = "input#SearchEmail")

	WebElement search_email;
	
	@FindBy(css = "button#search-customers")
	
	WebElement search_btn;
	
	@FindBy(xpath = "//table[@id='customers-grid']/tbody[1]/tr[1]/td[2]")
	
	WebElement result_email;
	
	@FindBy(partialLinkText = "ogou")

	WebElement btn_Logout;

	

	public void enterEmail(String email) {

		txt_email.clear();

		txt_email.sendKeys(email);

	}

	public void enterPass(String pwd) {

		txt_Pass.clear();

		txt_Pass.sendKeys(pwd);

	}

	public void clickLoginButton() {

		btn_Login.click();

	}

	public void verifyDashboardVisible(String expTitle) throws InterruptedException {

		Assert.assertEquals(driver.getTitle(), expTitle);

	}
	
	public void verifyCustURL(String expURL) throws InterruptedException {

		Assert.assertEquals(driver.getCurrentUrl(),expURL);

	}

	public void login(String email, String pass) {

		enterEmail(email);

		enterPass(pass);

		clickLoginButton();

	}
	
	public void clickCustomersMenu() {

		customers_menu.click();

	}
	
	public void clickCustomersMenuItem() {

		customers.click();

	}
	
	public void enterCustEmail(String email) {

		search_email.clear();

		search_email.sendKeys(email);

	}
	
	public void clickSearchbutton() throws Exception {

		//search_btn.click();
		clickOnEle(search_btn, 1000);
//		Thread.sleep(5000);

	}
	
	public void verifyResultEmail(String expEmail) throws InterruptedException {

		//new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='customers-grid']")));
		//new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='customers-grid']/tbody/tr/td")));
		
		Assert.assertEquals(result_email.getText(), expEmail);
		
	}
	
	public void clickOnEle(WebElement ele, int delay) throws Exception {
		
		ele.click();
		Thread.sleep(delay);
		
	}
	
	public void clickLogoutButton() {

		btn_Logout.click();

	}

}
