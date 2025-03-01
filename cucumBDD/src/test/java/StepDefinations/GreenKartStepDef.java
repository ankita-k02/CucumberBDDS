package StepDefinations;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.DriverManager;

import Pages.GreenKartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GreenKartStepDef {
	
	WebDriver driver = DriverManager.getDriver();
	GreenKartPage page;
	
	
	@Given("Launching the website")
	public void OpenGreenKart() {
//	   driver= new ChromeDriver();
	   driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	   page = new GreenKartPage(driver);
	}
	
	@And("Verify the Home Page")
	public void HomePageVerfication() {
		page.verifyLogo();
	}

	@When("Adding some vegetables in the cart")
	public void AddingProductsInCart() {
		
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
//		driver.findElement(By.xpath("//h4[contains(text(),\"Brocolli\")]/parent::div//button[text()='ADD TO CART']")).click();
		//1 array with all expected veg to be added
		String[] veg= {"Cucumber", "Beetroot", "Brocolli","Brinjal"};
		
		
		/////list of all available vegetables in the page
		List <WebElement> prod = driver.findElements(By.xpath("//h4[@class='product-name']"));
		int count = 0;
		for (int i=0; i<prod.size();i++) {
			
			
			String[] name= prod.get(i).getText().split("-");
			
			String fomratedName= name[0].trim(); 
		
			//trim the actual vegetable name - brocolli -1 kg
			//convert array veg into arraylist for easy search
			List<String> al= Arrays.asList(veg);
			
			
			if (al.contains(fomratedName)) { //name .contains("Cucumber")
				count++;
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				if (count==veg.length) {
					break;
				}
			}
			}
		  
		
	}

	@Then("I check out and select country as {string}")
	public void Checkout(String cname) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
		page.cartclick();
		page.addToCart();
		page.placeOrder();
		page.countrySelect(cname);
		page.acceptTerms();
		page.proceedbtn();
	    
	}

	@And("I verify order placed successfully")
	public void OrderPlaced() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	  page.thankyouOrder();
	  
	  
	}




}
