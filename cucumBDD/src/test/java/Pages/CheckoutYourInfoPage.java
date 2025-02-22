package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class CheckoutYourInfoPage {
	WebDriver driver;
	By fname= By.id("first-name");
	By lname= By.id("last-name");
	By postalCode= By.id("postal-code");
	By continueBtn = By.id("continue");
	By titleElement = By.xpath("//span[@class='title']");
	By finishBtn = By.id("finish");
	By orderPlacedElement = By.xpath("//h2[text()='Thank you for your order!']");
	
	public CheckoutYourInfoPage(WebDriver driver) {
		this.driver=driver;
	}

	public void enterFirstName(String FirstName) {
		driver.findElement(fname).sendKeys(FirstName);
	}

	public void enterLastName(String LastName ) {
		driver.findElement(lname).sendKeys(LastName);
	}
	
	public void enterZipcode(String zipcode) {
		driver.findElement(postalCode).sendKeys(zipcode);
		
	}
	public void continueBtnClick() {
		driver.findElement(continueBtn).click();
	}
	
	public void verifyCheckoutOverviewPage() {
		String t = driver.findElement(titleElement).getText();
		SoftAssert a = new SoftAssert();
		a.assertEquals("Checkout: Overview", t);
	}
	public void finishBtnClick() {
		driver.findElement(finishBtn).click();
	}
	
	public void confirmOrder() {
		boolean e= driver.findElement(orderPlacedElement).isDisplayed();
		SoftAssert s = new SoftAssert();
		s.assertEquals(true, e);
	}

	
}
