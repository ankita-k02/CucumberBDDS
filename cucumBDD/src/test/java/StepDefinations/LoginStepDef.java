//package StepDefinations;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class LoginStepDef {
//	WebDriver driver;
//	
//	@Given("I open Browser and navigated to the url")
//	public void OpenAndNavigate() {
//		driver= new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
//		this.driver.manage().window().maximize();
//	    this.driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//	}
//
//	@And("I login to the application")
//	public void i_login_to_the_application() {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
//		WebElement username= driver.findElement(By.name("username"));
//		WebElement password= driver.findElement(By.name("password"));
//		WebElement LoginBtn= driver.findElement(By.xpath("//button[@type='submit']"));
//		
//		username.sendKeys("Admin");
//		password.sendKeys("admin123");
//		LoginBtn.click();
//	}
//
//	@When("I logged in sucessfully")
//	public void i_logged_in_sucessfully() {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
//	    WebElement dashboard= driver.findElement(By.xpath("//h6[text()='Dashboard']"));
//	    Assert.assertEquals("Dashboard", dashboard.getText());
//	}
//
//	@Then("I sucessfully navigated to the dashboard")
//	public void i_sucessfully_navigated_to_the_dashboard() {
//	    driver.quit();
//	}
//
//
//
//}
