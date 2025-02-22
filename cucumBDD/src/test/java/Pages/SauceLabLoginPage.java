package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class SauceLabLoginPage {
	WebDriver driver;
	By username= By.cssSelector("#user-name");
	By password = By.cssSelector("#password");
	By loginbtn = By.id("login-button");
	By BackPackAdd = By.id("add-to-cart-sauce-labs-backpack");
	By titleElement = By.className("title");
	By shoppingCart = By.className("shopping_cart_link");
	By addedItem = By.className("inventory_item_name");
	By checkoutBtn = By.cssSelector("#checkout");
	
		public SauceLabLoginPage(WebDriver driver) {
		this.driver=driver;
		}
	
	public void enterUname(String uname ) {
		driver.findElement(username).sendKeys(uname);
//		WebElement form = driver.findElement(By.xpath("//form[@id='loginForm']")); 
//		WebElement button = form.findElement(By.xpath(".//button"));
		
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void loginClick() {
		driver.findElement(loginbtn).click();
	}
	
	public void verifyProductPage() {
		String ptext = driver.findElement(titleElement).getText();
		SoftAssert s = new SoftAssert();
		s.assertEquals("Products", ptext);

	}
	
	public void addingBackPack() {
		driver.findElement(BackPackAdd).click();
	}
	
	public void shoppingCartClick() {
		driver.findElement(shoppingCart).click();
		
	}
	
	public void verifyAddedItem() {
		String itemName = driver.findElement(addedItem).getText();
		SoftAssert ss = new SoftAssert();
		ss.assertEquals("Sauce Labs Backpack", itemName);
	}
	
	public void checkoutClick() {
		driver.findElement(checkoutBtn).click();
	}
	
}