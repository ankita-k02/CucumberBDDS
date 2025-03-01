package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class GreenKartPage {
	
	WebDriver driver;
	By greenKartlogo = By.cssSelector("div[class='brand greenLogo']");
	By cart =By.xpath("//img[@alt='Cart']");
	By addTocart= By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	By placeOrderbtn = By.xpath("//button[text()='Place Order']");
	By countrySelect = By.xpath("//select");
	By andorraValue = By.xpath("//select//option[@value='Andorra']");
	By termAndCond = By.xpath("//input[@class='chkAgree']");
	By proccedbtn = By.xpath("//button[text()='Proceed']");
	By thankyouOrderSuccess = By.xpath("//*[contains(text(),'Thank')]");
	
	By flightBooking = By.linkText("Flight Booking");

	public GreenKartPage(WebDriver driver) {
		this.driver=driver;		
	}
	
	public void verifyLogo() {
		if (driver.findElement(greenKartlogo).isDisplayed()) {
			Assert.assertTrue(true);
		}else
		{
			System.out.print("Page is not loaded");
			Assert.assertTrue(false);
		}
	}

	public void cartclick() {
		driver.findElement(cart).click();
	}
	
	public void addToCart() {
		driver.findElement(addTocart).click();
	}
	  
	public void placeOrder() {
		  driver.findElement(placeOrderbtn).click();
	}
	
	public void countrySelect(String count) throws InterruptedException {
		
		Select s= new Select(driver.findElement(countrySelect));
//		driver.findElement(countrySelect).click();
//		Thread.sleep(2000);
//		
//		WebElement val = driver.findElement(andorraValue);
//		
//		val.click();
		s.selectByVisibleText(count);
		
//		s.selectByValue(val);
	}
	
	public void acceptTerms() {
		driver.findElement(termAndCond).click();
	}
	
	public void proceedbtn() {
		driver.findElement(proccedbtn).click();
	}
    
	
	public void thankyouOrder() {
		driver.findElement(thankyouOrderSuccess).isDisplayed();
		
//		String pageSource = driver.getPageSource();
//		if (pageSource.contains("Thank")) {
//		    System.out.println("Text found on page.");
//		} else {
//		    System.out.println("Text NOT found!");
//		}
	}
	 public void flightBooking() {
		 driver.findElement(flightBooking).click();
	 }
}
